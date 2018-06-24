package com.revature.util;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import org.hibernate.Session;

import com.revature.bank.Account;
import com.revature.bank.Transaction;
import com.revature.dao.AccountDaoImpl;
import com.revature.dao.TransactionDaoImpl;

public class Driver {
	
	private static Scanner scanner = new Scanner(System.in);
	private static Account curAcct;
	private static AccountDaoImpl adi = new AccountDaoImpl();
	private static TransactionDaoImpl tdi = new TransactionDaoImpl();
	private static int failedPWNum=0, failedUNNum=0;

	public static void main(String[] args) {
		promptLogin();
		/*Session s = HibernateUtil.getSession();
		s.close();*/
	}
	
	public static void promptLogin() {
		System.out.println("Enter 1 to Login\nEnter 2 to Create a new Account\nEnter 0 to Quit ");
		String in1 = scanner.nextLine();
		switch (in1) {
			case "1":
				login();
				break;
			case "2":
				createAcct();
				break;
			case "0":
				return;
	
			default:
				System.out.println("Invalid Entry");
				promptLogin();
				break;
		}
	}
	
	public static void login() {
		String username;
		System.out.println("Please Enter your Username:");
		username = scanner.nextLine();
		curAcct = adi.getAccountById(username);
		if(curAcct==null) {
			System.out.println("Username does not exist.");
			failedUNNum++;
			if(failedUNNum==3) {
				failedUNNum=0;
				System.out.println("Too many failed attempts");
				promptLogin();
			}
			login();
		}
		if(curAcct!=null) promptPassword();
		
	}
	public static void promptPassword() {
		System.out.println("Please enter your password:");
		String password = scanner.nextLine();
		if(!password.equals(curAcct.getPassword())) {
			failedPWNum++;
			System.out.println("Incorrect Password");
			if(failedPWNum==3) {
				failedPWNum=0;
				System.out.println("Too many failed attempts");
				promptLogin();
			}
			if(curAcct!=null) promptPassword();
		} if(curAcct!=null) {
			System.out.println("Welcome "+curAcct.getOwner()+".  What would you like to do?");
			displayMenu();
		}
	}
	public static void displayMenu() {
		System.out.println("1: Display Current Balance");
		System.out.println("2: Deposit Money");
		System.out.println("3: Withdraw Money");
		System.out.println("4: View Transaction History");
		System.out.println("0: Logout");
		String in2 = scanner.nextLine();
		switch (in2) {
			case "1":
				//display balance
				System.out.printf("You have $%.2f remaining\n",curAcct.getBalance());
				displayMenu();
				break;
			case "2":
				//deposit money
				depositMoney();
				break;
			case "3":
				//withdraw
				withdrawMoney();
				break;
			case "4":
				for(Transaction t: tdi.getAllTransactions(curAcct)) {
					System.out.println(t);
				}
				displayMenu();
				break;
			case "0":
				//logout
				System.out.println("Thank you for Banking with us!");
				adi.updateAccount(curAcct);
				
				curAcct = null;
				promptLogin();
				break;
			default:
				System.out.println("Invalid input");
				displayMenu();
				break;
		}
	}
	
	public static void withdrawMoney(){
		System.out.println("Please enter how much you would like to withdraw:");
		try{
			int code = curAcct.withdraw(Float.parseFloat(scanner.nextLine()));
			switch (code) {
			case -1:
				System.out.println("You have insufficient funds.");
				displayMenu();
				break;
			case 0:
				promptLogin();
				break;
			default:
				adi.updateAccount(curAcct);
				displayMenu();
				break;
			}
		} catch (NumberFormatException e) {
			System.out.println("Invalid input.");
			displayMenu();
		}
		
	}
	public static void depositMoney() {
		System.out.println("Please enter how much you would like to deposit:");
		try{
			int code = curAcct.deposit(Float.parseFloat(scanner.nextLine()));
			switch (code) {
			case -1:
				System.out.println("Cannot deposit a negative amount of money.");
				displayMenu();
				break;
			case 0:
				promptLogin();
				break;
			default:
				adi.updateAccount(curAcct);
				displayMenu();
				break;
			}
		} catch (NumberFormatException e) {
			System.out.println("Invalid input.");
			displayMenu();
		}
	}
	public static void createAcct() {
		String owner, username, password;
		System.out.println("Welcome to my bank! \nWhat is your name:");
		owner = scanner.nextLine();
		username = getUsername();
		password =  getPassword();
		curAcct = new Account(owner, username, password, 0);
		adi.CreateAccount(curAcct);
		displayMenu();

	}
	public static String getUsername() {
		String un="";
		System.out.println("Please enter a unique username: ");
		List<Account> accts = new ArrayList<>();
		accts = adi.getAllAccounts();
		un = scanner.nextLine();
		for(Account a : accts) {
			if(un.equals(a.getUsername())) {
				System.out.println("That username is already taken.");
				getUsername();
			}
		}
		
		return un;
	}
	public static String getPassword() {
		String pw="",pw2="";
		System.out.println("Please enter a password");
		pw = scanner.nextLine();
		System.out.println("Please confirm your password");
		pw2 = scanner.nextLine();
		if(!pw.equals(pw2)) {
			System.out.println("Passwords do not match");
			return getPassword();
		}
		return pw;
	}
}
