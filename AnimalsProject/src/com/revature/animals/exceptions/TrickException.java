package com.revature.animals.exceptions;

public class TrickException extends Exception {
//	Throws exception if animal cannot learn anymore tricks
	public TrickException() {
		super();
	}
	
	public TrickException(String message) {
		super(message);
	}
}
