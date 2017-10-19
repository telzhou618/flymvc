package com.flymvc;

import com.flymvc.config.Config;
import com.flymvc.plugin.Plugins;
import com.flymvc.render.FreeMarkerRender;
import com.flymvc.render.Render;
import com.flymvc.route.Routes;

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
	public void config(Config config) {}

	/**
	 * 路由配置
	 * @param fly
	 */
	public abstract void route(Routes routeMatcher);
	
	/**
	 * 渲染器
	 * @param render
	 */
	public Render render() {
		return new FreeMarkerRender();
	}
	
	/**
	 * 加载插件
	 * @return
	 */
	public void plugin(Plugins plugins){}
	
}
