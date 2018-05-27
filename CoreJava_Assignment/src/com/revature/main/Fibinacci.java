package com.revature.main;


/**
 * This class is created regarding Question 2
 * we use recursive function to implement the function 
 * We gave the initial state n<=1 and call the function itself until number reach less or equals to 1;
 *
 */
public class Fibinacci 
{

	public Fibinacci() {
		super();
	}
	
	public static long calculate(int number)
	{
		if(number<=1) return number;
		return calculate(number-1)+calculate(number-2);
	}

}
