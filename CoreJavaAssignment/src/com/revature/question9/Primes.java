package com.revature.question9;

import java.util.ArrayList;

public class Primes
{
	public Primes()
	{
		super();
	}

	public void printPrimes(ArrayList<Integer> values)
	{
		for(int value : values)
		{
			if(isPrime(value))
			{
				System.out.println(value);
			}
		}
	}
	
	public boolean isPrime(int value)
	{
		//General concesus according to Google makes 1 not prime
		if(value == 1)
		{
			return false;
		}
		for(int i = 2; i <= Math.sqrt(value); i++)
		{
			if((value % i) == 0)
			{
				return false;
			}
		}
		return true;
	}
}