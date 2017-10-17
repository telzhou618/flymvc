package com.flymvc.route;

import java.util.HashSet;
import java.util.Set;

public class RouteMap {
	
	private static Set<Route> routes = new HashSet<Route>(); 
	
	/**
	 * 查询route
	 * @param uri
	 * @return
	 */
	public Route getRoute(String uri){
		for(Route route : routes){
			 if(route.getUri().equalsIgnoreCase(uri)){
				 return route;
			 }
		}
		return null;
	}
	
	public void addRoute(Route route){
		routes.add(route);
	}

}
