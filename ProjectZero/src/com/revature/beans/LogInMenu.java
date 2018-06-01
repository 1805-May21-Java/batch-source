package com.revature.beans;

import java.util.*;

import com.revature.accountGrouping.*;
import com.revature.errors.InvalidLoginException;

public class LogInMenu extends MenuSuper
{
	AccountList accounts;
	
	public LogInMenu()
	{
		super();
	}

	public LogInMenu(AccountList accounts)
	{
		super();
		this.accounts = accounts;
		this.options.add("1. Create an account");
		//Only allow them to log in if there is an existing account
		if(accounts != null)
		{
			this.options.add("2. Log in");
			this.options.add("3. Exit");
		}
		else
		{
			this.options.add("2. Exit");
		}
	}

	public AccountList run()
	{
		printMenu();
		int choice = getChoice();
		
		if(choice == 1)
		{
			createAccount();
		}
		else if(options.size() == 2)
		{
			System.exit(0);
		}
		else
		{
			if(choice == 2)
			{
				logOn();
			}
			else
			{
				System.exit(0);
			}
		}
		return accounts;
	}
	
	private void logOn()
	{
		Scanner sc = new Scanner(System.in);
		System.out.print("Enter the username or email associated with the account: ");
		String username = sc.nextLine();
		
		while(!accounts.accountExists(username))
		{
			System.out.print("Invalid username.  Please reenter: ");
			username = sc.nextLine();
		}
		
		System.out.print("Enter the password: ");
		String password = sc.nextLine();
		
		Account relevantAccount = null;
		while(relevantAccount == null)
		{
			try
			{
				relevantAccount = accounts.logOn(username, password);
			}
			catch (InvalidLoginException e)
			{
				System.out.print("Incorrect password.  Please reenter: ");
				password = sc.nextLine();
			}
		}
		
		currentAccount = relevantAccount;

	}

	private void createAccount()
	{
		Scanner sc = new Scanner(System.in);
		
		System.out.print("Enter a username: ");
		String username = sc.nextLine();
		
		while(accounts.accountExists(username))
		{
			System.out.print("Username already exists.  Please enter another: ");
			username = sc.nextLine();
		}
		
		System.out.print("Enter your name: ");
		String name = sc.nextLine();
		
		System.out.print("Enter your password: ");
		String password = sc.nextLine();
		
		accounts.createAccount(username, name, password);
		
	}
}
