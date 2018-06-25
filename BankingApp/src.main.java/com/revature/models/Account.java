package com.revature.models;

import javax.persistence.*;

@Entity
@Table
public class Account {
	
	@Id
	@Column(name="ACC_ID")
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="IdSequence")
	@SequenceGenerator(allocationSize=1, name="IdSequence", sequenceName="SQ_ACCOUNTS_PK")
	private int id;
	
	@Column(name="ACC_USERNAME", columnDefinition="VARCHAR(25)")
	private String username;
	
	@Column(name="ACC_PASSWORD", columnDefinition="VARCHAR(25)")
	private String password;
	
	@Column
	private double balance; // new account balance always starts at zero

	public Account(int id, String username, String password, double balance) {
		super();
		this.id = id;
		this.username = username;
		this.password = password;
		this.balance = balance;
	}
	
	public Account(String username, String password, Double balance) {
		super();
		this.username = username;
		this.password = password;
		this.balance = balance;
	}
	
	public int getId() {
		return id;
	}
	
	public void setId (int id) {
		this.id = id;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public double getBalance() {
		return balance;
	}

	public void setBalance(double balance) {
		this.balance = balance;
	}

	@Override
	public String toString() {
		return "Account [id=" + id + ", username=" + username + ", password=" + password + ", balance=" + balance + "]";
	}
	
	
}
