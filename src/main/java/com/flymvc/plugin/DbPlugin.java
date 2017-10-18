package com.flymvc.plugin;

import org.apache.log4j.Logger;

public class DbPlugin implements Plugin{
	
	private String driver;
	
	private String username;
	
	private String password;
	
	private String ur;
	
	private static Logger logger = Logger.getLogger(DbPlugin.class);
	
	@Override
	public boolean start() {
		// TODO Auto-generated method stub
		//实现数据库链接
		logger.debug("DbPlugin init success!");
		return true;
	}

	@Override
	public boolean stop() {
		// TODO Auto-generated method stub
		return true;
	}

	public String getDriver() {
		return driver;
	}

	public void setDriver(String driver) {
		this.driver = driver;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getUr() {
		return ur;
	}

	public void setUr(String ur) {
		this.ur = ur;
	}

	public DbPlugin() {
		super();
		// TODO Auto-generated constructor stub
	}

	public DbPlugin(String driver, String username, String password, String ur) {
		super();
		this.driver = driver;
		this.username = username;
		this.password = password;
		this.ur = ur;
	}
}
