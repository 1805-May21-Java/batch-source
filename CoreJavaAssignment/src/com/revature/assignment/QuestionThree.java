package com.revature.assignment;

public class QuestionThree {
	
	//creates a string to use and an empty string for the reverse
	private static String str = "This is a test string.";
	private static String strBackwards = "";
	
	public static void main(String[] args) {
		
		//for loop gets the length, starts at the end of the test string and adds
		//that character to the empty string
		for(int i=str.length()-1; i>=0; i--) {
			strBackwards += str.charAt(i);
		}
		System.out.println(strBackwards);
	}

}
