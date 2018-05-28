package com.revature.Q12;

import java.util.*;

public class Q17 {
	public static void main(String[] args) {
		//Creates and  multiple variables 
		double principal = 0.0;
		double rate = 0.0;
		int time = 0;
		double result = 0;
		Scanner sc = new Scanner(System.in);
		//Takes in all the information
		System.out.print("What is the principal rate?: ");
		principal = sc.nextDouble();
		System.out.println();
		System.out.print("What is the rate?: ");
		rate = sc.nextDouble();
		System.out.println();
		System.out.print("What is the time in terms of months?: ");
		time = sc.nextInt();
		//Does the math and prints the result
		result = principal* rate*time;
		System.out.println("Total: " +result);
	}
}
