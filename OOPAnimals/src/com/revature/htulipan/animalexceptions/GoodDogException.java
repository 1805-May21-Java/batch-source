package com.revature.htulipan.animalexceptions;

public class GoodDogException extends Exception{
	private String message;
	
	public GoodDogException() {
		super();
		this.message = "There is no such thing as a bad dog.";
	}
	
	public GoodDogException(String message) {
		super();
		this.message = message;
	}
	
	public String getMessage() {
		return message;
	}
}
