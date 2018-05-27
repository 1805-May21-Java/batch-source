package com.revature.assignment;

public class QuestionSixteen {

	private static int len;
	
	public static void main(String[] args) {
	
		for(String str:args) {
			len += str.length() + 1;
			System.out.println(str);
		}
		len -= 1;
		System.out.println();
		System.out.println("There are "+len+" characters in the string input.");
	}

}
