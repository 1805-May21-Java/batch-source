package com.revature.corejava;

import java.util.Scanner;

//Q5
public class Substring {
	static Scanner scanner = new Scanner(System.in);

	public static void main(String[] args) {
		System.out.println("Enter a String:");
		String s = scanner.nextLine();
		System.out.println("Enter an Index:");
		int num=0;
		num=getNum();
		String temp = "";
		for(int i=0; i<num;i++) {
			temp+=s.charAt(i);
		}
		System.out.println("New Substring: "+temp);
		
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
