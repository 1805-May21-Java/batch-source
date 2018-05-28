package com.revature.q3;

import java.util.Scanner;

public class Driver {

	public static void main(String[] args) {

		System.out.println("Enter String:");
		
		Scanner sc = new Scanner(System.in);
		String str = sc.nextLine();
		String reverseStr = "";
		
		for(int i = str.length() - 1; i >= 0; i--) {
			reverseStr = reverseStr + str.charAt(i);
		}
		
		System.out.println("Reversed String is:");
		System.out.println(reverseStr);

	}

}
