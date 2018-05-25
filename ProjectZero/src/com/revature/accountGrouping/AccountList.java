package com.revature.accountGrouping;

import java.io.Serializable;
import java.util.*;

import com.revature.errors.*;

public class AccountList implements Serializable
{
	private static final long serialVersionUID = 2948469512624171335L;

	private ArrayList<Account> accounts = new ArrayList<Account>();

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
	
	public void createAccount(String userName) throws DuplicateUserNameException
	{
		for(Account account : accounts)
		{
			//Making sure the provided user name is unique
			if(account.getUserName().equals(userName))
			{
				throw new DuplicateUserNameException("An account already has this username.  Please select another.");
			}
		}
		accounts.add(new Account(userName));
	}
	
	public Account logOn(String userName) throws NoSuchUserException
	{
		for(Account account : accounts)
		{
			if(userName.equals(account.getUserName()))
			{
				return account;
			}
		}
		
		throw new NoSuchUserException("User " + userName + " does not exist.  Try again or create a new account.");
	}
}
