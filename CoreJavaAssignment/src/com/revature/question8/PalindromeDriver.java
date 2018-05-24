package com.revature.question8;

import java.util.ArrayList;

public class PalindromeDriver
{
	public static void main(String[] args)
	{
		ArrayList<String> original = new ArrayList<String>();
		//“karan”, “madam”, ”tom”, “civic”, “radar”, “jimmy”, “kayak”, “john”,  “refer”, “billy”, “did”
		original.add("karan");
		original.add("madam");
		original.add("tom");
		original.add("civic");
		original.add("radar");
		original.add("jimmy");
		original.add("kayak");
		original.add("john");
		original.add("refer");
		original.add("billy");
		original.add("did");
		
		Palindrome p = new Palindrome();
		ArrayList<String> results = p.getPalindromes(original);
		System.out.println("Original: " + original);
		System.out.println("Palindromes: " + results);
		
	}
}
