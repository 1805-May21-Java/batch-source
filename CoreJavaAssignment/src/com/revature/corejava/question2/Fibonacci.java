package com.revature.corejava.question2;

public class Fibonacci {
	// Variable to hold the nth Fibonacci number
	private int result;

	// Constructor to create new instance of Fibonacci class
	public Fibonacci() {
		super();
	}
	
	// Constructor to create instance and define the result variable using the private method fib
	public Fibonacci(int length) {
		super();
		this.result = fib(length);
	}
	
	// Setter that sets the result variable
	public void newLength(int length) {
		this.result=fib(length);
	}
	
	// Getter that returns the result variable
	public int getResult() {
		return result;
	}
	
	/*
	 * Method for calculating the nth Fibbonacci number
	 * Variable result holds the result
	 * Variable last holds the last number in the sequence
	 * Variable hold is a temporary holding place for the value of result
	 * Loops by decrementing the length variable until it reaches 1, then returns the result
	 */
	private int fib(int length) {
		int result=1;
		int last=0;
		int hold;
		while(length>1) {
			hold=result;
			result+=last;
			last=hold;
			length--;
		}
		return result;
	}
	
	
	
	
}
