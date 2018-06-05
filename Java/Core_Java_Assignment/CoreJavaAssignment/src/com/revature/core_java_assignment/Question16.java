package com.revature.core_java_assignment;

import java.util.Scanner;

public class Question16 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter a string.");
		
		String str = sc.nextLine();
		
		System.out.println("The string you entered has " + str.length() + " characters.");
		sc.close();
	}

}
