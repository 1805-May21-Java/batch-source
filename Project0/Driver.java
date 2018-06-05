package com.revature.revaturebankingapp;

import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.Scanner;

public class Driver {

	public static void main(String[] args) {
		//Placeholder objects
		Scanner sc = new Scanner(System.in);
		User u2 = new User();
		Account a1 = new Account();
		
		//User is prompted with option to login to existing account or register new one
		System.out.println("Hello and welcome to the Revature Banking App!");
		System.out.println();
		System.out.println("-->Press 1 to login");
		System.out.println("-->New user? Press 2 to create an account!");
		int start = Integer.parseInt(sc.nextLine());
		
		//Response is sorted by if/else if statement and appropriate method is called
		if (start == 1) {
			u2 = u2.login();
		} else if (start == 2) {
			u2 = u2.newUser();
		} else {
			
		}
		System.out.println();
		System.out.println();
		
		boolean loggedin = true;
		
		//After user is registered and/or logged in, they are placed in while loop that presents Menu and options until user chooses to "log out"
		while (loggedin = true) {
			System.out.println("MENU");
			System.out.println("-->Press 1 to view your accounts");
			System.out.println("-->Press 2 to create a new account");
			System.out.println("-->Press 3 to deposit money to your accounts");
			System.out.println("-->Press 4 to withdrawal money from your accounts");
			System.out.println("-->Press 5 to log out");
			try {int option = Integer.parseInt(sc.nextLine());
		
		//Depending on users choice, appropriate methods are called
			if (option == 1) {
				a1.viewAccounts(u2);
				System.out.println();
		} else if (option == 2) {
				a1.newAccount(u2);
				System.out.println();
		} else if (option == 3) {
				a1.viewAccounts(u2);
				a1.deposit();
		} else if (option == 4) {
				a1.viewAccounts(u2);
				a1.withdraw();
		} else if (option == 5) {
				loggedin = false;
				System.out.println("See you soon!");
				break;
		}else {System.out.println("Invalid option selected. Please select again");}
			
			} catch (NumberFormatException e) {
				System.out.println("Please enter a valid integer to select your option.");
				
			}

	}

	}}
