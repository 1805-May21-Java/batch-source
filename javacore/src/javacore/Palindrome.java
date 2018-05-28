package javacore;

import java.util.ArrayList;

public class Palindrome {
	public static boolean isPalindrome(String s) {
		 // reverse the given String
	    String reverse = new StringBuffer(s).reverse().toString();
	 
	    if (s.equals(reverse))
	      return true;
	 
	    else
	      return false;
	}
	
	
	public static void main(String[] args) {
		
		ArrayList<String> words = new ArrayList<String>();
		ArrayList<String> pWords = new ArrayList<String>();
		
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
		
		for(String word: words) {
			if(isPalindrome(word)) {
				pWords.add(word);
			}
		}
		
		System.out.println(pWords);
		
	}
}
