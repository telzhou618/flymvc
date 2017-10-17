package com.flymvc.config;

import com.flymvc.enums.Charset;
import com.flymvc.enums.ViewType;

/**
 * 配置文件
 * @author jameszhou
 *
 */
public class FlyConfig {
	
	/**
	 * 模板地址
	 */
	private String viewPath = "/WEB-INF/views";
	/**
	 * 默认编码
	 */
	private Charset charset = Charset.UTF_8;
	
	/**
	 * 默认视图
	 */
	private ViewType viewType = ViewType.JSP;
	
	
	public String getViewPath() {
		return viewPath;
	}

	public void setViewPath(String viewPath) {
		this.viewPath = viewPath;
	}

	public Charset getCharset() {
		return charset;
	}

	public void setCharset(Charset charset) {
		this.charset = charset;
	}

	public ViewType getViewType() {
		return viewType;
	}

	public void setViewType(ViewType viewType) {
		this.viewType = viewType;
	}
	
}
