package com.Revature.BankExceptions;

public class InsufficientFunds extends Exception {
	
	/*
	 * Define an exception for insufficient funds in a bank account
	 */

	private static final long serialVersionUID = 1L;

	public InsufficientFunds() {
		super();
	}

	public InsufficientFunds(String str) {
		super(str);
	}

}
