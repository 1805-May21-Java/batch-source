package com.revature.exceptions;

public class NegativeAgeException extends Exception {
	public NegativeAgeException() {
		super();
	}
	
	public NegativeAgeException(String message) {
		super(message);
	}
}
