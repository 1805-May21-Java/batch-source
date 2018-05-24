package com.revature.algorithms;

import java.util.ArrayList;

public class PalindromeStorage {

	private ArrayList<String> arr;
	private ArrayList<String> palindromes;
	
	public PalindromeStorage() {
		super();
		arr = new ArrayList<String>();
		palindromes = new ArrayList<String>();
	}

	public ArrayList<String> getArr() {
		return arr;
	}

	public void setArr(ArrayList<String> arr) {
		this.arr = arr;
	}

	public ArrayList<String> getPalindromes() {
		return palindromes;
	}

	public void setPalindromes(ArrayList<String> palindromes) {
		this.palindromes = palindromes;
	}

	// inserts the string into arr, and if it's a palindrome, also inserts it into palindromes
	public void insertString(String str) {
		arr.add(str);
		boolean palindromeCheck = true;
		for(int i = 0; i < str.length() / 2; i++) {
			if(str.charAt(i) != str.charAt(str.length() - i - 1))
				palindromeCheck = false;
		}
		if(palindromeCheck)
			palindromes.add(str);
	}
}
