package com.revature.corejava.question15;

public class TestDriver {
	
	public static void main(String[] args) {
		
		// Initialize two constants operandOne and operandTwo
		final int operandOne=10;
		final int operandTwo=5;
		
		// Create new instance of BasicMath class
		BasicMath bm = new BasicMath();
		
		// Check Addition method, should return 15
		System.out.println("Addition Example");
		System.out.println(bm.addition(operandOne, operandTwo));
		System.out.println();
		
		// Check Multiplication method, should return 50
		System.out.println("Multiplication Example");
		System.out.println(bm.multiplication(operandOne, operandTwo));
		System.out.println();
		
		// Check Subtraction method, should return 5
		System.out.println("Subtraction Example");
		System.out.println(bm.subtraction(operandOne, operandTwo));
		System.out.println();
		
		// Check Division method, should return 2
		System.out.println("Division Example");
		System.out.println(bm.division(operandOne, operandTwo));
	}

}
