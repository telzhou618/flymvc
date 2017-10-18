package com.flymvc.config;

import com.flymvc.enums.Charset;

/**
 * 配置文件
 * 
 * @author jameszhou
 *
 */
public class Config {

	/**
	 * 模板地址
	 */
	private String viewPath = "/WEB-INF/views";

	/**
	 * 默认编码
	 */
	private Charset charset = Charset.UTF_8;

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
}