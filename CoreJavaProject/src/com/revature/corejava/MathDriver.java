package com.revature.corejava;

/*
 * Q15 from Core Java Assignment
 * 
 * Write a program that defines an interface having the following methods:
 * addition, subtraction, multiplication, and division.
 * Create a class that implements this interface and provides appropriate functionality to carry out the required operations.
 * Hard code two operands in a test class having a main method that calls the implementing class.
 */
public class MathDriver
{

	public static void main(String[] args) 
	{
		//I use my 2 hard coded integers to demonstrate the functionality of my mathInterface
		MathImpl math = new MathImpl();
		int num1 = 24;
		int num2 = 6;
		System.out.println( num1 + " + " + num2 + " = " + math.addition(num1, num2));
		System.out.println(num1 + " - " + num2 + " = " + math.subtraction(num1, num2));
		System.out.println(num1 + " * " + num2 + " = " + math.multiplication(num1, num2));
		System.out.println(num1 + " / " + num2 + " = " + math.division(num1, num2));
		
	}

}
