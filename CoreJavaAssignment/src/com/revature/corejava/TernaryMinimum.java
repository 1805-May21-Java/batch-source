package com.revature.corejava;

import java.util.Scanner;

//Q10
public class TernaryMinimum {

	static Scanner scanner = new Scanner(System.in);

	public static void main(String[] args) {
		System.out.println("Enter a number:");
		int num1=0,num2=0;
		num1=getNum();
		System.out.println("Enter another number");
		num2 = getNum();
		System.out.println((num1<num2?num1:num2) + " is the smaller number");
		
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
