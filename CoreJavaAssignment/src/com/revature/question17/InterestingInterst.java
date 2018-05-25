package com.revature.question17;

import java.util.Scanner;

public class InterestingInterst
{
	Scanner sc = new Scanner(System.in);
	
	public InterestingInterst()
	{
		super();
	}

	public void calculateInterest()
	{
		System.out.print("Please enter the principle: " );
		double principle = getDouble();
		System.out.println();
		
		System.out.print("Please enter the rate as a decimal: ");
		double rate = getDouble();
		System.out.println();
		
		System.out.print("Please enter the time in years: ");
		double time = getDouble();
		System.out.println();
		
		
		System.out.println("The interest is: " + principle * rate * time);
	}
	
	public double getDouble()
	{
		double num;
		try
		{
			num = sc.nextDouble();
			return num;
		}
		catch(NumberFormatException e)
		{
			System.out.println("Please enter a number: ");
			return getDouble();
		}
	}

}
