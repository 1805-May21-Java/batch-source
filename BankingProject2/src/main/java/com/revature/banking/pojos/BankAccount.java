package com.revature.banking.pojos;

import javax.persistence.Column;
import javax.persistence.*;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;

import com.revature.banking.dao.BankAccountImpl;

@Entity
@Table(name="BANK_ACCOUNTS")
public class BankAccount extends BankAccountImpl{
	
	@Id
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="bankSequence")
	@SequenceGenerator(allocationSize=1, name="bankSequence", sequenceName="SQ_BANK_PK")
	@Column(name="ACC_NUM")
	private int acc_num;
	
	@Column
	private int user_id;
	
	@Column
	private String acc_type;
	
	@Column
	private double balance;
	
	public BankAccount() {
		super();
	}

	public BankAccount(int user_id, int acc_num, String acc_type, double balance) {
		super();
		this.user_id = user_id;
		this.acc_num = acc_num;
		this.acc_type = acc_type;
		this.balance = balance;
	}

	public int getAcc_num() {
		return acc_num;
	}

	public String getAcc_type() {
		return acc_type;
	}

	public double getBalance() {
		return balance;
	}
	
	public void minusBalance(double amount) {
		balance-=amount;
	}
	
	public void plusBlance(double amount) {
		balance+=amount;
	}

	public int getUser_id() {
		return user_id;
	}

	@Override
	public String toString() {
		return "BankAccount [user_id=" + user_id + ", acc_num=" + acc_num + ", acc_type="
				+ acc_type + ", balance=" + balance + "]";
	}
	
	
	
	
}
