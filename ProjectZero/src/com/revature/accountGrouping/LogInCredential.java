package com.revature.accountGrouping;

import java.io.*;

public class LogInCredential implements Serializable
{
	private static final long serialVersionUID = -4401124309906594451L;
	private String userName;
	private String password;

	public LogInCredential()
	{
		super();
	}

	public LogInCredential(String userName, String password)
	{
		super();
		this.userName = userName;
		this.password = password;
	}
	
	public String getUserName()
	{
		return userName;
	}
	
	public boolean isValidMatch(String userName, String password)
	{
		return this.userName.equals(userName) && this.password.equals(password);
	}

	@Override
	public int hashCode()
	{
		final int prime = 31;
		int result = 1;
		result = prime * result + ((password == null) ? 0 : password.hashCode());
		result = prime * result + ((userName == null) ? 0 : userName.hashCode());
		return result;
	}

	//Because we need a unique username, if the username is the same, I consider the accounts to be equal
	//I use the isValidMatch to test whether a log in credential is valid
	@Override
	public boolean equals(Object obj)
	{
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		LogInCredential other = (LogInCredential) obj;
		if (userName == null)
		{
			if (other.userName != null)
				return false;
		}
		else if (!userName.equals(other.userName))
			return false;
		return true;
	}

	@Override
	public String toString()
	{
		return "LogInCredential [userName=" + userName + ", password=" + password + "]";
	}
}
