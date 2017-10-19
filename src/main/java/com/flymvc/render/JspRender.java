package com.flymvc.render;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.flymvc.Fly;

/**
 * Jsp 渲染实现
 * 
 * @author jameszhou
 *
 */
public class JspRender implements Render {

	@Override
	public void render(HttpServletRequest request, HttpServletResponse response, String view) {
		try {
			
			String viePath = Fly.me().getConfig().getViewPath() + "/"+view + ".jsp";
			request.getRequestDispatcher(viePath).forward(request, response);
		} catch (ServletException | IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
