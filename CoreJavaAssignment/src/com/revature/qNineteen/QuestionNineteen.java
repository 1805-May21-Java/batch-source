package com.revature.qNineteen;

import java.util.ArrayList;

public class QuestionNineteen
{
	public void removePrimes(ArrayList<Integer> values)
	{
		for(int i = 0; i < values.size(); i++)
		{
			//The value at the index will change if the value is removed, so keep checking
			//until it is no longer prime
			while(isPrime(values.get(i)))
			{
				values.remove(i);
			}
		}
		System.out.println(values);
	}
	
	public QuestionNineteen()
	{
		super();
		// TODO Auto-generated constructor stub
	}

	public void printTotals(ArrayList<Integer> values)
	{
		int evenTotal = 0;
		int oddTotal = 0;
		
		for(Integer value : values)
		{
			if((value % 2) == 0)
				evenTotal += value;
			else
				oddTotal += value;
		}
		
		System.out.println("Total of the even numbers: " + evenTotal);
		System.out.println("Total of the odd numbers: " + oddTotal);
	}
	
	public boolean isPrime(Integer value)
	{
		if(value == 1 || value == 2)
			return true;
		
		for(int i = 2; i < value; i++)
		{
			if((value % i) == 0)
			{
				return false;
			}
		}
		
		return true;
	}
}
