package com.flymvc.util;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.flymvc.bean.Param;

/**
 * 注入Request,Response对象工具类
 * @author jameszhou
 *
 */
public class RequestUtil {

	public static void checkInject(HttpServletRequest request, HttpServletResponse response, List<Param> params,
			Object[] objects) {
		for (int i = 0; i < params.size(); i++) {
			if (params.get(i).getClazz() == HttpServletRequest.class) {
				objects[i] = request;
			} else if(params.get(i).getClazz() == HttpServletResponse.class){
				objects[i] = response;
			}
		}

	}

}
