package com.revature.corejava;

/*
 * Q5 from Core Java Assignment
 * 
 * Write a substring method that accepts a string str and an integer idx
 *  and returns the substring contained between 0 and idx-1 inclusive.
 *    Do NOT use any of the existing substring methods in the String, StringBuilder, or StringBuffer APIs
 */
public class Substring 
{

	public static void main(String[] args) 
	{
	System.out.println(substring("Wrestlemania", 7));
		
	}
	
	//Creates a substring of the original by starting at 0 and getting each character and concatenates it to an empty string
	public static String substring(String str, int index)
	{
		String sub = "";
		for (int i = 0; i < index; i++)
		{
			sub += str.charAt(i);
		}
		return sub;
	}
}
