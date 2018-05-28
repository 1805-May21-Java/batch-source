package com.revature.corejava;

/*
 * Q15 from Core Java Assignment
 * 
 * Write a program that defines an interface having the following methods:
 * addition, subtraction, multiplication, and division.
 * Create a class that implements this interface and provides appropriate functionality to carry out the required operations.
 * Hard code two operands in a test class having a main method that calls the implementing class.
 */
public class MathImpl implements MathInterface 
{

	
	
	public MathImpl() 
	{
		super();
	}

	@Override
	public int addition(int i1, int i2) 
	{
		return i1 + i2;
	}

	@Override
	public int subtraction(int i1, int i2) 
	{
		return i1 - i2;
	}

	@Override
	public int multiplication(int i1, int i2) 
	{
		return i1 * i2;
	}

	@Override
	public int division(int i1, int i2) 
	{
		if(i2 == 0)
			 throw new IllegalArgumentException("Cannot divide by 0");
		else
			return i1 / i2;
		
	}

}
