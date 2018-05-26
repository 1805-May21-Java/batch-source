package com.revature.hw2;

import java.util.ArrayList;

public class Q8 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		String[] cArr = {"karan", "madam", "tom", "civic", "radar", "jimmy",
								"kayak", "john",  "refer", "billy", "did"};
		ArrayList<String> word = new ArrayList<String>();
		ArrayList<String> Palindrome = new ArrayList<String>();
		
		word.add("karan");
		word.add("madam");
		word.add("tom");
		word.add("civic");
		word.add("radar");
		word.add("jimmy");
		word.add("kayak");
		word.add("john");
		word.add("refer");
		word.add("billy");
		word.add("did");
		
		//gets size of list
		int s1 = word.size();
		for(int x = 0; x < s1; x++) {
						
			//gets value from list
			String wordP = word.get(x);
			
			//gets length of value
			int s2 = wordP.length();
			
			char[] myWord = wordP.toCharArray();
			
			//determines if word is a palindrome
			for(int y = 0; y < s2/2; y++) {
				int begin = 0, end = s2-1;
				if(myWord[begin] == myWord[end]) {
					begin++;
					end--;
				}
				else {
					break;
				}
				Palindrome.add(wordP);
				break;
			}
		}
		System.out.println(Palindrome);
	}
}