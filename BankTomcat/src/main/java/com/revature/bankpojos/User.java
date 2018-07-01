package com.revature.bankpojos;

public class User
{
	private String userId;
	private String userName;
	private String password;
	private Double balance;
	
	public String getUserId() {
		return userId;
	}
	public void setUserId(String userId) {
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
	public User(String userId, String userName, String password) {
		this.userId = userId;
		this.userName = userName;
		this.password = password;
	}
	public User(String userId, String userName, String password, Double balance) {
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