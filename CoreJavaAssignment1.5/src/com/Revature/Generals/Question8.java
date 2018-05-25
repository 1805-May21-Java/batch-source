package com.Revature.Generals;

import java.util.ArrayList;

public class Question8 {
	public static boolean isPalindrome(String str) {
		StringBuffer strBuffer = new StringBuffer(str);
		StringBuffer rev = strBuffer.reverse(); //Palindrome is the same string foreward and reversed
		
		return rev.toString().equals(str); //Return this check
	}
	
	public static ArrayList<String> getAllPalindromes(ArrayList<String> list ) {
		ArrayList<String> palindromes = new ArrayList<String>(); //Initialize new list for palindromes
		
		for (String str : list ) {
			if ( isPalindrome(str)) { //Palindrome check
				palindromes.add(str);
			}
		}
		
		return palindromes;
	}

	public static void main(String[] args) {
		ArrayList<String> arr = new ArrayList<String>();
		String initialNames[] = { "karan", "madam", "tom", "civic", "radar", "jimmy", "kayak", "john", "refer", "billy",
				"did" };

		for (String str : initialNames) { //Copy names from array to arraylist
			arr.add(str);
		}
		
		//Get all palindromes
		ArrayList<String> palindromes = getAllPalindromes(arr); 
		
		System.out.println("Palindromes found: " + palindromes.size());
		
		for(String str : palindromes) {
			System.out.println(str);
		}

	}
}
