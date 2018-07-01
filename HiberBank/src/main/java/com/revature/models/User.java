package com.revature.models;

import javax.persistence.*;
@Entity
@Table
public class User {

	int userId;
	String userName;
	String password;
	Double balance;
	

	public int getUserId() {
		return userId;
	}

	public void setUserId(int userId) {
		this.userId = userId;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public Double getBalance() {
		return balance;
	}

	public void setBalance(Double balance) {
		this.balance = balance;
	}
	
	public User(int userId, String userName, String password) {
		this.userId = userId;
		this.userName = userName;
		this.password = password;
	}
	
	public User(int userId, String userName, String password, Double balance) {
		super();
		this.userId = userId;
		this.userName = userName;
		this.password = password;
		this.balance = balance;
	}
	
	@Override
	public String toString() {
		return "User [userId=" + userId + ", userName=" + userName + ", password=" + password + ", balance=" + balance
				+ "]";
	}
	
}
