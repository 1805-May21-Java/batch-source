package com.revature.question9;

import java.util.*;

public class PrimesDriver
{

	public static void main(String[] args)
	{
		ArrayList<Integer> values = new ArrayList<Integer>();
		for(int i = 1; i <= 100; i++)
		{
			values.add(i);
		}
		
		Primes primes = new Primes();
		
		primes.printPrimes(values);
	}

}
