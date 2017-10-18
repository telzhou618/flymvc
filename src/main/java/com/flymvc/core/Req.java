package com.flymvc.core;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * 请求对象
 * 
 * @author jameszhou
 *
 */
public class Req {

	public HttpServletRequest request;

	public HttpServletResponse response;

	public Req(HttpServletRequest request, HttpServletResponse response) {
		super();
		this.request = request;
		this.response = response;
	}

	public String  getAttr(String name) {
		return request.getParameter(name);
	}
	
	public Integer  getAttrToInt(String name) {
		return Integer.parseInt(request.getParameter(name));
	}

	public String[]  getAttrs(String name) {
		return request.getParameterValues(name);
	}
	
	public void  setAttr(String name,Object object) {
		request.setAttribute(name, object);
	}
}
