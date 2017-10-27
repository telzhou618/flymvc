package com.flymvc.util;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class RefactUtil {

	/**
	 * 反射执行方法
	 * @param method
	 * @param bean
	 * @param args
	 * @return
	 */
	public static Object invoke(Method method,Object bean,Object[] args) {
		// TODO Auto-generated method stub
		Object result = null;
		try {
			if (method.getParameters().length == 0) {
				result = method.invoke(bean);
			} else {
				result = method.invoke(bean,args);
			}
		} catch (IllegalAccessException | IllegalArgumentException | InvocationTargetException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return result;
	}

}
