package com.revature.main;

import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.Scanner;

import com.revature.util.ConnectionUtil;
import com.revature.dao.AccountDaoImpl;
import com.revature.pojos.Account;

public class AppDriver {
	
	public static void main (String[] args){
		
		//Try/Catch block used to catch any possible IOException or SQLException
		try {
			//Opens up connection to Sql Database
			Connection con = ConnectionUtil.getConnection();
			
			//This object contains methods to read and write to database
			AccountDaoImpl ad1 = new AccountDaoImpl();
			
			//All user bank accounts are retrieved from the database
			//and put in a HashMap
			HashMap<String, Account> accountsList = ad1.getAccounts();
			
			//This for loop is to only be used during demonstration
			for(Account acc : accountsList.values()) {
				System.out.println(acc);
			}
			System.out.println();
			System.out.println();
			
			//Scanner object to allow user to use and/or create bank account
			Scanner userInput = new Scanner(System.in);
			
			//Strings accountLine and transact line are used
			//in the two while loops below to used user input data
			String accountLine;
			String transactLine;
			
			//String username will be used to retrieve the specific Account
			//from the accounstList HashMap
			String username = "";
			
			//currentAccount will be used when creating a new Account in the first
			//while loop and will serve as a local copy of the logged on account
			Account currentAccount = null;
			
			System.out.println("Welcome to the bank, please log in with your usersame.");
			System.out.println("If you do not have an account, please type CREATE ACCOUNT");
			
			//The while loop will continue until username does not equal ""
			while(username.equals("")) {
				accountLine = userInput.nextLine();
				
				//If user inputs CREATE ACCOUNT, user must type in a username to use.
				if(accountLine.equalsIgnoreCase("CREATE ACCOUNT")) {
					System.out.println("Please give the following information for your new account.");
					System.out.println("Username: ");
					username = userInput.nextLine();
					
					//If it is an already existing username, loop will iterate again.
					if(accountsList.containsKey(username)) {
						System.out.println("Username is already taken");
						System.out.println("Use valid username to log in or create account by typing CREATE ACCOUNT");
						username = "";
						
						//the program ask user to supply password, and initial checking and
						//savings amount. The data is stored in local variables
						
					}else {
						System.out.println("Password:");
						String password = userInput.nextLine();
						System.out.println("Initial checking amount:");
						double initialChecking = Double.parseDouble(userInput.nextLine());
						System.out.println("Initial savings amount:");
						double initialSavings = Double.parseDouble(userInput.nextLine());
						
						//newAccount becomes a new instance of Account, using the local variables
						//containing relevant data. The object is then added to accountsLists and
						//the object's userLoggedOn member is set to true.
						currentAccount = new Account(username, password, initialChecking, initialSavings);
						
						//Inserts a new row into the database.
						ad1.createAccount(currentAccount);
						
						accountsList.put(username, currentAccount);
						currentAccount.logOn();
						System.out.println("New account created, welcome " + currentAccount.getUsername());
					}
					
					//If username exist in accountsList, then Account object is
					//retrieved using username as the key.
					//Account object's isLoggedOn boolean is also set to true.
				}else if(accountsList.containsKey(accountLine)) {
					String currentUsername = accountLine;
					System.out.println("Valid username entered, please type in password:");
					accountLine = userInput.nextLine();
					if((accountsList.get(currentUsername).getPassword()).equals(accountLine)) {
						
						//currentAccount is now populated with object from HashMap accountList
						//where the object's username String matches the String variable currentUsername
						currentAccount = accountsList.get(currentUsername);
						currentAccount.logOn();
						username = currentUsername;
						System.out.println(username + " is now logged on");
					}else {
						System.out.println("Password is incorrect.");
						System.out.println("Please type in correct username and password");
					}
					
					//If user did not type CREATE USER or a valid username,
					//"Invalid username is printed" and while loop continues to next iteration.
				}else {
					System.out.println("Invalid username");
					System.out.println("Please type in a valid username or CREATE ACCOUNT");
				}
				
			}
			
			//Handles banking transaction options
			//while loop checks that Account having username in accountsList
			//has userLoggedOn set to true.
			while(currentAccount.isUserLoggedOn()) {
				
				//User is given option of actions to choose from
				System.out.println("Please type letter to choose from options below: ");
				System.out.println("A: View Balance");
				System.out.println("B: Deposit Funds");
				System.out.println("C: Withdraw Funds");
				System.out.println("D: Transfer Funds");
				System.out.println("E: Log off account");
				System.out.println("F: Delete account");
				transactLine = userInput.nextLine();
				
				//This prints user's Checking and Saving's account information.
				if(transactLine.equalsIgnoreCase("A")) {
					currentAccount.viewBalance();
					System.out.println();
					
					//This handles deposit to account
				}else if(transactLine.equalsIgnoreCase("B")) {
					System.out.println("Deposit to Checking or Savings?");
					
					//user can specify between Checking or Savings
					System.out.println("Decide account by typing CHECKING or SAVINGS:");
					String accountType = userInput.nextLine().toUpperCase();
					
					System.out.println("Please give amount to deposit:");
					//gets Double from read String.
					double deposit = Double.parseDouble(userInput.nextLine());
					
					//calls method to deposit, if successful, account will update
					//else a method will print a statement explaining error.
					//accountsList.get(username).depositFunds(deposit, accountType);
					//Updates database account
					ad1.depositFunds(currentAccount.getUsername(), accountType, deposit);
					//updates local Account object
					currentAccount.depositFunds(deposit, accountType);
					System.out.println();
					
					//This handles withdrawal from account
				}else if(transactLine.equalsIgnoreCase("C")) {
					System.out.println("Withdraw from Checking or Savings?");
					
					//user can specify between Checking or Savings
					System.out.println("Decide account by typing CHECKING or SAVINGS:");
					String accountType = userInput.nextLine().toUpperCase();
					
					System.out.println("Please give amount to withdraw:");
					
					//gets Double from read String
					double withdrawal = Double.parseDouble(userInput.nextLine());
					
					//Updates database Account
					ad1.withDrawFunds(currentAccount.getUsername(), accountType, withdrawal);
					
					//Updates local Account
					currentAccount.withDrawFunds(withdrawal, accountType);
					System.out.println();
					
					//This logs the user out and exits the while loop.
				}else if(transactLine.equalsIgnoreCase("D")) {
					System.out.println("Transfer funds");
					
					//user can specify between Checking or Savings
					System.out.println("Decide which account to transfer from:");
					String fromAccount = userInput.nextLine().toUpperCase();
					System.out.println("Decide which account to transfer to:");
					String toAccount = userInput.nextLine().toUpperCase();
					System.out.println("Please give amount to transfer:");
					
					//gets Double from read String
					double transferAmount = Double.parseDouble(userInput.nextLine());
					currentAccount.transferFunds(fromAccount, toAccount, transferAmount);
					
					//Updates database Account
					ad1.updateAccount(currentAccount);
					System.out.println();
				}else if(transactLine.equalsIgnoreCase("E")) {
					currentAccount.logOff();	
					
					//Any other input from options, then print statement will
					//let the reader now to type another option again.
					System.out.println(username + " has logged off.");
				}else if(transactLine.equalsIgnoreCase("F")) {
					
					//Account with matching username is deleted from the database
					ad1.deleteAccountByUsername(currentAccount.getUsername());
					
					//Local copy is logged off to exit the loop
					currentAccount.logOff();
					System.out.println("Account has been deleted.");
					
				}else {
					System.out.println("Error in option input, please try again");
					System.out.println();
				}
			}
			System.out.println("Thank you for your business.");
			
			//Connection con and Scanner userInput are closed to prevent resource leaks.
			con.close();
			userInput.close();
			
		} catch (SQLException | IOException e) {
			e.printStackTrace();
		}
		
	}
	

}
