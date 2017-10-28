package com.flymvc.route;

import java.lang.reflect.Method;
import java.util.HashSet;
import java.util.Set;

import org.apache.log4j.Logger;

import com.flymvc.util.MethodUtil;

/**
 * 路由集合
 * @author jameszhou
 *
 */
public class Routes {
	
	private static Logger logger = Logger.getLogger(Routes.class);

	private Set<Route> routes;

	public void addRoute(Route route) {
		this.routes.add(route);
		logger.debug("uri:["+route.getUri()+"],ctrm:["+route.getController().getClass().getName()+"."+route.getMethod().getName()+"()]");
	}

	
	public void addRoute(String uri, Class<?> clazz, String methodName) {
		try {
			Object controller = clazz.newInstance();
			Method method = MethodUtil.getMethod(controller.getClass(), methodName);
			if (this.getRoute(uri) != null) {
				throw new RuntimeException(
						controller.getClass().getSimpleName() + "." + method.getName() + "() ethod too more.");
			}
			this.addRoute(new Route(uri, controller, method));
		} catch (NoSuchMethodException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (InstantiationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public void addRoute(String uri, Object controller, String methodName) {
		try {
			Method method = MethodUtil.getMethod(controller.getClass(), methodName);
			if (this.getRoute(uri) != null) {
				throw new RuntimeException(
						controller.getClass().getSimpleName() + "." + method.getName() + "() ethod too more.");
			}
			this.addRoute(new Route(uri, controller, method));
		} catch (NoSuchMethodException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public void addRoute(String uri, Class<?> clazz) {
		try {
			Object controller = clazz.newInstance();
			Method[] methods = clazz.getDeclaredMethods();
			for (Method method : methods) {
				if(uri.equals("/")){
					this.addRoute(uri  + method.getName(), controller, method.getName());
				}else{
					this.addRoute(uri + "/" + method.getName(), controller, method.getName());
				}
			}
		} catch (InstantiationException | IllegalAccessException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	/**
	 * 查询route
	 * 
	 * @param uri
	 * @return
	 */
	public Route getRoute(String uri) {
		for (Route route : this.routes) {
			if (route.getUri().equalsIgnoreCase(uri)) {
				return route;
			}
		}
		return null;
	}

	public Routes() {
		this.routes = new HashSet<Route>();
	}

}
