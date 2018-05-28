package com.revature.q8;

import java.util.*;

public class Driver {

	public static void main(String[] args) {
		
		// creates ArrayList myWords and adds all words to the list
		ArrayList<String> myWords = new ArrayList<String>();
		ArrayList<String> myBackWords = new ArrayList<String>();
			
			myWords.add("karan");
			myWords.add("madam");
			myWords.add("tom");
			myWords.add("civic");
			myWords.add("radar");
			myWords.add("jimmy");
			myWords.add("kayak");
			myWords.add("john");
			myWords.add("refer");
			myWords.add("billy");
			myWords.add("did");
			// prints the entire list of words to the console
			System.out.println("My list of words:");
			for (int i = 0; i < myWords.size(); i++) {
				System.out.println(myWords.get(i));
			}
			
			System.out.println();
			
		// creates list of reversed words to compared values to			
		for (int i = 0; i < myWords.size(); i++) {
			String reverseStr = new StringBuilder(myWords.get(i)).reverse().toString();
			myBackWords.add(reverseStr);

		}
		// prints list of reversed words
		System.out.println("My list of reversed words:");
		System.out.println(myBackWords);
		System.out.println();
		
		System.out.println("Palindromes:");
		for (int i = 0; i < myWords.size(); i++) {
			if (myWords.contains(myBackWords.get(i))) {
				System.out.println(myBackWords.get(i));
			} else {
				
			}

		}
		
			

		
	}
}

