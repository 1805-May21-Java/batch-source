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
public class BankTransaction {
	@Id
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="transactionSequence")
	@SequenceGenerator(allocationSize=1, name="transactionSequence", sequenceName="SQ_TRANSACTION_PK")
	@Column(name="TRANSACTION_ID")
	int id;
	
	@Column(name="TRANSACTION_TYPE ", columnDefinition="VARCHAR2(25)" )
	String type;
	
	@Column(name="AMOUNT", columnDefinition="NUMBER(20,2)" )
	double amount;
	
	@ManyToOne
	@JoinColumn(name="BANK_USERNAME")
	BankUser user;
	
	public BankTransaction() {
		super();
	}
	
	public BankTransaction(String type, double amount, BankUser user) {
		super();
		this.type = type;
		this.amount = amount;
		this.user = user;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public double getAmount() {
		return amount;
	}

	public void setAmount(double amount) {
		this.amount = amount;
	}

	public BankUser getUser() {
		return user;
	}

	public void setUser(BankUser user) {
		this.user = user;
	}

	@Override
	public String toString() {
		return "BankTransaction [id=" + id + ", type=" + type + ", amount=" + amount + "]";
	}
	
}
