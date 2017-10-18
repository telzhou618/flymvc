package com.flymvc.route;

import java.lang.reflect.Method;
import java.util.HashSet;
import java.util.Set;

import com.flymvc.util.MethodUtil;

public class Routes {

	private Set<Route> routes;

	public void addRoute(Route route) {
		this.routes.add(route);
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

	public void addRoute(String uri, Object controller) {
		Method[] methods = controller.getClass().getDeclaredMethods();
		for (Method method : methods) {
			this.addRoute(uri + "/" + method.getName(), controller, method.getName());
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
