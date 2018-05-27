package com.revature.main;

/**
 * This class is created regarding Question 3 to return reversed string without temporary variable.
 * In the reverse method we use substring to rotate and place in the reversed order
 * We use substring in the whole iteration in For loop.
 * Ex.
 * Hello
 * elloH
 * lloeH
 * loleH
 * olleH
 */
public class ReverseString
{

	
	public ReverseString()
	{
		// TODO Auto-generated constructor stub
	}

	public static String reverse(String str)
	{
		
		for(int i=0; i<str.length(); i++)
		str = str.substring(1, str.length()-i)+ str.substring(0, 1)+ str.substring(str.length()-i, str.length());
		
		return str;
	}
}
