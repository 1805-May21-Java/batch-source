package com.revature.algorithms;

public class Mins {

	public Mins() {
		super();
	}
	
	// finds the min of a and b using the ternary operator and prints a resulting message
	public static void ternaryMin(double a, double b) {
		double min = (a < b) ? a : b;
		System.out.println("Comparing " + a + " and " + b + ": " + min + " is the min");
	}
}
