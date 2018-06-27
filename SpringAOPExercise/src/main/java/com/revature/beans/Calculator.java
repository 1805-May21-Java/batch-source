package com.revature.beans;

import java.util.Scanner;

import org.springframework.stereotype.Component;

@Component
public class Calculator {

	Scanner sc = new Scanner(System.in);
	
	public double addition(double num1, double num2) {
		double result = num1+num2;
		return result;
	}
	
	public double subtraction(double num1, double num2) {
		double result = num1-num2;
		return result;
	}
	
	public double multiplication(double num1, double num2) {
		double result = num1 * num2;
		return result;
	}
	
	public double division(double num1, double num2) {
		double result = num1 / num2;
		return result;
	}
	
	public int getOperation() {
		System.out.println();
		System.out.println("Please select your operation!");
		System.out.println("-->Enter 1 for addition");
		System.out.println("-->Enter 2 for subtraction");
		System.out.println("-->Enter 3 for multiplication");
		System.out.println("-->Enter 4 for division");
		int operation = Integer.parseInt(sc.nextLine());
		return operation;
	}
	
	public double getNum1() {
		System.out.println("Enter your first number:");
		double num1 = Double.parseDouble(sc.nextLine());
		return num1;
	}
	
	public double getNum2() {
		System.out.println("Enter your second number:");
		double num2 = Double.parseDouble(sc.nextLine());
		return num2;
	}
}
