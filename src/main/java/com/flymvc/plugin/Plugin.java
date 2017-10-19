package com.flymvc.plugin;

import com.flymvc.exception.FlyException;

/**
 * 插件接口
 * @author jameszhou
 *
 */
public interface Plugin {

	/**
	 * 启动插件
	 * @return
	 */
	public boolean start() throws FlyException;
	
	/**
	 * 停止插件
	 * @return
	 */
	public boolean stop() throws FlyException;
	
	
}
