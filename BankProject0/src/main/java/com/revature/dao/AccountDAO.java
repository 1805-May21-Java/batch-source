package com.revature.dao;
//**********************************************************************************
//MAKE SURE BEFORE RUNNING THE DRIVER TO CREATE THE FOLLOWING TABLE EXACTLY AS IT IS
//**********************************************************************************
/*
CREATE TABLE ACCOUNT (
USR VARCHAR2(25),
USERNAME VARCHAR2(25),
PWORD VARCHAR2(16),
BALANCE FLOAT(8)
)
 */
//since USERNAME is going to be unique, it is our primary key although it isn't specified here
//if you wish, you can DROP TABLE ACCOUNT if you want to start fresh
import java.util.List;

import com.revature.pojos.Account;
//REALLY GLAD I GOT AN INTERFACE WORKING NOW
public interface AccountDAO {
	public List<Account> listAllAccounts(); //list all accounts, used with finding unique usernames
	public Account getAccountById(String username); //get an account by username parameter, also used with finding unique usernames
	public int createAccount(Account acct); //create an account
	public int updateAccount(Account acct); //update an account (save balance for when user logs in later
	public int deleteAccount(String username); //delete an account
}