package com.revature.main;

/**
 * This class is created regarding Question 4 to calculate n factorial
 *In the method we use for loop to iterate from 1 to n inclusively
 *By doing for loop other than recursion, we can save us from stack overflow.
 */
public class Factorial 
{

	public Factorial() 
	{
		super();
	}
	
	public static long  calculate(int number)
	{
		long result = 1;
		for(int i=1; i<number+1; i++)
		{
				result = result*i;
		}

		return result;
	}
	

}
