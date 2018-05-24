package com.revature.algorithms;

public class Fibonacci {
	
	// phi is the golden ratio
	public static double PHI = (1 + Math.sqrt(5)) / 2;

	public Fibonacci() {
		super();
	}
	
	// Prints the first n Fibonacci numbers
	// I know the recursive form, I just wanted to use the golden ratio :)
	public static void printFibonacci(int n) {
		System.out.println("First " + n + " Fibonacci Numbers:");
		for(int i = 0; i < n; i++) {
			long fib = Math.round((Math.pow(PHI, i) - Math.pow(-PHI, -i)) / Math.sqrt(5));
			System.out.print(" " + fib);
		}
		System.out.println();
	}
}
