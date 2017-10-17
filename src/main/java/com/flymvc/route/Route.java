package com.flymvc.route;

import java.lang.reflect.Method;

/**
 * 路由
 * 
 * @author jameszhou
 *
 */
public class Route {

	/**
	 * 请求URI
	 */
	private String uri;

	/**
	 * 控制器
	 */
	private Object controller;

	/**
	 * 要调用的目标方法
	 */
	private Method method;

	public String getUri() {
		return uri;
	}

	public void setUri(String uri) {
		this.uri = uri;
	}

	public Object getController() {
		return controller;
	}

	public void setController(Object controller) {
		this.controller = controller;
	}

	public Method getMethod() {
		return method;
	}

	public void setMethod(Method method) {
		this.method = method;
	}

	public Route() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Route(String uri, Object controller, Method method) {
		super();
		this.uri = uri;
		this.controller = controller;
		this.method = method;
	}

}
