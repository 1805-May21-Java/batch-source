package com.revature.corejava;

/*
 * Q4 from Core Java Assignment
 * 
 * Write a program to compute N factorial.
 */
public class NFactorial 
{
	public static void main(String[] args) 
	{
		findFactorial(20);
	}
	
	//Computes the factorial of the give number.
	static void findFactorial(int num)
	{
		Long total = (long) 1;
		//Starts at 1 and multiplies the total times the index everytime it loops thru.
		for(int i = 1; i <= num; i++)
		{
			total *= i;
		}
		//Prints the result of the factorial method
		System.out.println("N Factorial of " + num + " is: " + total);
	}
	
}
