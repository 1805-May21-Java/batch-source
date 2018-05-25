package com.revature.a2;

import java.util.ArrayList;

public class Q8Palindromes {
	//set up arraylist
	private ArrayList<String> normal = new ArrayList<String>();
	private ArrayList<String> palindrome = new ArrayList<String>();
	private String s;
	
	public void palindromes() {
		//add the words to normal arraylist
		normal.add("karan");
		normal.add("madam");
		normal.add("tom");
		normal.add("civic");
		normal.add("radar");
		normal.add("jimmy");
		normal.add("kayak");
		normal.add("john");
		normal.add("refer");
		normal.add("billy");
		normal.add("did");
		
		for (int i = 0; i < normal.size(); i++) {
			//check if a word is palindrome by comparing the first to last, and then second to second last and so on
			int z = 0;
			for (int j = 0; j < normal.get(i).length()/2; j++) {
				if (normal.get(i).charAt(j) == normal.get(i).charAt(normal.get(i).length() - j-1)) {
					z++;
				}	
			}
			if (z == normal.get(i).length()/2) {
				//add the word to palindromw arraylist and remove it from the normal one
				s = normal.get(i);
				palindrome.add(s);
				normal.remove(i);
			}
		}
		
		//print the words out form the 2 arraylist
		System.out.print("These words are normal words:  ");
		for(int i = 0; i < normal.size(); i++) {
			System.out.print(normal.get(i) + "  ");
		}
		System.out.println();
		
		System.out.print("These words are palindrome words:  ");
		for(int i = 0; i < palindrome.size(); i++) {
			System.out.print(palindrome.get(i) + "  ");	
		}
		System.out.println();
	}
}
