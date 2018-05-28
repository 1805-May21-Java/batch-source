package com.revature.corejava;

public class ImplementingClass implements MathInterface {

	public int addition(int a, int b) {
		return a + b;
	}

	public int subtraction(int a, int b) {
		return a - b;
	}

	public int multiplication(int a, int b) {
		return a * b;
	}

	public double division(int a, int b) {
		return ((double) a) / b;
	}

}
