package com.revature.revaturebankingapp;

import java.util.ArrayList;
import java.util.List;

public interface AccountDAO {

	public void updateBalance(int accountid, double balance);
	public double balanceInquiry(int id);
	public ArrayList<Account> getAccountsByUserId(User user);
	public void addAccount(Account account);
}
