package com.revature.htulipan.project0hibernate.models;

import java.io.Serializable;

import javax.persistence.*;

@Entity
@IdClass(AccountKey.class)
@Table
public class BankAccount implements Serializable {
	
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="ACCOUNTNAME", columnDefinition="VARCHAR2(30)", nullable=false)
	private String accountName;
	
	@Id
	@ManyToOne
	@JoinColumn(name="OWNER", nullable=false)
	private BankUser owner;
	
	@Column(name="BALANCE", columnDefinition="NUMBER", nullable=false)
	private float balance;

	public BankAccount() {
		super();
	}

	public BankAccount(String accountName, BankUser owner, float balance) {
		super();
		this.accountName = accountName;
		this.owner = owner;
		this.balance = balance;
	}

	public String getAccountName() {
		return accountName;
	}

	public void setAccountName(String accountName) {
		this.accountName = accountName;
	}

	public BankUser getOwner() {
		return owner;
	}

	public void setOwner(BankUser owner) {
		this.owner = owner;
	}

	public float getBalance() {
		return balance;
	}

	public void setBalance(float balance) {
		this.balance = balance;
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
		BankAccount other = (BankAccount) obj;
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
		return "Account [accountName=" + accountName + ", owner=" + owner.getUsername() + ", balance=" + balance + "]";
	}

}