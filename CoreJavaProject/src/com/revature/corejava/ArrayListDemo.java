package com.revature.corejava;

import java.util.ArrayList;
import java.util.Arrays;

/*
 * Q19 from Core Java Assignment
 * 
 * Create an ArrayList and insert integers 1 through 10. 
 * Display the ArrayList. 
 * Add all the even numbers up and display the result. 
 * Add all the odd numbers up and display the result. 
 * Remove the prime numbers from the ArrayList and print out the remaining ArrayList.
 */
public class ArrayListDemo 
{
	
	public static void main(String[] args) 
	{
		//I create an array list and add 1-10 to it.
		ArrayList<Integer> list = new ArrayList<Integer>();
		
		for(int i = 1; i < 11; i++)
			list.add(i);
		
		//I call my addEven and addOdd methods and print the results
		System.out.println("The total after adding all even numbers is: " + addEven(list));
		System.out.println("The total after adding all odd numbers is: " + addOdd(list));
		
		//Loop thru the list removing all prime numbers
		for(int i = 0; i < list.size(); i++)
		{
			int n = list.get(i);
			if(isPrime(n))
			{
				list.remove(i);
				i--;
			}
	}
		//Printing out the original list after removing prime numbers.
		System.out.println("The list after removing all prime numbers is: " + list.toString());
		
	}
	
	//I iterate thru each element of the dividing by 2 and if the remainder is 0
	//the number is even so i add that number to my total. I then return the total
	public static Integer addEven(ArrayList<Integer> list)
	{
		int total = 0;
		for(Integer i: list)
		{
			if(i % 2 == 0)
				total += i;
		}
		return total;
	}
	//I iterate thru each element of the dividing by 2 and if the remainder is 1
	//the number is odd so i add that number to my total. I then return the total
	public static Integer addOdd(ArrayList<Integer> list)
	{
		int total = 0;
		for(Integer i: list)
		{
			if(i % 2 == 1)
				total += i;
		}
		return total;
	}
	
	
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
