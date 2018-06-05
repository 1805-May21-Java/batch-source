package com.revature.revaturebankingapp;

import java.util.Scanner;

public class Utilities {

	public int menu() {
		Scanner sc = new Scanner(System.in);
		System.out.println("Hello and welcome to the Revature Banking App!");
		System.out.println();
		System.out.println("-->Press 1 to login");
		System.out.println("-->New user? Press 2 to create an account!");
		int start = Integer.parseInt(sc.nextLine());
		return start;
	}
}
