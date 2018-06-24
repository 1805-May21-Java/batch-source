package com.revature.bank;

import java.util.Date;

import javax.persistence.*;

import com.revature.dao.TransactionDaoImpl;

@Entity
@Table
public class Account {
	/**
	 * 
	 */
	@Transient
	private static TransactionDaoImpl tdi = new TransactionDaoImpl();
	
	@Column(name="Acct_Owner")
	private String owner;

	@Id
	@Column(name="Username")
	private String username;

	@Column(name="Acct_Password")
	private String password;

	@Column(name="Balance")
	private float balance;


	public Account() {
		super();
	}
	public Account(String owner, String username,String password, float balance) {
		super();
		this.owner = owner;
		this.username = username;
		this.password = password;
		this.balance = balance;
	}
	@Override
	public String toString() {
		return "Account [owner=" + owner + ", username=" + username + ", password=" + password
				+ ", balance=" + balance + "]";
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getOwner() {
		return owner;
	}
	public void setOwner(String owner) {
		this.owner = owner;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public float getBalance() {
		return balance;
	}
	public void setBalance(float balance) {
		this.balance = balance;
	}


	public int withdraw(float amount) {

		if(balance<amount) {
			return -1;
		}
		balance-=amount;
		System.out.printf("You have $%.2f remaining.\n",balance);
		Transaction transaction = new Transaction();
		transaction.setAcctName(username);
		transaction.setAction("Withdrawal");
		transaction.setAmount(amount);
		transaction.setDate(new Date().toString());
		tdi.addTransaction(transaction);
		return 1;
	}

	public int deposit(float amount) {
		System.out.println(amount+" depositing this much.");

		if(amount<=0) return -1;
		balance+=amount;
		System.out.printf("Your balance is now: $%.2f\n",balance);
		Transaction transaction = new Transaction();
		transaction.setAcctName(username);
		transaction.setAction("Deposit");
		transaction.setAmount(amount);
		transaction.setDate(new Date().toString());
		tdi.addTransaction(transaction);
		return 1;
	}

}
