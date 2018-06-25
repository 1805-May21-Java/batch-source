package com.revature.models;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.*;
@Entity
@Table(name="USER_TABLE")
public class User
{
	@Id
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="userSequence")
	@SequenceGenerator(allocationSize=1, name="userSequence", sequenceName="SEQ_USER_HIBER")
	@Column(name="USER_ID")
	private int userId;
	@Column(name="USER_NAME")
	private String userName;
	@Column(name="USER_PASSWORD")
	private String password;
	@Column(name="USER_BALANCE")
	private Double balance;
	



	public User(String userName, String password, Double balance) {
		super();
		this.userName = userName;
		this.password = password;
		this.balance = balance;
	}

	

















	public User() {
		super();
	}



















	public User(int userId, String userName, String password, Double balance) {
		super();
		this.userId = userId;
		this.userName = userName;
		this.password = password;
		this.balance = balance;
	}


















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









	@Override
	public String toString() {
		return "User [userId=" + userId + ", userName=" + userName + ", password=" + password + ", balance=" + balance
				+ "]";
	}











}
