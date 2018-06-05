package com.revature.pojos;

import com.revature.dao.AccountDaoImpl;
import com.revature.dao.TransactionDaoImpl;

public class Account {
	private double balance;
	private String username;
	private int accountId;
	
	public Account() {
		super();
	}
	
	public Account(String username) {
		super();
		this.username = username;
	}

	public Account(double balance, String username, int accountId) {
		super();
		this.balance = balance;
		this.username = username;
		this.accountId = accountId;
	}

	public double getBalance() {
		return balance;
	}

	public void setBalance(double balance) {
		this.balance = balance;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public int getAccountId() {
		return accountId;
	}

	public void setAccountId(int accountId) {
		this.accountId = accountId;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + accountId;
		long temp;
		temp = Double.doubleToLongBits(balance);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		result = prime * result + ((username == null) ? 0 : username.hashCode());
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
		Account other = (Account) obj;
		if (accountId != other.accountId)
			return false;
		if (Double.doubleToLongBits(balance) != Double.doubleToLongBits(other.balance))
			return false;
		if (username == null) {
			if (other.username != null)
				return false;
		} else if (!username.equals(other.username))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Account [balance=" + balance + ", username=" + username + ", accountId=" + accountId + "]";
	}
	
	public boolean deposit(int accountId, double amount, String username) {
		TransactionDaoImpl tdi = new TransactionDaoImpl();
		AccountDaoImpl adi = new AccountDaoImpl();
		
		double balance = adi.getBalance(accountId);
		balance += amount;
		
		if(adi.updateBalance(accountId, balance, username)) {
			tdi.createTransaction("deposit", amount, username);
			return true;
		}
		return false;
	}
	
	public boolean withdraw(int accountId, double amount, String username) {
		AccountDaoImpl adi = new AccountDaoImpl();
		TransactionDaoImpl tdi = new TransactionDaoImpl();

		double balance = adi.getBalance(accountId);
		balance -= amount;
		
		if(adi.updateBalance(accountId, balance, username)) {
			tdi.createTransaction("withdraw", amount, username);
			return true;
		}
		return false;
	}
}
