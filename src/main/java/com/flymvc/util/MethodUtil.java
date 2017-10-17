package com.flymvc.util;

import java.lang.reflect.Method;

public class MethodUtil {

	/**
	 * 根据方法名称获取指定类的第一个方法，不支持重载
	 * @param controller
	 * @param methodName
	 * @return
	 * @throws NoSuchMethodException
	 */
	public static Method getMethod(Class<?> controller, String methodName) throws NoSuchMethodException {
		// TODO Auto-generated method stub
		Method[] methods = controller.getMethods();
		for(Method method : methods){
			if(method.getName().equals(methodName)){
				return method;
			}
		}
		throw new NoSuchMethodException();
	}

}
