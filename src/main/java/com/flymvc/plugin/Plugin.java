package com.flymvc.plugin;

import com.flymvc.exception.PluginException;

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
	public boolean start() throws PluginException;
	
	/**
	 * 停止插件
	 * @return
	 */
	public boolean stop() throws PluginException;
	
	
}
