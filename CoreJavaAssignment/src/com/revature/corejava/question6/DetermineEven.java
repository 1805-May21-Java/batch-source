package com.revature.corejava.question6;

public class DetermineEven {
	
	// Variable for holding the number
	private int number;
	
	// Instantiate Object by calling the super class
	public DetermineEven() {
		super();
	}

	// Create Constructor that takes an integer argument to store in the private variable number
	public DetermineEven(int number) {
		super();
		this.number = number;
	}

	// Getter to return the number
	public int getNumber() {
		return number;
	}

	// Setter to set the private variable number to the local variable number
	public void setNumber(int number) {
		this.number = number;
	}
	
	/*
	 * Method for checking if the stored number in the private variable number is even
	 * 
	 * First if converts the private variable number to a String and stores it in a local variable named String
	 * 
	 * A Switch Case then uses the last character at the end of the string number to check if it is an even number
	 * (0,2,4,6,8).
	 * 
	 * If it is an even number, the method returns true
	 * 
	 * Else, it returns false
	 */
	public boolean checkEven() {
		String number=String.valueOf(this.number);
		switch(number.charAt(number.length()-1)) {
		case '0':
		case '2':
		case '4':
		case '6':
		case '8':
			return true;
		default:
			return false;
		}
	}
	
	
	
	

}
