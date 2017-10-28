package com.flymvc.interceptor;

import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;

/**
 * 拦截集合
 * @author jameszhou
 *
 */
public class Interceptors {
	
	private static Logger logger = Logger.getLogger(Interceptors.class);

	private List<Interceptor> interceptors ;

	public Interceptors() {
		this.interceptors = new ArrayList<Interceptor>();
	}
	
	public void add(Interceptor interceptor){
		this.interceptors.add(interceptor);
		logger.debug("add interceptor ["+interceptor.getClass().getName()+"]");
	}

	public List<Interceptor> getInterceptors() {
		return interceptors;
	}
	
}
