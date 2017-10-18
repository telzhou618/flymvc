package com.flymvc.plugin;

import java.util.ArrayList;
import java.util.List;

/**
 * 保存插件集合
 * 
 * @author jameszhou
 *
 */
public class Plugins {

	private List<Plugin> plugins;

	public void add(Plugin plugin) {
		plugins.add(plugin);
	}

	public List<Plugin> getPlugins() {
		return plugins;
	}

	public Plugins() {
		this.plugins = new ArrayList<Plugin>();
	}
	
}
