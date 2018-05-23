package com.revature.exceptions;

//Located in com.revature.exceptions package
//Custom Exception used in Golden Retriever Class
public class TennisBallsException extends Exception {
	
	public TennisBallsException() {
		super();
	}

	public TennisBallsException(String message) {
		super(message);
	}
}
