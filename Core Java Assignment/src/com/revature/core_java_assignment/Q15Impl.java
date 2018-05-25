package com.revature.core_java_assignment;

public class Q15Impl implements Q15_Interface
{
	//auto generated a default constructor for use
	public Q15Impl()
	{
		super();
	}
	
	//overriding each interface methods with the appropriate math operands
	@Override
	public void addition(int num1, int num2)
	{
		int sum = num1 + num2;
		System.out.println(num1 +"+"+ num2 + " = "+sum);
	}
	
	@Override
	public void subtraction(int num1, int num2)
	{
		int sum = num1 - num2;
		System.out.println(num1 +"-"+ num2 + " = "+sum);
	}
	
	@Override 
	public void division(int num1, int num2)
	{
		//checking for division by 0 here
		//catching the error if it happens
		try
		{
			int sum = num1 / num2;
			System.out.println(num1 +"/"+ num2 + " = "+sum);

		}
		catch (NumberFormatException e)
		{
			System.out.println("Invalid input");
		}
	}
	
	@Override
	public void multiplication(int num1, int num2)
	{
		int sum = num1 * num2;
		System.out.println(num1 +"*"+ num2 + " = "+sum);
	}
}
