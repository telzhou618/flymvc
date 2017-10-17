package com.flymvc.render;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Jsp 渲染实现
 * 
 * @author jameszhou
 *
 */
public class JspRender implements Render {

	private static String path = "/WEB-INF/views/";

	@Override
	public void render(HttpServletRequest request, HttpServletResponse response, String view) {
		try {

			String viePath = path + view + ".jsp";
			request.getRequestDispatcher(viePath).forward(request, response);
		} catch (ServletException | IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
