package com.revature.corejava;

/*
 * Q12 from Core Java Assignment
 *
 * Write a program to store numbers from 1 to 100 in an array. Print out all the even numbers from the array. 
 * Use the enhanced FOR loop for printing out the numbers.
 */

public class EnhancedArrayPrint
{

	public static void main(String[] args) 
	{
		//Add 1-100 to the intArr using a for loop
		int[] intArr = new int[100];
		for(int i = 1; i < 101; i++)
			intArr[i-1] = i;
		
		//I then use an enhanced for loop and the modulus operator to loop thru the array checking whether the numbers are even
		//Those even numbers are printed with the odd numbers skipped
		for(int i : intArr)
		{
			if(i % 2 == 0)
				System.out.print(i + " ");
		}
	}
}
