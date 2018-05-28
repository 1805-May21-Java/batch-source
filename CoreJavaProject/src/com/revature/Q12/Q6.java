package com.revature.Q12;

import java.util.Scanner;

public class Q6 {

	public static void main(String[] args) {
		//Scanner that accepts number 
		Scanner sc = new Scanner(System.in);
		System.out.println("What number do you want to check?: ");
		int num = sc.nextInt();
		//If else statement that uses the AND operator to return either a 0 or 1 with 1 being odd
		if((num & 1)==0) {
			System.out.println(+num+ " is even");
		}
		else {
			System.out.println(+num+ " is odd");
		}
	}

}
