package com.revature.banking.dao;

public interface BankAccountDao {
	
	public boolean withdraw(double amount);
	
	public boolean depsoit(double amount);

}
