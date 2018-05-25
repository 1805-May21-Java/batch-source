package com.revature.a2;

public class Q3ReverseString {

	// set up the string
	private String s = "Hello World!";
	private String reverse;
	public void reverseString() {
		String reverse = " ";
		//make the reverse empty at first
		for (int i = s.length()-1; i >= 0; i--) {
			// then for each character in the original string, add it in the reverse order
			reverse = reverse + s.charAt(i);
		}
		//print out the answer
		System.out.println(reverse);
		System.out.println();
	}
	
}
