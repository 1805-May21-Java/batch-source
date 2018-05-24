package com.revature.q08;

import java.util.ArrayList;

public class PalindromesDrive {
	public static void main(String[] args) {

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
			isPalindrome = true;
			for (int i = 0; i < string.length()/2; i++) {
				if(string.charAt(i) != string.charAt(string.length()-1-i)) {
					isPalindrome = false;
					break;
				}
			}
			if (isPalindrome) {
				palindromes.add(string);
			}
		}
		
		return palindromes;	
	}
}
