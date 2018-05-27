package com.revature.main;


/**
 * This class is created regarding Question 6 that requires us not to use % to implement even or odd
 * In this isEvent() method we use bitwise & to check if it is even or odd. 
 * Ex. In binary 0001001 with last digit 1 is odd
 * 001000 with last digit 0 is even.
 */
public class IsEven
{
	
	public IsEven()
	{
		super();
		// TODO Auto-generated constructor stub
	}

	public static boolean isEven(int i)
	{
		if((i&1) == 0 )
		{
			return true;
		}
		
		return false;
		
	}
	
}
