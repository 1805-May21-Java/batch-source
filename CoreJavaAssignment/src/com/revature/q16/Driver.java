package com.revature.q16;

import java.util.Scanner;

public class Driver {

	public static void main(String[] args) {

		System.out.println("Enter a string to know how many characters it has:");
		Scanner sc = new Scanner(System.in);
		String str = sc.nextLine();
		System.out.println(str.length());
	}

}
