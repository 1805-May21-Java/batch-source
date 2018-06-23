package com.revature.exceptions;

public class NoSuchOptionException extends Exception{
	
	private static final long serialVersionUID = -2067686952907926654L;

	public NoSuchOptionException() {
		super();
	}

	public NoSuchOptionException(String message, Throwable cause, boolean enableSuppression,
			boolean writableStackTrace) {
		super(message, cause, enableSuppression, writableStackTrace);
	}

	public NoSuchOptionException(String message, Throwable cause) {
		super(message, cause);
	}

	public NoSuchOptionException(String message) {
		super(message);
	}

	public NoSuchOptionException(Throwable cause) {
		super(cause);
	}
	
	

}
