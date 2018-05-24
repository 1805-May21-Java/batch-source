package com.revature.question4;

import java.util.*;

import com.revature.sharedfunctionality.intGetter;

public class Factorial extends intGetter
{
	Scanner sc = new Scanner(System.in);
	
	public Factorial()
	{
		super();
	}
	
	public void findFactorial()
	{
		System.out.print("Please enter an integer: ");
		int value = getInt();
		int result = value;
		
		for(int i = value - 1; i > 0; i--)
		{
			result *= i;
		}
		
		System.out.println(value + "! = " + result);
	}
}
