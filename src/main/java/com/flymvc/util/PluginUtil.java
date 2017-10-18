package com.flymvc.util;

import com.flymvc.exception.PluginException;
import com.flymvc.plugin.Plugin;
import com.flymvc.plugin.Plugins;

public class PluginUtil {

	public static void initPlugins(Plugins plugins) {
		// TODO Auto-generated method stub
		for(Plugin plugin : plugins.getPlugins()){
			initPlugin(plugin);
		}
	}
	
	public static void initPlugin(Plugin plugin) {
		// TODO Auto-generated method stub
		try {
			plugin.start();
		} catch (PluginException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public static void stopPlugin(Plugin plugin) {
		// TODO Auto-generated method stub
		try {
			plugin.stop();
		} catch (PluginException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public static void stopPlugins(Plugins plugins) {
		// TODO Auto-generated method stub
		for(Plugin plugin : plugins.getPlugins()){
			stopPlugin(plugin);
		}
	}

}
