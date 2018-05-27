package com.revature.htulipan.solutions.eight;

import java.util.ArrayList;

/*
 * Q8. Write a program that stores the following strings in an ArrayList and saves all the palindromes in another ArrayList. 
“karan”, “madam”, ”tom”, “civic”, “radar”, “jimmy”, “kayak”, “john”,  “refer”, “billy”, “did”
 */

public class SolutionEightDriver {

	public static void main(String[] args) {
		String[] words = {"karan", "madam", "tom", "civic", "radar", "jimmy", "kayak", "john", "refer", "billy", "did"};
		
		ArrayList<String> wordList = new ArrayList<>();
		for (String s : words) {
			wordList.add(s);
		}
		
		PalindromeFinder pf = new PalindromeFinder(wordList);
		ArrayList<String> palList = pf.findPalindromes();
		for (String s : palList) {
			System.out.print(s + " ");
		}	
	}
}
