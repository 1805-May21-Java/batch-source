package com.revature.exceptions;

//throws exceptions for actions animals cannot do because they're already dead

public class AnimalsAlreadyDead extends Exception{
	public AnimalsAlreadyDead() {
		super();
	}
	public AnimalsAlreadyDead(String message) {
		super(message);
	}
}
