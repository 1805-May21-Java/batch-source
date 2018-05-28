package com.revature.p0;

public class BankDrive {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		MockBank myBank = new MockBank();
		System.out.println("Welcome to our bank!");
		myBank.AccountHub();
		
		/*
		 * On boot:
		 * 1. give option to either make account or log in
		 * 			(use 1 for make new, 2 for log in)
		 * 2. have input be a string for name entrance
		 * 2a. if make new, save it to doc for later, go directly to main hub
		 * 2b. if login, check for a matching name 
		 * 3. Once in, allow to either deposit money, withdraw money,
		 * 		 view balance, or log out (1 for deposit, 2 for withdrawal, 3 for view)
		 * 4. If deposit or withdrawal, take a double as input
		 * 5. If view, print out currentBalence
		 * 6. if 4 or 5, send back to 3
		 * 7. if log out, send back to 1
		 */
		}
}