package com.revature.bankingapp;

public class Driver {
	public static void main(String[] args) {
		// Get an instance of the bank
		Bank myBank = Bank.getInstance();
		// Open bank
		myBank.open();
	}

}
