package com.revature.exception;

public class NegativeLengthException extends Exception {

	String message;
	
	public NegativeLengthException() {
		super();
		this.message = "This value must be positive.";
	}

	public NegativeLengthException(String message) {
		super();
		this.message = message;
	}
}
