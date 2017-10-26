package com.flymvc.interceptor;

import java.lang.reflect.Method;

import com.flymvc.render.Render;

/**
 * 模型渲染器
 * 
 * @author jameszhou
 *
 */
public class ModelRender {
	/**
	 * 当前model
	 */
	private Object controller;
	/**
	 * 当前要执行的方法
	 */
	private Method method;
	/**
	 * 当前渲染器
	 */
	private Render render;

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

	public Render getRender() {
		return render;
	}

	public void setRender(Render render) {
		this.render = render;
	}

	public ModelRender() {
		// TODO Auto-generated constructor stub
	}

	public ModelRender(Object controller, Method method, Render render) {
		this.controller = controller;
		this.method = method;
		this.render = render;
	}

}
