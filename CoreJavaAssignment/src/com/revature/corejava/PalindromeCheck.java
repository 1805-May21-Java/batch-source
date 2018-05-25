package com.revature.corejava;

import java.util.ArrayList;

//Q8
public class PalindromeCheck {

	public static void main(String[] args) {
		ArrayList<String> words = new ArrayList<>();
		words.add("karan");
		words.add("madam");
		words.add("civic");
		words.add("radar");
		words.add("jimmy");
		words.add("kayak");
		words.add("john");
		words.add("refer");
		words.add("billy");
		words.add("tom");
		words.add("did");
		
		ArrayList<String> palindromes = new ArrayList<>();
		for(String s: words) {
			if(isPalindrome(s)) {
				palindromes.add(s);
			}
		}
		for(String s: palindromes) {
			System.out.println(s);
		}
	}
	public static boolean isPalindrome(String s) {
		for(int i=0; i<s.length()/2;i++) {
			if(s.charAt(i) != s.charAt(s.length()-i-1) ) {
				return false;
			}
		}
		return true;
	}

}
