package com.revature.bank;

public interface Command {
	
	//interface for implementation
	public void signup();
	public void login();
	public int deposit();
	public int withdraw();
	public void logout();
	
}
