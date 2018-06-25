package com.revature.banking.dao;

import java.util.ArrayList;

import com.revature.banking.pojos.BankAccount;

public interface AccountDao {
	
	public ArrayList<BankAccount> accessBankAccounts(int user_id);

}
