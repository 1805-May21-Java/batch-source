package com.revature.htulipan.solutions.fifteen;

/*
 * Q15. Write a program that defines an interface having the following methods: addition, subtraction, multiplication, and division.  Create a class that implements this interface and provides appropriate functionality to carry out the required operations. Hard code two operands in a test class having a main method that calls the implementing class.
 */

public class SolutionFifteenDriver {
	
	public static void main(String[] args) {
		CalculatorWatch cw = new CalculatorWatch();
		cw.addition(48.32, 19.432);
		cw.multiplication(1.3);
		cw.division(2.4);
		cw.subtraction(72.743);
	}
}
