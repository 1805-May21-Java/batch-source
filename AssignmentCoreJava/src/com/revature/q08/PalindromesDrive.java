package com.revature.q08;

import java.util.ArrayList;

public class PalindromesDrive {
	public static void main(String[] args) {

		//Populating an ArrayList with the words provided
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
		
		
		System.out.println("Original ArrayList of words: ");
		for(String string : words) {
			System.out.print(string + " ");
		}
		System.out.println();
		
		System.out.println("ArrayList of palindromes: ");
		ArrayList<String> palindromes = findPalindromes(words);
		for(String string : palindromes) {
			System.out.print(string + " ");
		}
		System.out.println();
	}
	
	static ArrayList<String> findPalindromes(ArrayList<String> arr) {
		ArrayList<String> palindromes = new ArrayList<String>();
		boolean isPalindrome;
		for(String string: arr) {
			//palindrome until proven not
			isPalindrome = true;
			
			/*
			 * Checks to see if the first half of the word is the same as the second half.
			 * If it isn't, then it's not a palindrome, so break from checking.
			 */
			for (int i = 0; i < string.length()/2; i++) {
				if(string.charAt(i) != string.charAt(string.length()-1-i)) {
					isPalindrome = false;
					break;
				}
			}
			
			// If the word passes the palindrome test, print it.
			if (isPalindrome) {
				palindromes.add(string);
			}
		}
		
		return palindromes;	
	}
}
