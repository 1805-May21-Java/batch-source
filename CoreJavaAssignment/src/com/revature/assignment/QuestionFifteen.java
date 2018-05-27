package com.revature.assignment;

import com.revature.background.QuestionFifteenInterface;

//implement interface
public class QuestionFifteen implements QuestionFifteenInterface{
	
	public static void main(String[] args) {
		
		//create an instance and call methods
		QuestionFifteen q = new QuestionFifteen();
		System.out.println(q.add(16,44));
		System.out.println(q.subtract(67, 24));
		System.out.println(q.multiply(6, 12));
		System.out.println(q.divide(27, 3));
		
	}

	//add the integers
	@Override
	public int add(int a, int b) {
		System.out.print(a+" + "+b+" = ");
		return a+b;
	}

	//subtract the integers
	@Override
	public int subtract(int a, int b) {
		System.out.print(a+" - "+b+" = ");
		return a-b;
	}

	//multiply the integers
	@Override
	public int multiply(int a, int b) {
		System.out.print(a+" * "+b+" = ");
		return a*b;
	}

	//divide the integers if b is not 0
	@Override
	public int divide(int a, int b) {
		
		try {
			System.out.print(a+" / "+b+" = ");
			return a/b;
		} catch (ArithmeticException e) {
			System.out.println("Cannot divide by zero");
			return 0;
		}
	}

}
