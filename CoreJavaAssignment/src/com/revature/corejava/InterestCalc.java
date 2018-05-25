package com.revature.corejava;

import java.util.Scanner;

//Q17
public class InterestCalc {

	private static Scanner scanner = new Scanner(System.in);
	
	public static void main(String[] args) {
		int principle=0,years=0;
		float rate=0;
		System.out.println("Enter Principle:");
		principle = getNum();
		System.out.println("Enter Rate:");
		rate = getFloat();
		System.out.println("Enter Years:");
		years = getNum();
		
		System.out.println("Interest: "+principle*rate*years);
		
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
	private static float getFloat() {
		float num=0;
		try {
			num = Float.parseFloat(scanner.nextLine());
		} catch (NumberFormatException e) {
			System.out.println("Invalid input, please enter a whole Number");
			getFloat();
		}
		return num;
	}
}
