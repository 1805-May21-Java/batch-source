package com.revature.menus;

import java.util.Scanner;

import com.revature.dao.BankAccountDaoImpl;
import com.revature.dao.BankUserDaoImpl;
import com.revature.models.BankAccount;
import com.revature.models.BankUser;

public class UserMenu {
	public BankUser display() {
		Scanner sc = new Scanner(System.in);
		boolean flag = false;
		String operation = "";
		BankUserDaoImpl udi = new BankUserDaoImpl();
		BankAccountDaoImpl adi = new BankAccountDaoImpl();
		BankUser user = null;

		while(flag != true) {
			System.out.println("Welcome!\nEnter 1 to create a new account or\n2 to log in to an existing account.");
			
			operation = sc.nextLine();
			switch(operation) {
				case "1":
					System.out.println("Enter your username.");
					String username = sc.nextLine();
					System.out.println("Enter your password.");
					String password = sc.nextLine();
					user = new BankUser(username, password);
					if(udi.createUser(user).equals(username)) {
						flag = true;
						BankAccount account = new BankAccount(0, user);
						adi.createAccount(account);
						System.out.println("Account created");
					}
					break;
				case "2":
					System.out.println("Enter your username.");
					username = sc.nextLine();
					System.out.println("Enter your password.");
					password = sc.nextLine();
					user = udi.getUser(username, password);
					if(user != null) {
						flag = true;
						System.out.println("User logged in.");
					} else {
						System.out.println("Invalid username/password combination. Please try again");
					}
					break;
				default:
					System.out.println("Invalid operation");
					break;
			}
		}
		return user;
	
	}
}
