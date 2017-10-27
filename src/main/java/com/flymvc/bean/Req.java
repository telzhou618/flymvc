package com.flymvc.bean;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * 请求对象
 * 
 * @author jameszhou
 *
 */
public class Req {

	public HttpServletRequest request;

	public HttpServletResponse response;
	
	private HttpSession session;

	public Req(HttpServletRequest request, HttpServletResponse response) {
		this.request = request;
		this.response = response;
		this.session = request.getSession();
	}

	/*************************request*********************************/
	public String  getPara(String name) {
		return request.getParameter(name);
	}
	
	public Integer  getParaToInt(String name) {
		try {
			return Integer.parseInt(request.getParameter(name));
		} catch (NumberFormatException e) {
			// TODO Auto-generated catch block
			throw new NumberFormatException( name +" must be integer type");
		}
	}

	public Float  getParaToFloat(String name) {
		try {
			return Float.parseFloat(request.getParameter(name));
		} catch (NumberFormatException e) {
			// TODO Auto-generated catch block
			throw new NumberFormatException( name +" must be float type");
		}
	}

	public Double  getParaToDouble(String name) {
		try {
			return Double.parseDouble(request.getParameter(name));
		} catch (NumberFormatException e) {
			// TODO Auto-generated catch block
			throw new NumberFormatException( name +" must be double type");
		}
	}
	
	public String[]  getParas(String name) {
		return request.getParameterValues(name);
	}
	
	public void  addAttr(String name,Object object) {
		request.setAttribute(name, object);
	}
	
	/*************************session*********************************/
	
	public String  getSessionSeAttr(String name) {
		return session.getAttribute(name).toString();
	}
	
	public Integer  getSessionAttrToInteger(String name) {
		return (Integer) session.getAttribute(name);
	}

	public Float  getSessionAttrToFloat(String name) {
		return  (Float) session.getAttribute(name);
	}

	public Double  getSessionAttrToDouble(String name) {
		return  (Double) session.getAttribute(name);
	}
	
	/*************************model*********************************/
}
