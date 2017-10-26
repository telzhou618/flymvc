package com.flymvc.interceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.flymvc.exception.InterceptorException;

/**
 * 拦截器接口
 * @author jameszhou
 *
 */
public interface Interceptor {

	/**
	 * 方法调用之前执行
	 * @param request
	 * @param response
	 * @param object
	 * @return
	 * @throws InterceptorException
	 */
	public boolean before(HttpServletRequest request,HttpServletResponse response,Object object) throws InterceptorException;
	/**
	 * 方法调用之后执行
	 * @param request
	 * @param response
	 * @param object
	 * @return
	 * @throws InterceptorException
	 */
	public boolean after(HttpServletRequest request,HttpServletResponse response,Object object) throws InterceptorException;

}
