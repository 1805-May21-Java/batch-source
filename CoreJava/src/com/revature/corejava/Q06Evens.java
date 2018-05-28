package com.revature.corejava;

import java.util.Scanner;

public class Q06Evens {
	
	private static Scanner sc = new Scanner(System.in);

	public static void main(String[] args) {
		
		System.out.println("Enter an integer: ");
		double num = sc.nextDouble(); // read in int as double
		
		// check that the quotient and the rounded quotient are the same
		if (Math.round(num / 2) == (num / 2)) {
			System.out.println("Even");
		} else {
			System.out.println("Odd");
		}
	}

}
