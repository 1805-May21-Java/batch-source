package com.revature.banking.dao;

import com.revature.banking.pojos.BankAccount;

public interface BankAccountDao {
	
	public boolean withdraw(BankAccount ba, double amount);
	
	public boolean depsoit(BankAccount ba, double amount);

}
