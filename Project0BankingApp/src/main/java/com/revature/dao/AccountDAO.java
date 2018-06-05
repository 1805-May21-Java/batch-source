package com.revature.dao;

import java.util.ArrayList;

import com.revature.model.Account;
import com.revature.model.UserAccount;

public interface AccountDAO {

	public ArrayList<Account> getAccountsByUserId(UserAccount user);
	public void addAccount(Account account);
	public double balanceInquiry(int id);
	public void updateBalance(int accountid, double balance);
	
	
}
