package com.revature.main;

/**
 * This class is created regarding Question 18
 * isUpperCase() method is used to check if any of the character in the string has uppercase
 * if it does, return true;
 *
 *toUpperCase() method is used to convert input string to return uppercase string
 *
 *toIntegerPlusTen() method is used to parse String into Integer wrapper class and plus ten.
 */
public class StringManipulation extends StringTool
{

	public StringManipulation()
	{
	}
	
	@Override
	boolean isUpperCase(String str)
	{
		boolean result=false;
		for(int i = 0; i<str.length(); i++)
		{
			result = Character.isUpperCase(str.charAt(i));
			if(result==true)
				return result;
			
		}
		return false;
	}

	@Override
	String toUpperCase(String str)
	{
		return str.toUpperCase();
	}
	
	@Override
	int toIntegerPlusTen(String str)
	{
		return Integer.parseInt(str)+10;
	}

}
