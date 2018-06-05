package com.revature.pojos;

import java.util.ArrayList;

import com.revature.dao.AccountDaoImpl;
import com.revature.dao.TransactionDaoImpl;

public class Bank {
	private ArrayList<User> users;
	private ArrayList<Account> accounts;
	
	public Bank() {
		super();
	}
	
	public Bank(ArrayList<User> users, ArrayList<Account> accounts) {
		super();
		this.users = users;
		this.accounts = accounts;
	}

	public ArrayList<User> getUsers() {
		return users;
	}

	public void setUsers(ArrayList<User> users) {
		this.users = users;
	}

	public ArrayList<Account> getAccounts() {
		return accounts;
	}

	public void setAccounts(ArrayList<Account> accounts) {
		this.accounts = accounts;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((accounts == null) ? 0 : accounts.hashCode());
		result = prime * result + ((users == null) ? 0 : users.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Bank other = (Bank) obj;
		if (accounts == null) {
			if (other.accounts != null)
				return false;
		} else if (!accounts.equals(other.accounts))
			return false;
		if (users == null) {
			if (other.users != null)
				return false;
		} else if (!users.equals(other.users))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Bank [users=" + users + ", accounts=" + accounts + "]";
	}
	
	public static boolean transfer(int accountId, double amount, String toUsername, String fromUsername) {
		AccountDaoImpl adi = new AccountDaoImpl();
		TransactionDaoImpl tdi = new TransactionDaoImpl();
		Account account = adi.getAccount(toUsername);
		if(account != null) {
			if(account.withdraw(accountId, amount, fromUsername)) {
				account.deposit(account.getAccountId(), amount, toUsername);
				tdi.createTransaction("transfer", amount, fromUsername);
				return true;
			}
		}
		return false;
	}
}
