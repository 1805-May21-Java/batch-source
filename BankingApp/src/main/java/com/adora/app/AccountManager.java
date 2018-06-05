package com.adora.app;

import java.util.ArrayList;
import java.util.List;

import com.adora.access.AccountDao;
import com.adora.access.AccountDaoImpl;
import com.adora.object.Account;

public class AccountManager {

	private static AccountDao adi= new AccountDaoImpl();
	private static List<Account> userAccountsList;
	private static List<String> userAccountListString;
	private static Account currentAccount;
	
	static List<String> getAccountList() {
		if(userAccountListString == null) {
			userAccountListString = new ArrayList<String>();
			userAccountsList = adi.getUserAccounts(LoginManager.getCurrentUser());
			for(Account l : userAccountsList) {
				userAccountListString.add(String.format("%-8s: %010d", l.getAccountType(), l.getAccountId()));
			}
		}
		
		return userAccountListString;
	}
	
	static void setCurrentAccount(int i) {
		currentAccount = userAccountsList.get(i);
	}
	
	static double getBalance() {
		return currentAccount.getAccountBalance();
	}
	static void deposit(Double amount) {
		if(amount < 0) {
			System.out.println("Cannot deposit a negative amount.");
			return;
		}
		if(currentAccount.getAccountBalance() + amount > 999_999_999_999.99) {
			System.out.println("Cannot deposit such a large sum.");
			return;
		}
		if((amount * 100 % 1) != 0) {
			System.out.println("You cannot deposit partial cents.");
			return;
		}
		
		//update locally and on database
		currentAccount.setAccountBalance(currentAccount.getAccountBalance() + amount);
		adi.updateAccount(currentAccount);
		
		System.out.println("Deposit processed.");
		System.out.println(String.format("New account balance is %.2f.", currentAccount.getAccountBalance()));
	}
	static void withdraw(Double amount) {
		if(amount < 0) {
			System.out.println("Cannot withdraw a negative amount.");
			return;
		}
		if(amount > currentAccount.getAccountBalance()) {
			System.out.println("Cannot withdraw more than account balance.");
			return;
		}
		if((amount * 100 % 1) != 0) {
			System.out.println("You cannot withdraw partial cents.");
			return;
		}
		
		// update locally and on database
		currentAccount.setAccountBalance(currentAccount.getAccountBalance() - amount);
		adi.updateAccount(currentAccount);
		
		System.out.println("Withdrawal processed.");
		System.out.println(String.format("New account balance is %.2f.", currentAccount.getAccountBalance()));
	}
	
	static void clearAccount() {
		currentAccount = null;
		userAccountsList = null;
		userAccountListString = null;
	}

}
