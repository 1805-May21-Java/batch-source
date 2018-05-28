package com.revature.corejava;

import java.util.Scanner;

public class Q10TernaryOperators {
	
	private static Scanner sc = new Scanner(System.in);

	public static void main(String[] args) {
		
		// get two numbers from user
		System.out.println("Enter an int: ");
		int a = sc.nextInt();
		System.out.println("Enter a second int: ");
		int b = sc.nextInt();
		
		// if a is less than b, then a is the minimum
		// else b is equal to a or the minimum
		int min = (a < b) ? a : b; 
		
		System.out.println("The minimum of those numbers is: " + min);

	}

}
