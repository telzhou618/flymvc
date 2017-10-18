package com.flymvc.util;

import java.util.List;

import com.flymvc.exception.PluginException;
import com.flymvc.plugin.Plugin;

public class PluginUtil {

	public static void initPlugins(List<Plugin> plugins) {
		// TODO Auto-generated method stub
		for(Plugin plugin : plugins){
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
	
	public static void stopPlugins(List<Plugin> plugins) {
		// TODO Auto-generated method stub
		for(Plugin plugin : plugins){
			stopPlugin(plugin);
		}
	}

}
