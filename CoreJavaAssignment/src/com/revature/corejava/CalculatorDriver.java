package com.revature.corejava;
//Q15
public class CalculatorDriver {
//Driver for the calculator class with 2 hard-coded numbers/operands
	public static void main(String[] args) {
		int a=6518, b=432;
		Calculator calculator = new Calculator();
		System.out.println("Addition: "+calculator.add(a, b));
		System.out.println("Subtraction: "+ calculator.subtract(a, b));
		System.out.println("Multiplication: "+calculator.multiply(a, b));
		System.out.println("Division: "+calculator.divide(a, b));
	}

}
