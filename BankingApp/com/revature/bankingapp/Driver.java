package com.revature.bankingapp;

import java.util.Scanner;

public class Driver {
	
	private static Scanner sc = new Scanner(System.in);

	public static void main(String[] args) {
		
		/*
		 * checklist:
		 * create account with unique email or username
		 * log in
		 * log out
		 * deposit money
		 * withdraw money
		 * view balance
		 */
		
		mainPage(); // start bank program	
	}
	
	// Welcome screen
	public static void mainPage() {
		System.out.println("******************************");
		System.out.println("*                            *");
		System.out.println("*  Welcome to Bank Mercier!  *");
		System.out.println("*                            *");
		System.out.println("******************************");
		System.out.println();
		
		loginMenu(); // call up navigation
	}
	
	// Displays the navigation options on the main page
	public static void loginMenu() {
		// navigation menu
		System.out.println("Navigate using the following commands:");
		System.out.println();
		System.out.println("      Enter \"login\" to login.");
		System.out.println("      Enter \"new\" to create a new account.");
		System.out.println("      Enter \"exit\" to end the program.");
		System.out.println();
		
		// Get user input
		System.out.print("Select an option: ");
		String input = sc.next().toLowerCase(); // not case sensitive
		System.out.println();
		if (input.equals("login")) {
			System.out.println("Logging you in...");
			System.out.println();
			loginPage(); // log in
		} else if (input.equals("new")) {
			System.out.println("Creating new account...");
			System.out.println();
			newUserPage(); // create new user
		} else if (input.equals("exit")) {
			System.out.println("Goodbye!"); // quit program
		} else {
			System.out.println("Input was not valid. Try again.");
			System.out.println();
			loginMenu(); // refresh menu when invalid input is entered
		}
	}
	
	public static void loginPage() {
		System.out.println("****************");
		System.out.println("*              *");
		System.out.println("*  User Login  *");
		System.out.println("*              *");
		System.out.println("****************");
	}
	
	public static void newUserPage() {
		System.out.println("*********************");
		System.out.println("*                   *");
		System.out.println("*  Create New User  *");
		System.out.println("*                   *");
		System.out.println("*********************");
	}

}
