package com.flymvc.core;

import java.util.List;

import com.flymvc.config.FlyConfig;
import com.flymvc.plugin.Plugin;
import com.flymvc.render.JspRender;
import com.flymvc.render.Render;
import com.flymvc.route.RouteMatcher;

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
	public abstract void route(RouteMatcher routeMatcher);
	
	/**
	 * 渲染器
	 * @param render
	 */
	public Render render() {
		return new JspRender();
	}
	
	/**
	 * 加载插件
	 * @return
	 */
	public void plugin(List<Plugin> plugins){}
	
}
