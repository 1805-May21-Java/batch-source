package com.adora.testinterface15;

public class Arithemetic implements ArithmeticInterface{

	
	public Arithemetic() {
		super();
		// TODO Auto-generated constructor stub
	}

	@Override
	public int addition(int a, int b) {
		return a + b;
	}

	@Override
	public int subtraction(int a, int b) {
		return a - b;
	}

	@Override
	public int multiplication(int a, int b) {
		// TODO Auto-generated method stub
		return a * b;
	}

	@Override
	public float division(int a, int b) {
		// TODO Auto-generated method stub
		return (float) a / (float) b;
	}

	
}
