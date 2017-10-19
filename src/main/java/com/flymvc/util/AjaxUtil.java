package com.flymvc.util;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

/**
 * ajax工具类
 * @author jameszhou
 *
 */
public class AjaxUtil {

	private static GsonBuilder builder = new GsonBuilder();
	
	public static void render(HttpServletRequest request, HttpServletResponse response, Object result) {
		// TODO Auto-generated method stub
		try {
			PrintWriter writer = response.getWriter();
			Gson gson = builder.create();
			writer.write(gson.toJson(result));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
