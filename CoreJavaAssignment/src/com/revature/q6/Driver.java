package com.revature.q6;

import java.util.Scanner;

public class Driver {

	public static void main(String[] args) {

		System.out.println("Enter a number to check if it is even or odd:");
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		
		int quotient = n / 2;
		
		if (quotient * 2 == n) {
			
			System.out.println(n + " is even");
		} else {
			
			System.out.println(n + " is odd");
		}

	}

}
