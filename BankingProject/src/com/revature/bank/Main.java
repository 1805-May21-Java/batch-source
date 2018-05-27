package com.revature.bank;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.Scanner;


public class Main {

	private static Scanner scanner = new Scanner(System.in);
	private static Account curAcct;
	public static void main(String[] args) {
		//Store data in username.txt
		//Prompt Login or Create Account
		//Prompt a user for their username
		//if the username does exist, prompt for password - warn if wrong
		//display menu with options for: Deposit, View Current Balance, Withdraw, Quit
		//Quit returns to the the "login" screen and prompts for username
		promptLogin();
		
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
		System.out.println("Please Enter your Username");
		username = scanner.nextLine();
		try {
			FileInputStream fileInputStream= new FileInputStream("src/com/revature/bank/"+username+".ser");
			ObjectInputStream objectInputStream = new ObjectInputStream(fileInputStream);
			curAcct = (Account) objectInputStream.readObject();
			objectInputStream.close();
			promptPassword();
		} catch (FileNotFoundException e) {
			System.out.println("Invalid Username");
			login();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	public static void promptPassword() {
		System.out.println("Please enter your password:");
		String password = scanner.nextLine();
		int failedNum=0;
		if(!password.equals(curAcct.getPassword())) {
			failedNum++;
			System.out.println("Incorrect Password");
			if(failedNum==3) {
				System.out.println("Too many failed attempts");
				promptLogin();
			}
			promptPassword();
		}
		System.out.println("Welcome "+curAcct.getOwner()+".  What would you like to do?");
		curAcct.setLoggedIn(true);
		displayMenu();
	}
	public static void displayMenu() {
		System.out.println("1: Display Current Balance");
		System.out.println("2: Deposit Money");
		System.out.println("3: Withdraw Money");
		System.out.println("0: Logout");
		String in2 = scanner.nextLine();
		switch (in2) {
			case "1":
				//display balance
				System.out.println("You have $"+curAcct.getBalance()+" remaining");
				displayMenu();
				break;
			case "2":
				//deposit money
				depositMoney();
				break;
			case "3":
				//withdraw
				withdrawMoney();
			case "0":
				//logout
				System.out.println("Thank you for Banking with us!");
				try {
					FileOutputStream fileOutputStream = new FileOutputStream("src/com/revature/bank/"+curAcct.getUsername()+".ser");
					ObjectOutputStream objectOutputStream = new ObjectOutputStream(fileOutputStream);
					objectOutputStream.writeObject(curAcct);
					objectOutputStream.close();
					fileOutputStream.close();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
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
		curAcct = new Account(owner, username, password, 0, true);
		displayMenu();

	}
	public static String getUsername() {
		String un="";
		System.out.println("Please enter a unique username: ");

		un = scanner.nextLine();
		File file = new File("src/com/revature/bank/"+un+".ser");
		if(file.exists()) {
			System.out.println("Username is already taken.");
			return getUsername();
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
