package com.revature.htulipan.banking2.database.pojos;

import java.util.List;

public class Account {
	private String accountName;
	private float balance;
	private String owner;
	
	public Account() {
		super();
		this.balance = 0.0f;
	}

	public Account(String accountName, float balance, String owner) {
		super();
		this.accountName = accountName;
		this.balance = balance;
		this.owner = owner;
	}

	public String getAccountName() {
		return accountName;
	}

	public void setAccountName(String accountName) {
		this.accountName = accountName;
	}

	public float getBalance() {
		return balance;
	}

	public void setBalance(float balance) {
		this.balance = balance;
	}

	public String getOwner() {
		return owner;
	}

	public void setOwner(String owner) {
		this.owner = owner;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((accountName == null) ? 0 : accountName.hashCode());
		result = prime * result + Float.floatToIntBits(balance);
		result = prime * result + ((owner == null) ? 0 : owner.hashCode());
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
		if (accountName == null) {
			if (other.accountName != null)
				return false;
		} else if (!accountName.equals(other.accountName))
			return false;
		if (Float.floatToIntBits(balance) != Float.floatToIntBits(other.balance))
			return false;
		if (owner == null) {
			if (other.owner != null)
				return false;
		} else if (!owner.equals(other.owner))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Account [accountName=" + accountName + ", balance=" + balance + ", owner=" + owner + "]";
	}
	
}
