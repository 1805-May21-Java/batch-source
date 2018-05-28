package com.revature;

import menu.ExistingAccount;

public class BankDriver {
	
	//driver class for Tank Bank
	public static void main(String[] args) {
		//brings user to a menu asking if they already have an account
		//this leads the user through the entire menu system
		ExistingAccount.Existing(new Client());
	}
}
