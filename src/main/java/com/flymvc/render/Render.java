package com.flymvc.render;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * 渲染接口
 * @author jameszhou
 *
 */
public interface Render {

	void render(HttpServletRequest request,HttpServletResponse response, String view);

}
