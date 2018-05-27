package com.revature.core_java_assignment;

import java.util.Scanner;

public class Question17 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		System.out.println("Enter principal");
		float principal = sc.nextFloat();
		
		System.out.println("Enter interest rate as a decimal. For example, a 5% interest rate should be entered as 0.05");
		float rate = sc.nextFloat();

		System.out.println("Enter years");
		int years = sc.nextInt();
		
		float interest = principal * rate * years;
		System.out.println("Total interest is " + interest);
		
		sc.close();
	}

}
