package com.revature.a2;

import java.util.Scanner;

public class Q16StringLength {

	//scanner class
	private Scanner scan = new Scanner(System.in);
	
	public void stringLength() {
		//put the input into a string and find its length
		System.out.println("Please enter the string to test out its length: ");
		String s = scan.nextLine();
		System.out.println("The length of the string you just entered is : " + s.length());		
	}
}
