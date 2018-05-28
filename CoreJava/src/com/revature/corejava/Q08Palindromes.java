package com.revature.corejava;

import java.util.ArrayList;

public class Q08Palindromes {

	public static void main(String[] args) {
		
		// create original list of strings
		ArrayList<String> words = new ArrayList<String>();
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
		ArrayList<String> palindromes = new ArrayList<String>();
		
		// check whether string is a palindrome
		// if yes, add it to palindromes list
		for (String word : words) {
			if (isPalindrome(word, 0, word.length()-1)) {
				palindromes.add(word);
			}
		}
		
		System.out.println(palindromes);

	}
	
	public static boolean isPalindrome(String str, int start, int end) {
		// base cases:
		if (start == end) { // string has length 1 or recursion has reached middle
			return true;
		}
		if (str.charAt(start) != str.charAt(end)) { // not palindrome if chars aren't the same
			return false;
		}
		
		// ensure that start and end indices don't pass each other
		if (start < end + 1) {
			return isPalindrome(str, start+1, end-1);
		} 
		
		// for even-lengthed strings
		return true;
	}

}
