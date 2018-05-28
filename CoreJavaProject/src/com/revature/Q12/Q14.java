package com.revature.Q12;

import java.util.Scanner;

public class Q14 {
	private static Scanner sc = new Scanner(System.in);
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int answer= getChoice();
		
		switch(answer) {
		case 1:
			System.out.println("Number you want to square please: ");
			int number = sc.nextInt();
			System.out.println(Math.sqrt(number));
			break;
		case 2:
			System.out.println("Today's date: " +java.time.LocalDate.now());
			System.out.println("Current Time: " +java.time.LocalTime.now());
			break;
		case 3:
			System.out.println("String being broken down: I am learning Core Java");
			String str = "I am learning Core Java";
			String [] ar = str.split(" ");
			for(String a: ar) {
				System.out.println(a);
			}
			break;
		}
	}
	
	private static int getChoice() {
		System.out.println("What would you like to do?: ");
		System.out.println("1.Square A Number");
		System.out.println("2.Get the Date");
		System.out.println("3.Split a predefined string");
		int num= sc.nextInt();
		return num;
	}

}
