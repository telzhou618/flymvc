package com.flymvc.util;

public class StringUtil {

	/**
	 * 获取字符串后缀
	 * @param str
	 * @return
	 */
	public static String getExt(String str) {
		int t = str.lastIndexOf(".");
		if (t != -1) {
			return str.substring(t);
		}
		return null;
	}

}
