package com.revature.dao;
//Contains the constants for the bank account database
public final class BankContract {

	//Bank Account table
	public static final String ACCOUNT_TABLE_NAME = "BANK_BANK_ACCOUNT";
	public static final String ACCOUNT_ID = "BANK_ID";
	public static final String BALANCE = "BALANCE";
	public static final String ACCOUNT_NAME = "BANK_NAME";
	
	//Client accounts table
	public static final String CLIENT_TABLE_NAME = "BANK_CLIENT";
	public static final String USERNAME = "USERNAME";
	public static final String PASSWORD = "PASS";
	public static final String EMAIL = "EMAIL";
	
	//Bank-Client linking account
	public static final String CLIENT_BANK_TABLE_NAME = "BANK_CLIENT_ACCOUNT";
	public static final String LINKING_BANK_ID = "BANK_ID";
	public static final String LINKING_USERNAME = "USERNAME";
	
	//Log table
	public static final String LOG_TABLE_NAME = "BANK_LOG";
    public static final String LOG_BANK_ID = "BANK_ID";
    public static final String LOG_USERNAME = "USERNAME";
    public static final String LOG_MESSAGE = "LOG_MESSAGE";
    public static final String LOG_DATE = "LOG_DATE";
    
    //the same but for annotations
    public static final String ANNOTATIONS_BANK_TABLE_NAME = "ANNOTATIONS_ACCOUNT";
    public static final String ANNOTATIONS_CLIENT_TABLE_NAME = "ANNOTATIONS_CLIENT";
    public static final String ANNOTATIONS_TRANSACTION_TABLE_NAME = "ANNOTATIONS_TRANSACTIONS";
    public static final String ANNOTATIONS_CLIENT_ACCOUNT_TABLE_NAME = "ANNOTATIONS_CLIENT_ACCOUNT";
    public static final String ANNOTATIONS_BANK_ID = "ACCOUNT_ID";
    public static final String ANNOTATIONS_CLIENT_USERNAME ="ACCOUNT_CLIENT_USERNAME";
    public static final String ANNOTATIONS_TRANACTION_ID = "ANNOTATIONS_TRANSACTION_ID";
   
}