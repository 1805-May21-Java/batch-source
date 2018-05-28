package com.revature.corejava;

/*
 * Q16 from Core Java Assignment
 * 
 * Write a program to display the number of characters for a string input.
 * The string should be entered as a command line argument using (String [ ] args).
 */
public class CharCount 
{

	public static void main(String[] args) 
	{
		//When called from the command line you input your arguments and the length is printed
		System.out.println("Number of characters in this string is " + args.length);
	}
}
