package com.flymvc.core;

import java.lang.reflect.Method;

import com.flymvc.config.FlyConfig;
import com.flymvc.render.JspRender;
import com.flymvc.render.Render;
import com.flymvc.route.Route;
import com.flymvc.route.RouteMap;
import com.flymvc.util.MethodUtil;

public class Fly {
	
	private static Fly  fly = null;
	
	/**
	 * 配置文件
	 */
	private FlyConfig flyConfig;
	/**
	 * 路由
	 */
	private RouteMap routeMap;
	
	private Render render;
	
	public FlyConfig getFlyConfig() {
		return flyConfig;
	}

	public void setFlyConfig(FlyConfig flyConfig) {
		this.flyConfig = flyConfig;
	}

	public RouteMap getRouteMap() {
		return routeMap;
	}

	public void setRouteMap(RouteMap routeMap) {
		this.routeMap = routeMap;
	}
	
	public Render getRender() {
		return render;
	}

	public void setRender(Render render) {
		this.render = render;
	}

	/**
	 * 私有化构造
	 */
	private Fly() {
		this.flyConfig = new FlyConfig();
		this.routeMap = new RouteMap();
		this.render = new JspRender();
	}
	
	/**
	 * 获取单例对象
	 * @return
	 */
	public static Fly me(){
		if(fly== null){
			fly = new Fly();
		}
		return fly;
	}
	
	public void addRoute(String uri,Object controller,String methodName){
		try {
			Method method = MethodUtil.getMethod(controller.getClass(), methodName);
			if(routeMap.getRoute(uri)!=null){
				throw new RuntimeException(controller.getClass().getSimpleName()+"."+method.getName()+"() ethod too more.");
			}
			this.routeMap.addRoute(new Route(uri, controller, method));
		} catch (NoSuchMethodException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public void addRoute(String uri,Object controller){
		Method[] methods = controller.getClass().getDeclaredMethods();
		for(Method method : methods){
			this.addRoute(uri + "/" +method.getName(), controller, method.getName());
		}
	}
	
}
