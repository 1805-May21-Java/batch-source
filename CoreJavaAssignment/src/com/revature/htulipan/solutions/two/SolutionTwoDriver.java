package com.revature.htulipan.solutions.two;

/*
 * Write a program to display the first 25 Fibonacci numbers beginning at 0.
 */

// FibonacciGenerator is written such that 0 is the 0th Fibonacci number

public class SolutionTwoDriver {

	public static void main(String[] args) {
		FibonacciGenerator fb = new FibonacciGenerator(25);
		for (int i = 0; i < 25; i++) {
			System.out.println(i+1 + "th: " + fb.getNth(i));
		}
	}
}
