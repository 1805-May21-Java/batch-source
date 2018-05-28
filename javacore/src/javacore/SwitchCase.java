package javacore;

import java.util.Scanner;

public class SwitchCase {
	public static void main(String[] args) {
		int choice;
		Scanner scan = new Scanner(System.in);
		
		System.out.println("Choose option below: ");
		System.out.println("1.) Take square root of a number.");
		System.out.println("2.) Show today's date.");
		System.out.println("3.) Find out what we're learning.");
		
		choice = scan.nextInt();
		switch (choice) {
		case 1:
			System.out.println("Enter Number to find square root");
			
			double x = scan.nextDouble();
			double y = Math.sqrt(x);
			System.out.println(y);
			break;
			
		case 2:
			System.out.println(java.time.LocalDate.now());  
			break;
			
		case 3:
			String learn = "I am learning core java";
			System.out.println("String: " +learn);
			String[] learnArr = learn.split("");
			
			System.out.print("String Array: ");
			for(String i:learnArr) {
				System.out.print(i);
			}
			break;
			
		default:
			System.out.println("Not an option");
		}
		
		scan.close();
	}
}
