package com.revature.models;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table
public class BankAccount {
	@Id
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="accountSequence")
	@SequenceGenerator(allocationSize=1, name="accountSequence", sequenceName="SQ_ACCOUNT_PK")
	@Column(name="ACCOUNT_ID")
	int id;
	
	@Column(name="BALANCE", columnDefinition="NUMBER(20,2)")
	double balance;
	
	@ManyToOne
	@JoinColumn(name="BANK_USERNAME")
	BankUser user;
	
	public BankAccount() {
		super();
	}
	
	public BankAccount(double balance, BankUser user) {
		super();
		this.balance = balance;
		this.user = user;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public double getBalance() {
		return balance;
	}

	public void setBalance(double balance) {
		this.balance = balance;
	}

	public BankUser getUser() {
		return user;
	}

	public void setUser(BankUser user) {
		this.user = user;
	}
}
