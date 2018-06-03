package com.revature.exceptions;

public class NegativeNumberException extends Exception{

	private static final long serialVersionUID = -8581833757471774534L;

	public NegativeNumberException() {
		super();
	}

	public NegativeNumberException(String arg0, Throwable arg1, boolean arg2, boolean arg3) {
		super(arg0, arg1, arg2, arg3);
	}

	public NegativeNumberException(String arg0, Throwable arg1) {
		super(arg0, arg1);
	}

	public NegativeNumberException(String arg0) {
		super(arg0);
	}

	public NegativeNumberException(Throwable arg0) {
		super(arg0);
	}
	
	

}
