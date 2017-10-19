package com.flymvc.exception;

/**
 * 插件异常
 * @author jameszhou
 *
 */
public class FlyException extends Exception{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public FlyException() {
		super();
		// TODO Auto-generated constructor stub
	}

	public FlyException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
		super(message, cause, enableSuppression, writableStackTrace);
		// TODO Auto-generated constructor stub
	}

	public FlyException(String message, Throwable cause) {
		super(message, cause);
		// TODO Auto-generated constructor stub
	}

	public FlyException(String message) {
		super(message);
		// TODO Auto-generated constructor stub
	}

	public FlyException(Throwable cause) {
		super(cause);
		// TODO Auto-generated constructor stub
	}
	
	
}
