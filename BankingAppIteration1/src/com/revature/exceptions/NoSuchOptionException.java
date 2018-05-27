package com.revature.exceptions;

/*
 * 
 * Exception used when the user tries to input an option that's not on the list
 * 
 */
public class NoSuchOptionException extends Exception{

	private static final long serialVersionUID = -2067686952907926654L;

	public NoSuchOptionException() {
		super();
	}

	public NoSuchOptionException(String arg0, Throwable arg1, boolean arg2, boolean arg3) {
		super(arg0, arg1, arg2, arg3);
	}

	public NoSuchOptionException(String arg0, Throwable arg1) {
		super(arg0, arg1);
	}

	public NoSuchOptionException(String arg0) {
		super(arg0);
	}

	public NoSuchOptionException(Throwable arg0) {
		super(arg0);
	}
	
}
