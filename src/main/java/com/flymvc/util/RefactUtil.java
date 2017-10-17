package com.flymvc.util;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.flymvc.bean.Param;

public class RefactUtil {

	public static Object invoke(HttpServletRequest request, HttpServletResponse response, Method method,Object bean, Map<String, String[]> parameterMap) {
		// TODO Auto-generated method stub
		Object result = null;
		try {
			if (method.getParameters().length == 0) {
				result = method.invoke(bean);
			} else {
				List<Param> params = ParameterUtil.parseParams(method,bean);
				Object[] objects =  ParameterUtil.parseValues(params,parameterMap);
				//检查注入request,response对象
				RequestUtil.checkInject(request,response,params,objects);
				result = method.invoke(bean, objects);
			}
		} catch (IllegalAccessException | IllegalArgumentException | InvocationTargetException e) {
			// TODO Auto-generated catch block
			throw new RuntimeException(e);
		}

		return result;
	}

}
