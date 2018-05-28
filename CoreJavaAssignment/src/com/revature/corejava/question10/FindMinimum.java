package com.revature.corejava.question10;

public class FindMinimum {

	// Private variables to hold the values needing to be compared
	private int one;
	private int two;
	
	// Constructor that calls the super and initializes the variables one and two
	public FindMinimum(int one, int two) {
		super();
		this.one = one;
		this.two = two;
	}
	
	// Setter to set the private variables one and two
	public void newNumbers(int one, int two) {
		this.one=one;
		this.two=two;
	}
	
	// Method to return the value of the smallest variable 
	
	// Returns the result of a ternary operator that checks if the one variable is less than the two variable,
	// if so, return the value of the one variable, else return the value of the two variable
	public int getMinimum() {
		return (one<two)?one:two;
	}
}
