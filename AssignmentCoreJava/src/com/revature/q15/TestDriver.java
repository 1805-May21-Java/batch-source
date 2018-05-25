package com.revature.q15;

public class TestDriver {
	static public void main(String[] args) {
		Calculator calculator = new Calculator();
		System.out.println(calculator.addition(3, 10));
		System.out.println(calculator.subtraction(3, 10));
		System.out.println(calculator.multiplication(3, 10));
		System.out.println(calculator.division(3, 10));
	}
}
