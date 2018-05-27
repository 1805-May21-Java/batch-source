package com.revature.homework;

import java.util.ArrayList;

public class Q8 {

	public static void main(String[] args) {

		ArrayList<String> list = new ArrayList<String>(); // All string list
		ArrayList<String> list1 = new ArrayList<String>(); // stores palindrome list

		// add all string in list
		list.add("karan");
		list.add("madam");
		list.add("tom");
		list.add("civic");
		list.add("radar");
		list.add("jimmy");
		list.add("kayak");
		list.add("john");
		list.add("refer");
		list.add("billy");
		list.add("did");
		//for(String l : list) {
			//System.out.println(l);
		//}
		// loop each element in list, list.size gives number of element of the list
		for (int i = 0; i < list.size(); i++) {
			if (isPalindrome( list.get(i))) { // if palindrome,checks the index of the specified index
				list1.add( list.get(i)); // add palindrome string in the list
			}
		}
		System.out.println("The Palindrome string are : " + list1); // display list1
	
		}
	public static boolean isPalindrome(String word) {
//		String rev = " ";
//		// reverse the string
//		for (int i = word.length() - 1; i >= 0; i--) {
//			rev = rev + word.charAt(i);
//		}
//		// check string matches to give string
//		return true;
//	
//	}
return word.equals(new StringBuilder(word).reverse().toString());// find palindrome
}
}