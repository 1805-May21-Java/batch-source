package com.revature.corejava.question3;

public class ReverseString {
	private String string;
	// Constructor to create new instance of ReverseString class
	public ReverseString() {
		super();
	}
	// Constructor to create new ReverseString object with string already set
	public ReverseString(String string) {
		super();
		this.string=reverse(string);
	}
	// Setter to set string variable to new string
	public void setString(String string) {
		this.string=reverse(string);
		
	}
	// Getter to return reversed string 
	public String getReversedString() {
		return string;
	}
	/*
	 * Private method to reverse the characters in string variable
	 * 
	 * Loops for 1 less than the length of the string 
	 * 
	 * Starting at the second letter, the method puts the current letter at the front of the string
	 * 
	 */
	private String reverse(String string) {
		int count=1;
		while(count<string.length()) {
			string=string.charAt(count)+string.substring(0, count)+string.substring(count+1);
			count++;
		}
		
		return string;
	}
	
	
	
	
}
