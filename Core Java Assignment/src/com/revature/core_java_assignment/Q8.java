package com.revature.core_java_assignment;
import java.util.ArrayList;

public class Q8
{

	public static void main(String[] args)
	{
		//creating two ArrayLists and filling words with the provided words
		ArrayList<String> words = new ArrayList<String>(11);
		ArrayList<String> palindromes = new ArrayList<String>(11);
		
		words.add("karan");
		words.add("madam");
		words.add("tom");
		words.add("civic");
		words.add("radar");
		words.add("jimmy");
		words.add("kayak");
		words.add("john");
		words.add("refer");
		words.add("billy");
		words.add("did");
		
		//this is filling the second ArrayList with empty strings
		//need to do this otherwise we run into out of bounds exceptions
		for(int i = 0; i < 11; i++)
		{
			palindromes.add("");
		}
		
		//main loop
		for(int i = 0; i < 11; i++)
		{
			//creating temporary variables to store strings in
			String temp = words.get(i);
			//reverse the string using StringBuilder's methods
			String reversed = new StringBuilder(temp).reverse().toString();
			//comparing the two strings to see if they are the same and thus a palindrome and storing them in the other 
			//ArrayList
			if(temp.equals(reversed))
			{
				palindromes.set(i, temp);
			}
		}
		
		//displaying the ArrayLists
		System.out.println("Original ArrayList: " + words);
		System.out.println("Palindromes: " + palindromes);

	}

}
