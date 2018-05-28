package com.revature.q4;

import java.util.Scanner;

public class Driver {

	public static void main(String[] args) {

		int myInt = 1;
		
		System.out.println("Enter an N to compute its factorial:");
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		
		for (int i = 1; i<= n; i++) {
			myInt = myInt * i;
		}
		System.out.println("The factorial of " + n + " is: " + myInt);
	}

}
