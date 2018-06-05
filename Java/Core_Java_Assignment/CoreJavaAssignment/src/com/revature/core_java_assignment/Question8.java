package com.revature.core_java_assignment;

import java.util.ArrayList;
import java.util.Arrays;

public class Question8 {

	public static boolean isPalindrome(String word) {
	    int front = 0;
	    int back = word.length() - 1;
	    while (back > front) {
	        if (word.charAt(front) != word.charAt(back)) {
	            return false;
	        }
	        front++;
	        back--;
	    }
	    return true;	
	}
	
	public static void main(String[] args) {
		String[] wordsArr = {"karan", "madam", "tom", "civic", "radar", "jimmy", "kayak", "john", "refer", "billy", "did"};
		ArrayList<String> words = new ArrayList<>();
		words.addAll(Arrays.asList(wordsArr));
		
		ArrayList<String> palindromes = new ArrayList<>();
		for(String word : words) {
			if(isPalindrome(word)) {
				palindromes.add(word);
			}
		}
		System.out.println(palindromes);
	}

}
