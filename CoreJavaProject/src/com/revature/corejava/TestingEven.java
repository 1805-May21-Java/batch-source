package com.revature.corejava;

import java.util.Scanner;

/*
 * Q6 from Core Java Assignment
 * 
 * Write a program to determine if an integer is even without using the modulus operator (%)
 */
public class TestingEven 
{

	public static void main(String[] args) 
	{
		Scanner scanner = new Scanner(System.in);
		System.out.println("Enter an integer: ");
		isEven(scanner.nextInt());
		
		scanner.close();
	}
	
	//Tests whether a number is even by dividing by 2 then multiplying by 2 to see if original number equals the result
	static void isEven(int num)
	{
		if(((num / 2) * 2) == num)
			System.out.println(num + " is even");
		else 
			System.out.println(num + " is odd");
	}
}
