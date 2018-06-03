package com.revature.main;


import com.revature.pojos.Bank;

public class Driver {

	public static void main(String[] args) {
		Bank myBank = Bank.getInstance();
		
		Bank.updateBankObject();
		
		System.out.println(myBank);
	}
}
