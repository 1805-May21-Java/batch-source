package com.revature.corejava.question3;

public class ReverseDriver {

	public static void main(String[] args) {
		// Instance of ReverseString with test string "Hello World"
		ReverseString rs=new ReverseString("Hello World");
		
		// Print the result, should be dlroW olleH
		System.out.println(rs.getReversedString());

	}

}
