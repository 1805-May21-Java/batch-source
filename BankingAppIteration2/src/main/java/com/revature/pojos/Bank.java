package com.revature.pojos;

import java.util.*;

import com.revature.dao.AccountDaoImpl;
import com.revature.dao.TransactionDaoImpl;
import com.revature.dao.UserDaoImpl;

public class Bank {
	private List<User> users;
	private List<Account> accounts;
	private List<Transaction> transactions;
	private static Bank myBank;
	private Bank() {
		super();
	}
	public List<User> getUsers() {
		return users;
	}
	public void setUsers(List<User> users) {
		this.users = users;
	}
	public List<Account> getAccounts() {
		return accounts;
	}
	public void setAccounts(List<Account> accounts) {
		this.accounts = accounts;
	}	
	public List<Transaction> getTransactions() {
		return transactions;
	}
	public void setTransactions(List<Transaction> transactions) {
		this.transactions = transactions;
	}
	@Override
	public String toString() {
		return "Bank [users=" + users + ", accounts=" + accounts + ", transactions=" + transactions + "]";
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((accounts == null) ? 0 : accounts.hashCode());
		result = prime * result + ((transactions == null) ? 0 : transactions.hashCode());
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
		if (transactions == null) {
			if (other.transactions != null)
				return false;
		} else if (!transactions.equals(other.transactions))
			return false;
		if (users == null) {
			if (other.users != null)
				return false;
		} else if (!users.equals(other.users))
			return false;
		return true;
	}
	/*
	 * 
	 * Along with bank being a POJO, it is also a singleton. These are the methods
	 * that allow this to be the case.
	 * 
	 */
	public static Bank getInstance() {
		if(myBank == null) {
			myBank = new Bank();
		}
		return myBank;
	}
	@Override
	public Object clone() throws CloneNotSupportedException {
		throw new CloneNotSupportedException();
	}
	
	public static Bank updateBankObject() {
		// since Bank is a singleton, the update will be the same through all references to it.
		myBank = Bank.getInstance();
		
		UserDaoImpl udi = new UserDaoImpl();
		AccountDaoImpl adi = new AccountDaoImpl();
		TransactionDaoImpl tdi = new TransactionDaoImpl();
		
		myBank.setUsers(udi.getUsers());
		myBank.setAccounts(adi.getAccounts());
		myBank.setTransactions(tdi.getTransactions());
		
		return myBank;
	}	
}
