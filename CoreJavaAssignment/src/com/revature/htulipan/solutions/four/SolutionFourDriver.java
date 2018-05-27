package com.revature.htulipan.solutions.four;

/*
 * Q4. Write a program to compute N factorial.
 */

public class SolutionFourDriver {

	public static void main(String[] args) {
		FactorialGenerator fg = new FactorialGenerator();
		
		for (int i = 1; i <= 10; i++) {
			fg.setN(i);
			System.out.println(fg.findFactorial());
		}
	}
	
}
