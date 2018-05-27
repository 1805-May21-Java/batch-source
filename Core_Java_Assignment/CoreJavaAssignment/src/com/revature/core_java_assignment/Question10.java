package com.revature.core_java_assignment;

import java.util.Scanner;

public class Question10 {

	public static void main(String[] args) {
		System.out.println("Enter two integers");
		Scanner sc = new Scanner(System.in);
		int num1 = sc.nextInt();
		int num2 = sc.nextInt();
		int minimum = num1 < num2 ? num1 : num2;
		System.out.println("The minimum is " + minimum);
		sc.close();
	}

}
