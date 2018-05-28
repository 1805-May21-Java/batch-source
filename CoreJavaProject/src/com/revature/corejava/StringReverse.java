package com.revature.corejava;

import java.util.Scanner;

/*
 * Q3 from Core Java Assignment
 * 
 *  Reverse a string without using a temporary variable.  Do NOT use reverse() in the StringBuffer or the StringBuilder APIs
 */
public class StringReverse 
{

	public static void main(String[] args) 
	{
		Scanner scanner = new Scanner(System.in);
				
		System.out.println("What string would you like reversed: ");
		String str = scanner.nextLine();
		reverse(str);
		
		scanner.close();
	}
	
	//Reverse a string by using its length and a for loop to start at the end and print backwards
	static void reverse(String str)
	{
		int strLength = str.length();
		for(int i = 0; i < str.length(); i++)
		{
			System.out.print(str.charAt(strLength - 1));
			strLength--;
		}
	}
}
