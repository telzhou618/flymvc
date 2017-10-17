package com.flymvc.enums;

/**
 * 编码类型
 * @author jameszhou
 *
 */
public enum Charset {
	
	UTF_8("utf-8"), GBK("gbk");

	private String value;
	

	public String getValue() {
		return value;
	}



	public void setValue(String value) {
		this.value = value;
	}



	private Charset(String value) {
		this.value = value;
	}
}
