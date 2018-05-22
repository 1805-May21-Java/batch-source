package com.revature.hw1;

public class NegativeLimbException extends Exception{
	//made to handle negative values if they are entered for an animal's limbs.
	public NegativeLimbException(){
		super();
	}
	
	public NegativeLimbException(String message){
		super(message);
	}
}