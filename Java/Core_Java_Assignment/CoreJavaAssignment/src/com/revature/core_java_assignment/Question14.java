package com.revature.core_java_assignment;

import java.time.LocalDateTime;
import java.util.Scanner;

public class Question14 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		System.out.println("Please enter the operation you'd like to perform");
		System.out.println("Enter 1 to find the square root of an integer.");
		System.out.println("Enter 2 to display today's date.");
		System.out.println("Enter 3 to split the string \"I am learning core Java\"");
		int operation = sc.nextInt();
		
		switch(operation) {
			case 1:
				System.out.println("Enter an integer");
				int num = sc.nextInt();
				System.out.println("The square root of " + num + " is " + Math.sqrt(num));
				break;
			case 2:
				System.out.println("Today is " + LocalDateTime.now().toLocalDate());
				break;
			case 3:
				System.out.println("Splitting the string \"I am learning core Java\"");
				String str = "I am learning core Java";
				String[] strArr = str.split(" ");
				System.out.println("Successfully split the string.");
				break;
			default:
				System.out.println("Invalid command");
		}	
		
		sc.close();
	}

}
