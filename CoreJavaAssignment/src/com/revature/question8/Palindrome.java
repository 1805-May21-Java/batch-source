package com.revature.question8;

import java.util.*;

public class Palindrome
{
	public Palindrome()
	{
		super();
	}

	public ArrayList<String> getPalindromes(ArrayList<String> original)
	{
		ArrayList<String> palindromes = new ArrayList<String>();
		
		for(String word : original)
		{
			if(isPalindrome(word))
			{
				palindromes.add(word);
			}
		}
		
		return palindromes;
	}
	
	public boolean isPalindrome(String input)
	{
		for(int i = 0; i < input.length()/2; i++)
		{
			if(input.charAt(i) != input.charAt(input.length() - 1 - i))
			{
				return false;
			}
		}
		return true;
	}
}
