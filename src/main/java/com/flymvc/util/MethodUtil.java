package com.flymvc.util;

import java.lang.reflect.Method;

public class MethodUtil {

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
