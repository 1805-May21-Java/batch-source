package com.revature.exceptions;
//Custom Exception that occurs when a user attempts to manipulate a dead animal
public class DeadAnimalException extends Exception {

	public DeadAnimalException() {
		super();
	}

	public DeadAnimalException(String message, Throwable cause, boolean enableSuppression,
			boolean writableStackTrace) {
		super(message, cause, enableSuppression, writableStackTrace);
	}

	public DeadAnimalException(String message, Throwable cause) {
		super(message, cause);
	}

	public DeadAnimalException(String message) {
		super(message);
	}

	public DeadAnimalException(Throwable cause) {
		super(cause);
	}

}
