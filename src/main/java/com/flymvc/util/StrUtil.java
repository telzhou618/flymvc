package com.flymvc.util;

public class StrUtil {

	public static String getExt(String str) {
		int t = str.lastIndexOf(".");
		if (t != -1) {
			return str.substring(t);
		}
		return null;
	}

}
