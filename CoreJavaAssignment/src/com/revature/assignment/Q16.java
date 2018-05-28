package com.revature.assignment;

import java.util.Scanner;

public class Q16 {

	//Q16. Write a program to display the number of characters for a string input. 
	//The string should be entered as a command line argument using (String [ ] args) or using the scanner class.
	
	//I used a scanner to ask the user to enter a word and then the .length() method to determine the amount of characters in the string
	public void numOfStrings() {
		final Scanner sc = new Scanner(System.in);
		System.out.println("Type a word and I will quickly tell you how many characters it has:");
		String string = sc.nextLine();
		System.out.println(string.length());
	}

	/*Driver Code
	Q16 q = new Q16();
	q.numOfStrings();*/



}
