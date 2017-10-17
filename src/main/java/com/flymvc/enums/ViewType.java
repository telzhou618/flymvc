package com.flymvc.enums;

/**
 * 视图类型
 * @author jameszhou
 *
 */
public enum ViewType {
	JSP("jsp"), FreeMarker("freemarker");

	private String value;
	

	public String getValue() {
		return value;
	}



	public void setValue(String value) {
		this.value = value;
	}



	private ViewType(String value) {
		this.value = value;
	}
}
