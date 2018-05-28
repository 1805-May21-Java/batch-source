package com.revature.corejava;

public class Q15InterfaceDriver {

	public static void main(String[] args) {
		
		ImplementingClass ic = new ImplementingClass();
		
		// declare two operands
		int a = 12;
		int b = 4;
		
		System.out.println("Addition: " + ic.addition(a, b));
		System.out.println("Subtraction: " + ic.subtraction(a, b));
		System.out.println("Multiplication: " + ic.multiplication(a, b));
		System.out.println("Division: " + ic.division(a, b));

	}

}
