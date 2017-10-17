package com.flymvc.core;

import com.flymvc.config.Fly;
import com.flymvc.config.FlyConfig;

/**
 * 启动类
 * @author jameszhou
 *
 */
public abstract class BootStrap {

	/**
	 * 默认配置
	 * @param config
	 */
	public void config(FlyConfig config) {}

	/**
	 * 路由配置
	 * @param fly
	 */
	public abstract void start(Fly fly);
	
}
