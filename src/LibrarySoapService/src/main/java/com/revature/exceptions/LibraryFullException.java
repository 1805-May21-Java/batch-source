package com.revature.exceptions;

public class LibraryFullException extends Exception {
	
	private String message = "BANNED.";
	
	public LibraryFullException() {
		super();
	}
	
	public LibraryFullException(String message) {
		super(message);
	}

}
