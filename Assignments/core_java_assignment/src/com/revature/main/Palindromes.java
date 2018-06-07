package com.revature.main;

/**
 * This class is creaetd regarding Question 8
 * In the isTrue() method we go from index 0 to half of the string length in order to compare with the other half.
 * if the input string is not palindrome it will return false. 
 *
 */
public class Palindromes 
{

	public Palindromes()
	{
		super();
	
	}
	
	public static boolean isTrue(String s)
	{
		int length = s.length();
		for(int i=0, j=length-1; i<length/2; i++, j--)
		{
			if(s.charAt(i)!=s.charAt(j)) return false;
		}
		
		return true;
		
	}

}
