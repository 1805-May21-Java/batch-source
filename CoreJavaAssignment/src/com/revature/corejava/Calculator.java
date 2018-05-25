package com.revature.corejava;
//Q15
public class Calculator implements CalculatorInt {
//Implements the CalculatorInt Interface
	@Override
	public int add(int a, int b) {
		return a+b;
	}

	@Override
	public int subtract(int a, int b) {
		return a-b;
	}

	@Override
	public int multiply(int a, int b) {
		return a*b;
	}

	@Override
	public int divide(int a, int b) {
		return a/b;
	}

	
}
