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
	
	/**
	 * 添加路由
	 * @param uri
	 * @param controller
	 * @param methodName
	 */
	public void addRoute(String uri,Class<?> controller,String methodName){
		try {
			Object object =	 controller.newInstance(); //有弊端，实例化对象多了
			try {
				//Method method= controller.getMethod(methodName); //xxx
				Method method= MethodUtil.getMethod(controller,methodName);
				this.routeMap.addRoute(new Route(uri, object, method));
			} catch (NoSuchMethodException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		  
		} catch (InstantiationException | IllegalAccessException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
}
