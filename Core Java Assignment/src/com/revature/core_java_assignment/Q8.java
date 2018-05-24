package com.revature.core_java_assignment;
import java.util.ArrayList;

public class Q8
{

	public static void main(String[] args)
	{
//		“karan”, “madam”, ”tom”, “civic”, “radar”, “jimmy”, “kayak”, “john”,  “refer”, “billy”, “did”
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
		
		for(int i = 0; i < 11; i++)
		{
			palindromes.add("");
		}
		
		for(int i = 0; i < 11; i++)
		{
			String temp = words.get(i);
			String reversed = new StringBuilder(temp).reverse().toString();
			if(temp.equals(reversed))
			{
				palindromes.set(i, temp);
			}
		}
		
		System.out.println("Original ArrayList: " + words);
		System.out.println("Palindromes: " + palindromes);

	}

}
