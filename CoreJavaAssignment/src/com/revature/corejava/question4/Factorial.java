package com.revature.corejava.question4;

public class Factorial {
	// Variable n to hold the nth variable
	private int n;
	
	// Instantiate a new Factorial object by calling the super
	public Factorial() {
		super();
	}
	
	// Instantiate a new Factorial object by calling super and setting private variable n to the nth factorial 
	// value by calling the private method fact and using local variable n as the argument
	public Factorial(int n) {
		super();
		this.n=fact(n);
	}

	// Getter to return the private variable n
	public int getN() {
		return n;
	}

	// Setter to set the value of private variable n, to the nth factorial as given by the local variable n by 
	// calling the private method fact and using local variable n as the argument
	public void setN(int n) {
		this.n = fact(n);
	}
	
	/*
	 * Private method to find the nth factorial as determined by the value of n
	 * 
	 * Creates a local variable total and sets it to n
	 * 
	 * Sets a count variable to n-1
	 * 
	 * Runs a for loop that sets the total variable to itself times the value of the count variable
	 * 
	 * Loop stops once the count variable is equal to 1
	 */
	private int fact(int n) {
		int total=n;
		int count=n-1;
		while(count>1) {
			total*=count;
			count--;
		}
		
		return total;
	}
	
}
