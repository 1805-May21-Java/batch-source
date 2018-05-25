package com.revature.corejava;

import java.util.Scanner;

//Q6
public class EvenCheck {

	static Scanner scanner = new Scanner(System.in);

	public static void main(String[] args) {
		System.out.println("Enter a number:");
		int num=0;
		num=getNum();
		int quotient = num/2;
		if(quotient*2 == num) {
			System.out.println(num + " is an Even Number");
		} else {
			System.out.println(num + " is an Odd Number");
		}
	}

	private static int getNum() {
		int num=0;
		try {
			num = Integer.parseInt(scanner.nextLine());
		} catch (NumberFormatException e) {
			System.out.println("Invalid input, please enter a whole Number");
			getNum();
		}
		return num;
	}
}
