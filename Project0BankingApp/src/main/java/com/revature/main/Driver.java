package com.revature.main;

import java.io.*;
import java.sql.*;
import java.util.*;

import com.revature.dao.UserAccountDAOImpl;
import com.revature.model.Account;
import com.revature.model.UserAccount;
import com.revautre.util.ConnectionUtil;

public class Driver {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		UserAccount u2 = new UserAccount();
		Account a1 = new Account();
		
		System.out.println("Welcome to my bank!");
		System.out.println();
		System.out.println("Press 1 to login or Press 2 to create an account");
		int start = Integer.parseInt(sc.nextLine());
		
		if (start == 1) {
			u2 = u2.login();
		} else if (start == 2) {
			u2 = u2.newUser();
		} else {
			
		}
		System.out.println();
		System.out.println();
		
		boolean loggedin = true;
		
		while (loggedin = true) {
			System.out.println("ACCOUNT MENU");
			System.out.println("Press 1 to view your accounts");
			System.out.println("Press 2 to create a new account");
			System.out.println("Press 3 to deposit money");
			System.out.println("Press 4 to withdraw money");
			System.out.println("Press 5 to log out");
			int option = Integer.parseInt(sc.nextLine());
			
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
		}else {
			System.out.println("Invalid option selected. Please select again");
		}
		
		}
	}
}


