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
 * 
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

			switch (clssName) {

			case "Integer":
				if (values != null && values.length > 0) {
					try {
						object = Integer.parseInt(values[0]);
					} catch (NumberFormatException e) {
						// TODO Auto-generated catch block
						throw new NumberFormatException(param.getName() + " must be Integer type");
					}
				}
				break;
			case "Float":
				if (values != null && values.length > 0) {
					try {
						object = Float.parseFloat(values[0]);
					} catch (NumberFormatException e) {
						// TODO Auto-generated catch block
						throw new NumberFormatException(param.getName() + " must be Float type");
					}
				}
				break;
			case "Double":
				if (values != null && values.length > 0) {
					try {
						object = Double.parseDouble(values[0]);
					} catch (NumberFormatException e) {
						// TODO Auto-generated catch block
						throw new NumberFormatException(param.getName() + " must be Double type");
					}
				}
				break;
			case "int":
				if (values != null && values.length > 0) {
					try {
						object = Integer.parseInt(values[0]);
					} catch (NumberFormatException e) {
						// TODO Auto-generated catch block
						throw new NumberFormatException(param.getName() + " must be int type");
					}
				} else {
					throw new NumberFormatException(param.getName() + " must be int type");
				}
				break;
			case "float":
				if (values != null && values.length > 0) {
					try {
						object = Float.parseFloat(values[0]);
					} catch (NumberFormatException e) {
						// TODO Auto-generated catch block
						throw new NumberFormatException(param.getName() + " must be float type");
					}
				} else {
					throw new NumberFormatException(param.getName() + " must be float type");
				}
				break;
			case "double":
				if (values != null && values.length > 0) {
					try {
						object = Double.parseDouble(values[0]);
					} catch (NumberFormatException e) {
						// TODO Auto-generated catch block
						throw new NumberFormatException(param.getName() + " must be double type");
					}
				} else {
					throw new NumberFormatException(param.getName() + " must be double type");
				}
				break;
			case "Boolean":
				if (values != null && values.length > 0) {
					try {
						object = Boolean.parseBoolean(values[0]);
					} catch (NumberFormatException e) {
						// TODO Auto-generated catch block
						throw new NumberFormatException(param.getName() + " must be Boolean type");
					}
				}
				break;
			case "boolean":
				if (values != null && values.length > 0) {
					try {
						object = Boolean.parseBoolean(values[0]);
					} catch (NumberFormatException e) {
						// TODO Auto-generated catch block
						throw new NumberFormatException(param.getName() + " must be boolean type");
					}
				} else {
					throw new NumberFormatException(param.getName() + " must be boolean type");
				}
				break;
			default:
				object = (values != null && values.length > 0) ? values[0] : null;
				break;
			}
		}
		return object;
	}
}
