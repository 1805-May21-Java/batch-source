package com.revature.core_java_assignment.Question15;

public class Driver {

	public static void main(String[] args) {
		Calculator calculator = new Calculator();
		System.out.println("5 + 15 is " + calculator.addition(5, 15));
		System.out.println("10 - 15 is " + calculator.subtraction(10, 15));
	}
}
