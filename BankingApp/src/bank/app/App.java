package bank.app;

import java.io.*;
import java.util.HashMap;
import java.util.Scanner;

import bank.users.Account;

//App will serve as the main program for this project
//running App will carry out all requested functionality
//as described in the project specifications.
public class App {
	
	
	public static void main (String[] args) throws IOException {
		
		//All user bank accounts are retrieved from the text file
		//and put in a HashMap
		BankAccounts theBank = new BankAccounts();
		HashMap<String, Account> accountsList = theBank.getBankAccounts();
		
		//Scanner object to allow user to use and/or create bank account
		Scanner userInput = new Scanner(System.in);
		//Strings accountLine and transact line are used
		//in the two while loops below to used user input data
		String accountLine;
		String transactLine;
		//String username will be used to retrieve the specific Account
		//from the accounstList HashMap
		String username = "";
		//newAccount will be used when creating a new Account in the first
		//while loop
		Account newAccount = null;
		
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
					newAccount = new Account(username, password, initialChecking, initialSavings);
					accountsList.put(username, newAccount);
					accountsList.get(username).logOn();
					System.out.println("New account created, welcome " + username);
				}
				
				//If username exist in accountsList, then Account object is
				//retrieved using username as the key.
				//Account object is also set to true.
			}else if(accountsList.containsKey(accountLine)) {
				username = accountLine;
				System.out.println("Valid username entered, please type in password:");
				accountLine = userInput.nextLine();
				if((accountsList.get(username)) != null) {
					accountsList.get(username).logOn();
					System.out.println(username + " is now logged on");
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
		while(accountsList.get(username).isUserLoggedOn()) {
			//User is given option of actions to choose from
			System.out.println("Please type letter to choose from options below: ");
			System.out.println("A: View Balance");
			System.out.println("B: Deposit Funds");
			System.out.println("C: Withdraw Funds");
			System.out.println("D: Log off account");
			transactLine = userInput.nextLine();
			
			//This prints user's Checking and Saving's account information.
			if(transactLine.equalsIgnoreCase("A")) {
				accountsList.get(username).viewBalance();
				System.out.println();
				
				//This handles deposit to account
			}else if(transactLine.equalsIgnoreCase("B")) {
				System.out.println("Deposit to Checking or Savings?");
				//user can specify between Checking or Savings
				System.out.println("Decide account by typing CHECKING or SAVINGS:");
				String accountType = userInput.nextLine();
				
				System.out.println("Please give amount to deposit:");
				//gets Double from read String.
				double deposit = Double.parseDouble(userInput.nextLine());
				//calls method to deposit, if successful, account will update
				//else a method will print a statement explaining error.
				accountsList.get(username).depositFunds(deposit, accountType);
				System.out.println();
				
				//This handles withdrawal from account
			}else if(transactLine.equalsIgnoreCase("C")) {
				System.out.println("Withdraw from Checking or Savings?");
				//user can specify between Checking or Savings
				System.out.println("Decide account by typing CHECKING or SAVINGS:");
				String accountType = userInput.nextLine();
				
				System.out.println("Please give amount to withdraw:");
				//gets Double from read String
				double withdrawal = Double.parseDouble(userInput.nextLine());
				//calls method to withdraw, if successful, account will update
				//else a method will print a statement explaining error.
				accountsList.get(username).withDrawFunds(withdrawal, accountType);
				System.out.println();
				
				//This logs the user out and exits the while loop.
			}else if(transactLine.equalsIgnoreCase("D")) {
				accountsList.get(username).logOff();	
				//Any other input from options, then print statement will
				//let the reader now to type another option again.
			}else {
				System.out.println("Error in option input, please try again");
				System.out.println();
			}
		}
		System.out.println(username + " has logged off.");
		//bankData.txt is updated using static method from UpdateData
		//userInput Scanner is closed to prevent resource leak
		UpdateData.updateBankAccounts(accountsList);
		userInput.close();
		
		
		
		
	}
	

}
