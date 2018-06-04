package com.revature.MockBank2;

public interface Command {
	
	//interface for implementation
	public void signup();
	public void login();
	public double deposit();
	public double withdraw();
	public void logout();
	
}

