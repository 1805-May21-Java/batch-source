package com.revature.revaturebankingapp;

import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.Scanner;

public class Driver {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		User u2 = new User();
		Account a1 = new Account();
		
		System.out.println("Hello and welcome to the Revature Banking App!");
		System.out.println();
		System.out.println("-->Press 1 to login");
		System.out.println("-->New user? Press 2 to create an account!");
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
			System.out.println("MENU");
			System.out.println("-->Press 1 to view your accounts");
			System.out.println("-->Press 2 to create a new account");
			System.out.println("-->Press 3 to deposit money to your accounts");
			System.out.println("-->Press 4 to withdrawal money from your accounts");
			System.out.println("-->Press 5 to log out");
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
		}else {System.out.println("Invalid option selected. Please select again");}
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		/*try {
		Connection con = ConnectionUtility.getConnection();
		System.out.println(con.getMetaData().getDriverName());
	} catch (SQLException | IOException e) {
		e.printStackTrace();
	}*/
		//UserDAOImpl user = new UserDAOImpl();
		/*User u = new User(10, "beeson@email.com", "password1", "Seth", "Beeson");
		user.createUser(u);*/
		
		/*User u = new User(5, "newemail@email.com", "newpassword", "Beeson", "Beeson");
		user.updateUser(u);*/
		
		//user.deleteUser(5);
		
		//AccountDAOImpl account = new AccountDAOImpl();
		
		/*Account a = new Account(6, "HGHGHG", 100, 3);
		a.deposit(999);
		a.withdraw(2000);
		account.updateBalance(a);
		System.out.println(a.toString());
		System.out.println(a.getAccountid());
		System.out.println(a.getBalance());*/
		
		//System.out.println(account.balanceInquiry(6));
		
		
		

	}

	}}
