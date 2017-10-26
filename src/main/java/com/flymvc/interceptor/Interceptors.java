package com.flymvc.interceptor;

import java.util.ArrayList;
import java.util.List;

/**
 * 拦截集合
 * @author jameszhou
 *
 */
public class Interceptors {

	private List<Interceptor> interceptors ;

	public Interceptors() {
		this.interceptors = new ArrayList<Interceptor>();
	}
	
	public void add(Interceptor interceptor){
		this.interceptors.add(interceptor);
	}

	public List<Interceptor> getInterceptors() {
		return interceptors;
	}
	
}
