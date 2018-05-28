package com.revature.corejava.question15;

public class BasicMath implements BasicMathOperations{

	// Constructor that calls to the super class
	public BasicMath() {
		super();
	}

	// Override addition method and makes it so that it returns the sum of two int variables operandOne and operandTwo
	@Override
	public int addition(int operandOne, int operandTwo) {
		return operandOne+operandTwo;
	}
	
	// Override subtraction method and makes it so that it returns the difference of two int variables operandOne and operandTwo
	@Override
	public int subtraction(int operandOne, int operandTwo) {
		return operandOne-operandTwo;
	}

	// Override multiplication method and makes it so that it returns the product of two int variables operandOne and operandTwo
	@Override
	public int multiplication(int operandOne, int operandTwo) {
		return operandOne*operandTwo;
	}

	// Override division method and makes it so that it returns the quotient of two int variables operandOne and operandTwo
	@Override
	public int division(int operandOne, int operandTwo) {
		return operandOne/operandTwo;
	}

}
