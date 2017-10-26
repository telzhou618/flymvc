package com.flymvc.util;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.flymvc.exception.InterceptorException;
import com.flymvc.interceptor.Interceptor;
import com.flymvc.interceptor.Interceptors;
import com.flymvc.interceptor.ModelRender;

/**
 * 拦截器执行工具类
 * 
 * @author jameszhou
 *
 */
public class InterceptorUtil {

	public static boolean executeBefore(HttpServletRequest request, HttpServletResponse response,
			Interceptors interceptors, ModelRender modelRender) {

		for (Interceptor interceptor : interceptors.getInterceptors()) {
			try {
				boolean b = interceptor.before(request, response, modelRender);
				if (!b) {
					return false;
				}
			} catch (InterceptorException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				return false;
			}
		}
		return true;
	}

	public static boolean executeAfter(HttpServletRequest request, HttpServletResponse response,
			Interceptors interceptors, ModelRender modelRender) {

		List<Interceptor> list = interceptors.getInterceptors();
		for (int i = list.size() - 1; i >= 0; i--) {
			try {
				boolean b = list.get(i).after(request, response, modelRender);
				if (!b) {
					return false;
				}
			} catch (InterceptorException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				return false;
			}
		}
		return true;

	}

}
