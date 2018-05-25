package com.revature.question15;

public class Calculator implements Operands
{
	public Calculator()
	{
		super();
	}

	@Override
	public double add(double v1, double v2)
	{
		return v1 + v2;
	}

	@Override
	public double subtract(double v1, double v2)
	{
		return v1 - v2;
	}

	@Override
	public double multiply(double v1, double v2)
	{
		return v1 * v2;
	}

	@Override
	public double divide(double v1, double v2) throws IllegalArgumentException
	{
		try
		{
			return v1/v2;
		}
		catch(IllegalArgumentException e)
		{
			System.out.println("Can't divide by zero");
			return -1;
		}
	}

}
