package com.revature.q15;

public class Question implements Operation {

	@Override
	public int addition(int int1, int int2) {
		int sum = int1 + int2;
		return sum;
		
	}

	@Override
	public int subtraction(int int1, int int2) {
		int difference = int1 - int2;
		return difference;
	}

	@Override
	public int multiplcation(int int1, int int2) {
		int product = int1 * int2;
		return product;
	}

	@Override
	public int division(int int1, int int2) {
		int quotient = int1 / int2;
		return quotient;
	}

}
