package com.revature.revaturebankingapp;

import java.util.ArrayList;
import java.util.List;

public interface AccountDAO {

	public void updateBalance(int accountid, double balance);
	public double balanceInquiry(int id);
	public ArrayList<Account> getAccountsByUserId(int id);
	public void addAccount(Account account);
}
