package com.revature.Q12;

import java.util.*;

public class Q16 {
	public static void main(String[] args) {
		//Scanner that brings in the sentence
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter in the String you want measured: ");
		String sentence = sc.nextLine();
		//Num that gets the length of the string
		int num = sentence.length();
		System.out.println("The length of this sentence is: " +num);
	}

}
