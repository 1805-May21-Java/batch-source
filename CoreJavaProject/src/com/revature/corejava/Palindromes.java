package com.revature.corejava;

import java.util.ArrayList;

/*
 * Q8 from Core Java Assignment
 * 
 * Write a program that stores the following strings in an ArrayList and saves all the palindromes in another ArrayList.
 * “karan”, “madam”, ”tom”, “civic”, “radar”, “jimmy”, “kayak”, “john”,  “refer”, “billy”, “did”
 *
 */
public class Palindromes 
{

	public static void main(String[] args) 
	{
		//Create 2 lists. One that will hold all names. One that will store the palindromes.
		ArrayList<String> strList = new ArrayList<String>();
		ArrayList<String> palindromeList = new ArrayList<String>();
		strList.add("karan");
		strList.add("madam");
		strList.add("tom");
		strList.add("civic");
		strList.add("radar");
		strList.add("jimmy");
		strList.add("kayak");
		strList.add("john");
		strList.add("refer");
		strList.add("billy");
		strList.add("did");
		
		//I use the StrinBuilder API to reverse the given strings an add the palindromes to a new list.
		for(int i = 0; i < strList.size(); i++)
		{
			if(strList.get(i).equals(new StringBuilder(strList.get(i)).reverse().toString()))
				palindromeList.add(strList.get(i));
		}
	}
}
