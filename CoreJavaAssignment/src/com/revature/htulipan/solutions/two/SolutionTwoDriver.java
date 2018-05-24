package com.revature.htulipan.solutions.two;

/*
 * Write a program to display the first 25 Fibonacci numbers beginning at 0.
 */
public class SolutionTwoDriver {

	public static void main(String[] args) {
		FibonacciGenerator fb = new FibonacciGenerator(25);
		for (int i = 0; i <= 25; i++) {
			System.out.println(i + "th: " + fb.getNth(i));
		}
	}
}
