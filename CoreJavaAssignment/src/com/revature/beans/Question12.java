package com.revature.beans;

public class Question12
{
	public static void main(String[] args)
	{
		int[] values = new int[100];
		for(int i = 1; i <= 100; i++)
		{
			values[i - 1] = i;
		}
		
		for(int number : values)
		{
			if((number % 2) == 0)
			{
				System.out.println(number);
			}
		}
	}
}
