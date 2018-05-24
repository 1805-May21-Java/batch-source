package com.revature.algorithms;

public class Factorial {

	public Factorial() {
		super();
	}

	// iteratively calculates n!
	public static int nFactorial(int n) {
		int fact = 1;
		for(int i = 2; i <= n; i++) {
			fact *= i;
		}
		return fact;
	}
}
