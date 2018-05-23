package com.revature.htulipan.animalexceptions;

public class FishOutOfWaterException extends Exception {
	private String message;
	
	public FishOutOfWaterException() {
		super();
		message = "Fish belong underwater!";
	}
	
	public FishOutOfWaterException(String message) {
		super();
		this.message = message;
	}
	
	public String getMessage() {
		return message;
	}
}
