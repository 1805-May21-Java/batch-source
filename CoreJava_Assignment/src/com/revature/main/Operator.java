package com.revature.main;


/**
 * This is our concrete class that's used to implement from Arithetic interface with addition, substraction, multiplication and division.
 *All of these methods take two inputs to operate. 
 */
public class Operator implements Arithmetic
{

	public Operator()
	{
		super();
	}

	@Override
	public double addition(double a, double b)
	{
		
		return a+b;
	}

	@Override
	public double substraction(double a, double b)
	{
		
		return a-b;
	}

	@Override
	public double division(double a, double b)
	{
		
		return a/b;
	}

	@Override
	public double multiplication(double a, double b)
	{
		
		return a*b;
	}

	

}
