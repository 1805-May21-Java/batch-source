package com.revature.bank;

/*
 * Storage and access of user information is all done within the DAO package
 * 
 * This class is just meant to store the currently used User info
 */

public class BankInfo {	
	private User user;
		
	public BankInfo() {
		super();
	}

	public BankInfo(User user) {
		super();
		this.user = user;
	}
	
	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}
}
