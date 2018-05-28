package com.revature.corejava;

/*
 * Q15 from Core Java Assignment
 * 
 * Write a program that defines an interface having the following methods:
 * addition, subtraction, multiplication, and division.
 * Create a class that implements this interface and provides appropriate functionality to carry out the required operations.
 * Hard code two operands in a test class having a main method that calls the implementing class.
 */

public interface MathInterface 
{

	int addition(int i1, int i2);
	int subtraction(int i1, int i2);
	int multiplication(int i1, int i2);
	int division(int i1, int i2);	
	
}
