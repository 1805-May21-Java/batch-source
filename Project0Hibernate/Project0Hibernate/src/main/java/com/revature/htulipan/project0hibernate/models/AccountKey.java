package com.revature.htulipan.project0hibernate.models;

import java.io.Serializable;

public class AccountKey implements Serializable {
	
	private static final long serialVersionUID = 1L;
	
	protected String accountName;
	protected BankUser owner;

	public AccountKey() {
		super();
	}

	public AccountKey(String accountName, BankUser owner) {
		super();
		this.accountName = accountName;
		this.owner = owner;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((accountName == null) ? 0 : accountName.hashCode());
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
		AccountKey other = (AccountKey) obj;
		if (accountName == null) {
			if (other.accountName != null)
				return false;
		} else if (!accountName.equals(other.accountName))
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
		return "AccountKey [accountName=" + accountName + ", owner=" + owner + "]";
	}
	
}
