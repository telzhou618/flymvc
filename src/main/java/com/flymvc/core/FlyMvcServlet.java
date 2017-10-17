package com.flymvc.core;

import java.io.IOException;
import java.lang.reflect.Method;
import java.util.Map;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;

import com.flymvc.anno.ResponseBody;
import com.flymvc.render.Render;
import com.flymvc.route.Route;
import com.flymvc.util.AjaxUtil;
import com.flymvc.util.RefactUtil;

/**
 * 核心Servlet
 * 
 * @author jameszhou
 *
 */
public class FlyMvcServlet extends HttpServlet {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private Fly fly;

	private static final Logger logger = Logger.getLogger(FlyMvcServlet.class);

	@Override
	public void init(ServletConfig config) throws ServletException {
		// TODO Auto-generated method stub
		this.fly = Fly.me();
		String className = config.getInitParameter("bootstrap");
		BootStrap bootstrap = this.getBootStrap(className);
		bootstrap.init(fly);
		logger.info("FlyMvc init success!");
	}

	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		request.setCharacterEncoding("UTF-8");
		response.setCharacterEncoding("UTF-8");
		
		String uri = request.getRequestURI();
		Map<String, String[]> parameterMap = request.getParameterMap();

		logger.debug("Uri : " + uri);
		logger.debug("Parameters : " + parameterMap);
		
		Route route = fly.getRouteMap().getRoute(uri);
		Render render = fly.getRender();

		if (route != null) {

			Method method = route.getMethod();
			Object controller = route.getController();
			Object result = RefactUtil.invoke(request,response,method,controller,parameterMap);
			ResponseBody responseBody = method.getAnnotation(ResponseBody.class);
			
			if (responseBody != null) {
				AjaxUtil.render(request, response,result);
			} else {
				render.render(request, response, result.toString());
			}
		}else{
			response.sendError(404, "NotFind");
		}
	}

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

	public Fly getFly() {
		return fly;
	}

	public void setFly(Fly fly) {
		this.fly = fly;
	}
}
