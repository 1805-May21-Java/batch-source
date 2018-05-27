package com.adora.reversestring3;

import java.util.Scanner;

public class ReverseString {

	public static void main(String[] args) {
		System.out.println("Enter a string to reverse");
		Scanner scanner = new Scanner(System.in);
		String word = scanner.nextLine();
		
		int finalIndex = word.length();
		for(int i = finalIndex; i > 0 ; i--) {
			word += word.substring(i - 1, i);
		}
		String reverseWord = word.substring(word.length() / 2, word.length());
		
		System.out.println(reverseWord);
		
		scanner.close();

	}

}
