package com.revature.assignment;

public class Q15 implements Mathy {
	
	//Q15. Write a program that defines an interface having the following methods: addition, subtraction, multiplication, and division.  
	//Create a class that implements this interface and provides appropriate functionality to carry out the required operations. 
	//Hard code two operands in a test class having a main method that calls the implementing class.

	//Q15 implements Mathy interface which has the 4 math operation methods
	//Q15 methods overrides those methods and takes two operands to work on
	
	@Override
	public void addition(double a, double b) {
		System.out.println(a + b);
	}

	@Override
	public void subtraction(double a, double b) {
		System.out.println(a-b);
	}

	@Override
	public void multiply(double a, double b) {
		System.out.println(a*b);
	}

	@Override
	public void division(double a, double b) {
		System.out.println(a/b);
	}

	/*Driver Code
	Q15 q = new Q15();
	q.addition(4, 5);
	q.subtraction(10, 4);
	q.multiply(3, 9);
	q.division(10, 4);*/
	
	
}
