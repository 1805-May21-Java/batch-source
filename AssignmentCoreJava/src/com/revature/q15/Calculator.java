package com.revature.q15;

public class Calculator implements BasicOperations{
	
	//Since this class implements basic operations, it needs to implement these methods
	@Override
	public int addition(int a, int b) {
		return a+b;
	}

	@Override
	public int subtraction(int a, int b) {
		return a-b;
	}

	@Override
	public int multiplication(int a, int b) {
		return a*b;
	}

	@Override
	public int division(int a, int b) throws Exception {
		if(b == 0) {
			throw new Exception();
		}
		return a/b;
	}

}
