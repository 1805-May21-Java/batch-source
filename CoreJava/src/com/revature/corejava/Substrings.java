package com.revature.corejava;
import java.util.Scanner;

public class Substrings {
	
	private static Scanner sc = new Scanner(System.in);

	public static void main(String[] args) {
		
		// get the string and index values from user
		System.out.println("Enter a string: ");
		String str = sc.next();
		System.out.println("Enter a substring length: ");
		int idx = sc.nextInt();
		
		System.out.println(subString(str, idx));
	}
	
	public static String subString(String str, int idx) {
		String newStr = ""; // create new string for substring
		
		for (int i=0; i<idx; i++) {
			newStr = newStr + str.charAt(i); // append to new string
		}
		
		return newStr;
	}

}
