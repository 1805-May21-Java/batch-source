package com.Revature.Dao;

import java.util.List;

import com.Revature.pojos.BankAccount;
import com.Revature.pojos.UserProfile;

public interface ProfileAccountDao {
	// Returns all account numbers for a given username
	public List<Integer> getAllAccountNumbers(String username) throws Exception;

	// Returns all usernames tied to a given account
	public List<String> getAllUsernames(int id) throws Exception;

	// returns list of bank accounts tied to a username
	public List<BankAccount> getAllAccounts(String username) throws Exception;

	// Returns list of user profiles tied to a bank account
	public List<UserProfile> getAllUserProfiles(int id) throws Exception;

}
