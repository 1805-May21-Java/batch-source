package com.revature.corejava;

import java.util.Scanner;

/*
 * Q10 from Core Java Assignment
 * 
 * Find the minimum of two numbers using ternary operators.
 */
public class FindMinimum
{

	public static void main(String[] args) 
	{
		//I use a scanner to get two integers from a user an pass them into a ternary operator
		Scanner scanner = new Scanner(System.in);
		System.out.println("What two numbers would you like to compare: ");
		int num1 = scanner.nextInt();
		int num2 = scanner.nextInt();
		int value = (num1 < num2) ?  num1 :  num2;
		System.out.println(value + " is the minumum number");
		scanner.close();
	}
}
