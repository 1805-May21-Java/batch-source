package com.revature.htulipan.solutions.six;

/*
 * Q6. Write a program to determine if an integer is even without using the modulus operator (%)
 */

public class SolutionSixDriver {

	public static void main(String[] args) {
		int[] testInts = {1, 2, 3, 4, 5, 0, -1, -2, -3, -4, -5};
		for (int i : testInts) {
			System.out.println(i + " is even: " + isEven(i));
		}
	}

	public static boolean isEven(int x) {
		return (1 & x) == 0;	
	}
}
