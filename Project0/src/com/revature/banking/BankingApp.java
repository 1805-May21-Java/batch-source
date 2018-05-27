package com.revature.banking;
/*
 * Create a console application that will function as a mock bank using solely Java 1.8.
 * Persist your data in a text file.
 * You may also write functionality to serialize your bank after every transaction but this is not a requirement.
 * As a user, I can:
 * create an account with a unique email or username
 * log in 
 * log out
 * deposit money
 * withdraw money
 * view balance
 * To note: There are no strict requirements regarding the flow of operation for your program,
 * but keep the user in mind.
 * Is your menu clear?
 * Is user input validated?
 * Do I have to log back in after each transaction?
 * All important things to consider.
 * 
 * For this program
 * The account creation and log in are part of the first menu.
 * I use a username input for creating an account and nothing more
 * because it does not ask for a password or any other information
 * Once you create an account, you cannot create another one (uniqueness)
 * Log in requires logging in with the same credential username used to create the account
 * There is the option to select 0 to log out and terminate the app without logging in.
 * 
 * Once successfully logged in we reach the second menu.
 * Here is where you can withdraw, deposit, check balance, and exit (same condition 0 as before)
 * The balance is defaulted to 0, as if the user with the username had just opened an account
 * Check balance does exactly what it says.
 * Deposit deposits an amount (float) number into the account.
 * Two safety checks, the first is to not allow nonpositive deposits.
 * The second is to not allow positive deposits over 100 (for convenience)
 * Withdrawal takes amount (float) from account.
 * Two safety checks, first is if balance is 0 or negative.
 * The other is if the amount to withdraw is larger than the amount to deposit
 * User input is supposed to be made clear, so nothing except floats for withdraws and deposits to avoid exceptions
 * Menu should be clear
 * User input is always validated
 * There is no need to log back in for the transaction. Logging out exits the program
 */
import java.util.Scanner;
public class BankingApp {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int choice; //int variable for picking between 0-3
		boolean ex = false; // for the loop, it turns true upon input 0
		float bal = 0f; //balance variable, currently defaulted to 0f
		String username = null; //we will use username as the way to log in, no password specified for the problem
		boolean isLoggedIn = false; // boolean for account menu loop, turns true on input of email.
		while (isLoggedIn == false) { //account menu
			System.out.println("***WELCOME TO THE BANKING APP***");
			System.out.println("1. Log in");
			System.out.println("2. Create an account");
			System.out.println("Enter an integer. Press 0 to log out: ");
			choice = sc.nextInt();
			switch (choice) {
			case 1:
				System.out.print("Please enter your credentials: ");
				//System.out.println(username);
				if (sc.next().equals(username)) {
					System.out.println("Welcome: " + username);
					System.out.println();
					isLoggedIn = true;
					break;
				}
				else {
					System.out.println("Error: invalid credentials.");
					System.out.println();
					break;
				}
			case 2:
				if (username == null) {
					System.out.print("Please enter a valid username: ");
					username = sc.next();
					System.out.println("Account created: " + username + ". You may now log in.");
					System.out.println();
					break;
				}
				else {
					System.out.println("You have already created an account. Please log in.");
					System.out.println();
					break;
				}
			case 0:
				System.out.println("Thank you for using the banking app.");
				System.exit(0);
			default:
				System.out.println("Input is invalid, try again.");
				System.out.println();
			}
		}
		if (isLoggedIn == true) {
		do { //menu
			System.out.println("***WELCOME: " + username + "***");
			System.out.println("1. Make a Deposit");
			System.out.println("2. Make a Withdrawal");
			System.out.println("3. Check Current Balance");
			System.out.print("Enter an integer. Press 0 to log out: ");
				choice = sc.nextInt();
				switch (choice) {
				case 1:
					//deposit money
					float amount;
					System.out.print("Enter the amount to deposit: ");
					amount = sc.nextFloat();
					if (amount <= 0)
						System.out.println("Error: cannot deposit a nonpositive amount of money.");
					else if (amount > 100){ // added a safety check so we do not deposit an abnormal amount of money
						System.out.println("Error: cannot deposit amount in excess of $100");
					}
					else {
						bal += amount; // increment amount from account
						System.out.println("You have deposited $" + amount + " into your account.");
						System.out.println("Your current balance is $" + bal + ".");
					}
					System.out.println();
					break;
				case 2:
					//withdraw money
					System.out.print("Enter the amount to withdraw: ");
					amount = sc.nextFloat();
					if (amount <= 0)
						System.out.println("Error: Please enter a value above $0.00 to withdraw.");
					else if (amount > bal)
						System.out.println("Error: amount to withdraw is higher than current balance!");
					else {
						bal -= amount; //decrement amount from account
						System.out.println("You have withdrawn $" + amount + " from your account.");
						System.out.println("Your current balance is $" + bal + ".");
					}
					System.out.println();
					break;
				case 3:
					//check balance
					System.out.println("Your current balance: $" + bal);
					System.out.println();
					break;
				case 0:
					ex = true;
					break;
				default:
					System.out.println("Input is invalid, try again.");
					System.out.println();
				}

		} while (!ex);
		System.out.println("Thank you for using the banking app.");
		sc.close();
		}
	}
}
