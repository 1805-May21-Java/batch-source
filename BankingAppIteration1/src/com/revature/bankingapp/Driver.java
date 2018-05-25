package com.revature.bankingapp;

public class Driver {
	public static void main(String[] args) {
		Bank myBank = Bank.getInstance();
		myBank.open();
	}

}
