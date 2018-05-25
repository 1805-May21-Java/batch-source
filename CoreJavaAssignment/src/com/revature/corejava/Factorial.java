package com.revature.corejava;

import java.util.Scanner;

//Q4
public class Factorial {

	static Scanner scanner = new Scanner(System.in);

	public static void main(String[] args) {
		System.out.println("Enter a number:");
		int num=0;
		num=getNum();
		int total = factorial(num);
		System.out.println(total);
		
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
	
	public static int factorial(int a) {
		int total = 1;
		for(int i=1; i<=a; i++) {
			total*=i;
		}
		return total;
	}
	
}
