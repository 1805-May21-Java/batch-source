package com.revature.corejava;

import java.util.*;

/*
 * Q9 from Core Java Assignment
 * 
 * Create an ArrayList which stores numbers from 1 to 100 and prints out all the prime numbers to the console.
 */
public class PrimeNumberDemo 
{

	public static void main(String[] args) 
	{
	
		ArrayList<Integer> list = new ArrayList<Integer>();
		
		for(int i = 1; i < 101; i++)
			list.add(i);
		
		for(int i : list)
		{
			if(isPrime(i))
			System.out.println(i + " is a prime number!");
		}
	
	}
	
	//Returns whether the given number is prime or not.
	public static boolean isPrime(int n) 
	{
	    int i;
	    
	    if( n == 1)
    		return false;
    	else if(n == 2)
    		return true;
	    for (i = 2; i <= n / 2; i++) 
	    {
	    	if (n % i == 0) 
	        {
	            return false;
	        }
	    }
	    return true;
	}
}
