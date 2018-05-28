package com.revature.corejava;

import java.util.Scanner;

/*
 * Q17 from Core Java Assignment
 * 
 * Write a program that calculates the simple interest on the principal, rate of interest and number of years provided by the user.
 * Enter principal, rate and time through the console using the Scanner class.
 *Interest = Principal* Rate* Time
 */
public class CalculateInterest 
{

	public static void main(String[] args) 
	{
	
		Scanner scanner = new Scanner(System.in);
		//I take input from the user as 3 doubles then apply them to the interest formula and print the result.
		System.out.println("Enter the principal, rate, and time seperated by spaces: ");
		double principal = scanner.nextDouble();
		double rate = scanner.nextDouble();
		double time = scanner.nextDouble();
		double interest = principal*time*rate;
		System.out.println("Your interest rate is: " + interest);
		
		scanner.close();
	}
}
