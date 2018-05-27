package com.revature.htulipan.solutions.eight;

import java.util.ArrayList;

public class PalindromeFinder {
	private ArrayList<String> wordList;
	private ArrayList<String> palList;
	
	public PalindromeFinder() {
		super();
	}
	
	public PalindromeFinder(ArrayList<String> wordList) {
		super();
		this.wordList = wordList;
		this.palList = new ArrayList<>();
	}

	public ArrayList<String> getWordList() {
		return wordList;
	}

	public void setWordList(ArrayList<String> wordList) {
		this.wordList = wordList;
	}
	
	public ArrayList<String> getPalList() {
		return palList;
	}

	public ArrayList<String> findPalindromes() {
		this.palList = new ArrayList<>();
		for (String s : this.wordList) {
			if (isPalindrome(s)) {
				palList.add(s);
			}
		}
		
		return palList;
	}
	
	public static boolean isPalindrome(String s) {
		if (s.length() == 0) return false;
		if (s.length() == 1) return true;
		
		int low = 0;
		int high = s.length() - 1;
		
		while (low < high) {
			if (s.charAt(low) == s.charAt(high)) {
				low++;
				high--;
			} else {
				break;
			}
		}
		
		return low >= high;
	}
	
}
