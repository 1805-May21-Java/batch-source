package com.revature.project0;

import java.util.ArrayList;
import java.util.Scanner;

public class Driver {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		Bank bank = new Bank();
		bank.read();
		ArrayList<Account> accounts = bank.getAccounts();
		
		String operation = "";
		String username;
		String password;
		Account account = null;
		boolean flag = false;
		
		while(flag != true) {
			System.out.println("Welcome! Enter 1 to create a new account or 2 to log in to an existing account.");
			operation = sc.nextLine();
			switch(operation) {
				case "1":
					System.out.println("Enter your username.");
					username = sc.nextLine();
					System.out.println("Enter your password.");
					password = sc.nextLine();
					account = new Account(username, password);
					if(bank.createAccount(account)) {
						System.out.println("Account successfully created!");
						flag = true;
					}
					else
						System.out.println("An account with that username already exists. Please try again with a different username.");
					break;
				case "2":
					System.out.println("Enter your username.");
					username = sc.nextLine();
					System.out.println("Enter your password.");
					password = sc.nextLine();
					if(bank.login(username, password)) {
						flag = true;
						for(Account acc : accounts) {
							if(acc.getUsername().equals(username)) 
								account = acc;
						}
					}
					break;
				default:
					System.out.println("Invalid operation");
					break;
			}
		}
		
		double amount = 0.0;
		flag = false;
		
		if(account.isLoggedIn()) {
			while(flag != true) {
				System.out.println();
				System.out.println("Enter 1 to view balance. Enter 2 to deposit money. Enter 3 to withdraw money. Enter 4 to transfer funds to another account. Enter 5 to logout and exit.");
				operation = sc.nextLine();
				switch(operation) {
					case "1":
						double balance = account.getBalance();
						System.out.println("Your balance is " + balance);
						if(balance < 0.0)
							System.out.println("Warning! Your account balance is negative. You will face overdraft fees.");
						break;
					case "2":
						System.out.println("How much money would you like to deposit?");
						amount = Double.parseDouble(sc.nextLine());
						if(amount < 0) {
							System.out.println("You must enter a positive number.");
						} else {
							account.deposit(amount);
							System.out.println("Successfully deposited " + amount + " dollars.");
						}
						break;
					case "3":
						System.out.println("How much money would you like to withdraw?");
						amount = Double.parseDouble(sc.nextLine());
						if(amount < 0) {
							System.out.println("You must enter a positive number.");
						} else {
							account.withdraw(amount);
							System.out.println("Successfully withdrew " + amount + " dollars.");	
						}
						break;
					case "4":
						System.out.println("How much money would you like to transfer?");
						amount = Double.parseDouble(sc.nextLine());
						if(amount < 0) {
							System.out.println("You must enter a positive number.");
						} else {
							System.out.println("Enter the username of the account to transfer the funds to.");
							username = sc.nextLine();
							if(bank.transfer(username, amount)) {
								account.withdraw(amount);
								System.out.println("Successfully transferred " + amount + " dollars to " + username);
							} else {
								System.out.println("An account with that username does not exist");
							}
						}
						break;
					case "5":
						bank.logout(account);
						flag = true;
						System.out.println("Good bye!");
						break;
					default:
						System.out.println("Invalid operation");
						break;	
				}
			}
		}
				
		sc.close();
	}

}
