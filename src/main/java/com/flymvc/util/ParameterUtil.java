package com.flymvc.util;

import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import com.flymvc.bean.Param;

import javassist.ClassPool;
import javassist.CtClass;
import javassist.CtMethod;
import javassist.NotFoundException;
import javassist.bytecode.CodeAttribute;
import javassist.bytecode.LocalVariableAttribute;
import javassist.bytecode.MethodInfo;

/**
 * 参数解析工具类
 * @author jameszhou
 *
 */
public class ParameterUtil {

	/**
	 * 解析方法的参数
	 * 
	 * @param method
	 * @param controller
	 * @return
	 */
	public static List<Param> parseParams(Method method, Object bean) {
		// TODO Auto-generated method stub

		Class<?>[] parameterTypes = method.getParameterTypes();
		List<Param> list = new ArrayList<Param>();
		ClassPool pool = ClassPool.getDefault();

		try {
			CtClass cc = pool.get(bean.getClass().getName());
			CtMethod cm = cc.getDeclaredMethod(method.getName());
			// 使用javaassist的反射方法获取方法的参数名
			MethodInfo methodInfo = cm.getMethodInfo();
			CodeAttribute codeAttribute = methodInfo.getCodeAttribute();
			LocalVariableAttribute attr = (LocalVariableAttribute) codeAttribute
					.getAttribute(LocalVariableAttribute.tag);
			int pos = Modifier.isStatic(cm.getModifiers()) ? 0 : 1;
			for (int i = 0; i < cm.getParameterTypes().length; i++) {
				list.add(new Param(attr.variableName(i + pos), parameterTypes[i]));
			}

		} catch (NotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return list;
	}

	/**
	 * 设置参数的值
	 * 
	 * @param paramSet
	 * @param parameterMap
	 * @return
	 */
	public static Object[] parseValues(List<Param> params, Map<String, String[]> parameterMap) {
		// TODO Auto-generated method stub
		List<Object> list = new ArrayList<Object>();
		for (Param param : params) {
			String[] values = parameterMap.get(param.getName());
			list.add(setValues(param, values));
		}
		return list.toArray();
	}

	/**
	 * 参数类型转换
	 * 
	 * @param param
	 * @param values
	 * @return
	 */
	private static Object setValues(Param param, String[] values) {
		// TODO Auto-generated method stub
		Object object = null;
		String clssName = param.getClazz().getSimpleName();
		if (!param.getClazz().isArray()) { // 忽略数组类型
			if (clssName.equalsIgnoreCase("Integer") || clssName.equalsIgnoreCase("int")) {
				object = Integer.parseInt((values != null) ? values[0] : "0");
			} else if (clssName.equalsIgnoreCase("Float") || clssName.equalsIgnoreCase("float")) {
				object = Float.parseFloat((values != null) ? values[0] : "0");
			} else if (clssName.equalsIgnoreCase("Double") || clssName.equalsIgnoreCase("double")) {
				object = Double.parseDouble((values != null) ? values[0] : "0");
			} else if (clssName.equalsIgnoreCase("String")) {
				object = (values != null) ? values[0] : null;
			}
		}
		return object;
	}
}
