package com.flymvc.interceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.flymvc.exception.InterceptorException;

/**
 * 抽象拦截器
 * @author jameszhou
 *
 */
public abstract class  AbstractInterceptor implements Interceptor{

	/**
	 * 方法调用之前执行
	 * @param request
	 * @param response
	 * @param object
	 * @return
	 * @throws InterceptorException
	 */
	public boolean before(HttpServletRequest request,HttpServletResponse response,Object object) throws InterceptorException {
		return true;
	}
	/**
	 * 方法调用之后执行
	 * @param request
	 * @param response
	 * @param object
	 * @return
	 * @throws InterceptorException
	 */
	public boolean after(HttpServletRequest request,HttpServletResponse response,Object object) throws InterceptorException{
		return true;
	}

}
