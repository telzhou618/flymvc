package com.flymvc.config;

import com.flymvc.core.BootStrap;
import com.flymvc.plugin.Plugins;
import com.flymvc.render.FreeMarkerRender;
import com.flymvc.render.Render;
import com.flymvc.route.Routes;
import com.flymvc.util.PluginUtil;

public class Fly {
	
	/**
	 * 配置
	 */
	private Config config;
	
	/**
	 * 路由
	 */
	private Routes routes;
	/**
	 * 渲染器
	 */
	private Render render;
	
	/**
	 * 插件
	 */
	private Plugins plugins;
	
	
	private static Fly  fly = null;

	public Config getConfig() {
		return config;
	}

	public void setConfig(Config config) {
		this.config = config;
	}

	public Routes getRoutes() {
		return routes;
	}

	public void setRoutes(Routes routes) {
		this.routes = routes;
	}

	public Render getRender() {
		return render;
	}

	public void setRender(Render render) {
		this.render = render;
	}
	
	public Plugins getPlugins() {
		return plugins;
	}

	public void setPlugins(Plugins plugins) {
		this.plugins = plugins;
	}

	/**
	 * 私有化构造
	 */
	private Fly() {
		this.config = new Config();
		this.routes = new Routes();
		this.render = new FreeMarkerRender();
		this.plugins = new Plugins();
	}
	
	/**
	 * 获取单例对象
	 * @param bootStrap 
	 * @return
	 */
	public static void init(BootStrap bootStrap) throws Exception{
		if(fly== null){
			fly = new Fly();
			bootStrap.config(fly.getConfig());
			bootStrap.plugin(fly.getPlugins());
			bootStrap.route(fly.getRoutes());
			fly.setRender(bootStrap.render());
			PluginUtil.initPlugins(fly.getPlugins());
		}
	}
	public static Fly me(){
		if(fly==null){
			throw new RuntimeException("fly is null");
		}
		return fly;
	}
}
