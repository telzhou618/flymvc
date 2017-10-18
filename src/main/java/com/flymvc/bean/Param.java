package com.flymvc.bean;

/**
 * 参数
 * @author jameszhou
 *
 */
public class Param {

	/**
	 * 参数名称
	 */
	private String name;
	/**
	 * 参数类型
	 */
	private Class<?> clazz;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Class<?> getClazz() {
		return clazz;
	}

	public void setClazz(Class<?> clazz) {
		this.clazz = clazz;
	}

	public Param(String name, Class<?> clazz) {
		super();
		this.name = name;
		this.clazz = clazz;
	}

	public Param() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
}
