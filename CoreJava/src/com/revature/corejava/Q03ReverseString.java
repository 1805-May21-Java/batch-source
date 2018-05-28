package com.revature.corejava;
import java.util.Scanner;

public class Q03ReverseString {
	
	private static Scanner sc = new Scanner(System.in);

	public static void main(String[] args) {
		
		System.out.println("Enter string to reverse: ");
		String str = sc.next(); // get string to reverse from user
		
		reverse(str);

	}
	
	public static void reverse(String str) {
		char[] charArr = str.toCharArray(); // convert str to array of characters
		char[] newArr = new char[charArr.length];
		
		int index = 0; // insertion index for newArr
		
		// iterate thru charArr from end to start
		// index for newArr increments in opposite direction
		for (int i=charArr.length-1; i>=0; i--) {
			newArr[index] = charArr[i];
			index++;
		}
		
		String newStr = new String(newArr); // convert char array back to string
		System.out.println("The reversed string is: " + newStr);
	}

}
