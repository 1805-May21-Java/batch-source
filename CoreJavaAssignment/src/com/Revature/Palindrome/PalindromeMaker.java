package com.Revature.Palindrome;

import java.util.ArrayList;

public class PalindromeMaker {
	public static boolean isPalindrome(String str) {
		int n = str.length();

		int middle = (n / 2);
		for (int i = 0; i < middle; i++) {
			if (str.charAt(i) != str.charAt(n - i - 1)) {
				return false;
			}
		}
		return true;
	}

	public static ArrayList<String> getAllPalindromes(ArrayList<String> nameList) {
		ArrayList<String> palindromeList = new ArrayList<String>();

		for (int i = 0; i < nameList.size(); i++) {
			boolean n = isPalindrome(nameList.get(i));
			if (n) {
				palindromeList.add(nameList.get(i));
			}
		}

		return palindromeList;
	}

	public static void main(String[] args) {
		ArrayList<String> nameList = new ArrayList<String>(); // Initialize array list
		String[] arr = { "karan", "madam", "tom", "civic", "radar", "jimmy", "kayak", "john", "refer", "billy", "did" }; // Initialize
																															// names
																															// as
																															// an
																															// array
		for (String name : arr) {
			nameList.add(name); // Add all array names to ArrayList
		}
		
		ArrayList<String> palindromes = getAllPalindromes(nameList);
		
		for ( String name : palindromes ) {
			System.out.println(name);
		}

		getAllPalindromes(nameList);
	}
}
