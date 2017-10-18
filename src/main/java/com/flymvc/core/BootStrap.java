package com.flymvc.core;

import java.util.ArrayList;
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
	public FlyConfig config() {
		
		return new FlyConfig();
	}

	/**
	 * 路由配置
	 * @param fly
	 */
	public abstract RouteMatcher routeMatcher();
	
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
	public List<Plugin> plugins(){
		return new ArrayList<Plugin>();
	}
	
}
