package com.revature.corejava;

/*
 * Q2 from Core Java Assignment
 * 
 * Write a program to display the first 25 Fibonacci numbers beginning at 0.
 */
public class DisplayFibonacci 
{

	public static void main(String[] args) 
	{
		fib(25); //Calls the fib method displaying the first 25 fibonacci numbers
		
	}
	
	//uses a temp number to compute the fibonacci sequence up to the desired number
	static void fib(int num)
	{
		int num1 = 0;
		int num2 = 1;
		int temp;
		System.out.print(num1 + " " + num2 + " ");
		for(int i = 0; i < num; i++)
		{
			temp = num2;
			num2 = num1 + num2;
			num1 = temp;
			System.out.print(num2 + " ");
		}
		System.out.println("\nWe're all fibbed out!");
	}
}
