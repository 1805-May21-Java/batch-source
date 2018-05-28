package com.revature.q14;

import java.util.Calendar;
import java.util.Date;
import java.util.Scanner;

public class Driver {

	public static void main(String[] args) {

		System.out.println("Please enter a command:");
		Scanner sc = new Scanner(System.in);
		String str = sc.nextLine();
		
		switch(str) {
			
		case "square root" :
			System.out.println("Enter number you would like the square root of:");
			int rootMe = sc.nextInt();
			double rootAnswer = Math.sqrt(rootMe);
			System.out.println("The square root of " + rootMe + " is: " + rootAnswer);
			break;
			
		case "date" :
			Date today = Calendar.getInstance().getTime();
			System.out.println(today);
			break;
		
		case "split" :
			
			String myString = "I am learning Core Java";
			String[] myArray = myString.split(" ");
			for(String s : myArray) {
			System.out.println(s);
			}
			break;
		}

	}

}
