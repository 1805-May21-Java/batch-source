package com.revature.project0;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class Driver {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		ArrayList<Account> accounts = new ArrayList<>();
		BufferedReader br = null;
		String path = "src/com/revature/project0/Data.txt";
		
		try {
			br = new BufferedReader(new FileReader(path));
			String line = null;
			
			while((line = br.readLine()) != null) {
				String[] parts = line.split(",");
				Account newAccount = new Account(parts[0], parts[1], Double.parseDouble(parts[2]));
				accounts.add(newAccount);
			}
			
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			if(br != null) {
				try {
					br.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}

		Bank bank = new Bank(accounts);
		
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
				System.out.println("Enter 1 to view balance. Enter 2 to deposit money. Enter 3 to withdraw money. Enter 4 to logout and exit.");
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
						account.deposit(amount);
						System.out.println("Successfully deposited " + amount + " dollars.");
						break;
					case "3":
						System.out.println("How much money would you like to withdraw?");
						amount = Double.parseDouble(sc.nextLine());
						account.withdraw(amount);
						System.out.println("Successfully withdrew " + amount + " dollars.");
						break;
					case "4":
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
