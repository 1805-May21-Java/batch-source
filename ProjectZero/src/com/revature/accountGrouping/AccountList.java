package com.revature.accountGrouping;

import java.io.Serializable;
import java.util.*;

import com.revature.errors.*;

public class AccountList implements Serializable
{
	private static final long serialVersionUID = 2948469512624171335L;

	private HashMap<LogInCredential, Account> accounts = new HashMap<LogInCredential, Account>();

	public AccountList()
	{
		super();
	}
	
	@Override
	public int hashCode()
	{
		final int prime = 31;
		int result = 1;
		result = prime * result + ((accounts == null) ? 0 : accounts.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj)
	{
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		AccountList other = (AccountList) obj;
		if (accounts == null)
		{
			if (other.accounts != null)
				return false;
		}
		else if (!accounts.equals(other.accounts))
			return false;
		return true;
	}
	
	public void createAccount(String userName, String name, String password)
	{
		LogInCredential credentials = new LogInCredential(userName, password);
		accounts.put(credentials, new Account(name));
	}
	
	public Account logOn(String userName, String password) throws InvalidLoginException
	{
		LogInCredential creds = new LogInCredential(userName, password);
		
		Set credentials = accounts.keySet();
		for(Object credential : credentials)
		{
			LogInCredential cred = (LogInCredential)credential;
			if(cred.isValidMatch(userName, password))
			{
				return accounts.get(creds);
			}
		}
		
		throw new InvalidLoginException();
	}
	
	public boolean accountExists(String username)
	{
		Set credentials = accounts.keySet();
		for(Object credential : credentials)
		{
			LogInCredential cred = (LogInCredential)credential;
			if(username.equals(cred.getUserName()))
			{
				return true;
			}
		}
		return false;
	}
	
	public HashMap<LogInCredential, Account> getAccounts()
	{
		return accounts;
	}
}
