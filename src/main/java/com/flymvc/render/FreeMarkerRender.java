package com.flymvc.render;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * FreeMarker 渲染实现
 * 
 * @author jameszhou
 *
 */
public class FreeMarkerRender implements Render {


	@Override
	public void render(HttpServletRequest request, HttpServletResponse response, String view) {
		System.out.println("hahah");
	}
}
