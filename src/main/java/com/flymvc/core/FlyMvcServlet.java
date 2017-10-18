package com.flymvc.core;

import java.io.IOException;
import java.lang.reflect.Method;
import java.util.List;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;

import com.flymvc.anno.ResponsJson;
import com.flymvc.bean.Param;
import com.flymvc.config.Fly;
import com.flymvc.render.Render;
import com.flymvc.route.Route;
import com.flymvc.util.AjaxUtil;
import com.flymvc.util.ParameterUtil;
import com.flymvc.util.RefactUtil;
import com.flymvc.util.RequestUtil;

/**
 * 核心Servlet
 * 
 * @author jameszhou
 *
 */
public class FlyMvcServlet extends HttpServlet {

	private static final long serialVersionUID = 1L;

	private static final Logger logger = Logger.getLogger(FlyMvcServlet.class);

	private Fly fly = null;
	
	/**
	 * 初始化
	 */
	@Override
	public void init(ServletConfig config) throws ServletException {
		// TODO Auto-generated method stub
		String className = config.getInitParameter("bootstrap");
		BootStrap bootStrap = this.getBootStrap(className);
		try {
			Fly.init(bootStrap);
			fly = Fly.me();
			logger.info("FlyMvc init success!");
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	/**
	 * 拦截所有请求
	 */
	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		//设置变编码
		request.setCharacterEncoding(fly.getConfig().getCharset().getValue());
		response.setCharacterEncoding(fly.getConfig().getCharset().getValue());
		
		logger.debug(RequestUtil.logParamers(request));
		
		String uri = request.getRequestURI();
		Route route = fly.getRoutes().getRoute(uri);
		if(route != null){
			doFlyService(request, response, route);
		} else{
			response.sendError(404, "NotFound");
		}
		
	}

	private void doFlyService(HttpServletRequest request, HttpServletResponse response, Route route) throws IOException {
		Render render = fly.getRender();
		Method method = route.getMethod();
		Object controller = route.getController();
		//解析出参数名称及类型
		List<Param> params = ParameterUtil.parseParams(method,controller);
		//反射设置参数的值
		Object[] args =  ParameterUtil.parseValues(params,request.getParameterMap());
		//注入request,response对象
		RequestUtil.checkInject(request,response,params,args);
		//执行invoke
		Object result = RefactUtil.invoke(method,controller,args);
		//处理执行结果
		ResponsJson responseJson = method.getAnnotation(ResponsJson.class);
		if (responseJson != null) {
			AjaxUtil.render(request, response,result);
		} else {
			render.render(request, response, result.toString());
		}
	}
	/**
	 * 实例化bootstrap对象
	 * @param className
	 * @return
	 */
	private BootStrap getBootStrap(String className) {
		if (null != className) {
			try {
				Class<?> clazz = Class.forName(className);
				BootStrap bootstrap = (BootStrap) clazz.newInstance();
				return bootstrap;
			} catch (ClassNotFoundException e) {
				throw new RuntimeException(e);
			} catch (InstantiationException e) {
				e.printStackTrace();
			} catch (IllegalAccessException e) {
				e.printStackTrace();
			}
		}
		throw new RuntimeException("init BootStrap class error!");
	}
}
