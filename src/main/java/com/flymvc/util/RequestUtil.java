package com.flymvc.util;

import java.util.Date;
import java.util.Enumeration;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.lang3.time.DateFormatUtils;

import com.flymvc.Req;
import com.flymvc.bean.Param;

/**
 * 注入Request,Response对象工具类
 * @author jameszhou
 *
 */
public class RequestUtil {

	public static void checkInject(HttpServletRequest request, HttpServletResponse response, List<Param> params,
			Object[] args) {
		for (int i = 0; i < params.size(); i++) {
			if (params.get(i).getClazz() == HttpServletRequest.class) {
				args[i] = request;
			} else if(params.get(i).getClazz() == HttpServletResponse.class){
				args[i] = response;
			}else if(params.get(i).getClazz() == Req.class){
				args[i] = new Req(request, response);
			}
		}

	}

	public static Object logParamers(HttpServletRequest request) {
		// TODO Auto-generated method stub
		
		StringBuffer sb = new StringBuffer("[");
		Enumeration<String> enumeration =  request.getParameterNames();
		while(enumeration.hasMoreElements()){
			String name = enumeration.nextElement();
			sb.append(name).append("=").append(request.getParameter(name)).append(",");
		}
		sb.deleteCharAt(sb.length()-1);
		sb.append("]");
		return "\nUri："+request.getRequestURI()
			+"\nParameters：" + sb.toString()
			+"\nDatetime：" +  DateFormatUtils.format(new Date(), "yyyy-MM-dd HH:mm:sss")
		+"\n---------------------------------------";
	}

}
