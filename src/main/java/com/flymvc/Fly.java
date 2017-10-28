package com.flymvc;

import org.apache.log4j.Logger;

import com.flymvc.config.Config;
import com.flymvc.interceptor.Interceptors;
import com.flymvc.plugin.Plugins;
import com.flymvc.render.FreeMarkerRender;
import com.flymvc.render.Render;
import com.flymvc.route.Routes;
import com.flymvc.util.PluginUtil;
/**
 * 配置
 * @author jameszhou
 *
 */
public class Fly {
	
	private static Logger logger = Logger.getLogger(Fly.class);
	
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
	
	/**
	 * 拦截器集合
	 */
	private Interceptors interceptors;
	/**
	 * fly
	 */
	private static Fly  fly ;
	
	/**
	 * 是否已初始化
	 */
	private static boolean isInit = false;

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
	
	public Interceptors getInterceptors() {
		return interceptors;
	}

	public void setInterceptors(Interceptors interceptors) {
		this.interceptors = interceptors;
	}

	/**
	 * 私有化构造
	 */
	private Fly() {
		this.config = new Config();
		this.routes = new Routes();
		this.render = new FreeMarkerRender();
		this.plugins = new Plugins();
		this.interceptors = new Interceptors();
	}
	
	
	public void init(BootStrap bootStrap) throws Exception{
		if(!isInit){
			bootStrap.config(fly.getConfig());
			bootStrap.plugin(fly.getPlugins());
			bootStrap.route(fly.getRoutes());
			fly.setRender(bootStrap.render());
			PluginUtil.initPlugins(fly.getPlugins());
			bootStrap.interceptor(fly.getInterceptors());
			isInit = true;
			logger.debug("fly init finish .");
		}
	}
	
	/**
	 * 获取单例对象
	 * @param bootStrap 
	 * @return
	 */
	public static Fly me(){
		if(fly == null){
			fly = new Fly();
			logger.debug("please init fly ?");
		}
		return fly;
	}
}
