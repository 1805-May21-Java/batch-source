package com.revature.main;

/**
 * This class is created for Question 5
 * The method is to take string and index number 
 * so it will return substring from zero to index number
 * 
 * we use append method and charAt in StringBuilder and String to implements the method without using substring() method.
 * 
 *
 */
public class SubString {

	public SubString()
	{
		super();
		// TODO Auto-generated constructor stub
	}

	public static StringBuilder to(String str, int toIndex)
	{
		
		StringBuilder sb = new StringBuilder();
		for(int i=0; i<toIndex; i++)
		{
			sb.append(str.charAt(i));
		}
		return sb;
	}

	
}
