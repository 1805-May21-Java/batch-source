package com.revature.banking.dao;

public interface AccessDao {
	
	public AccountImpl signUp(String user, String pass);
	
	public AccountImpl logIn(String user, String pass);

}
