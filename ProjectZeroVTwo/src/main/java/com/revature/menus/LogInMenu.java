package com.revature.menus;

import java.util.*;

import com.revature.dao.AccountDaoImpl;
import com.revature.pojos.Account;

public class LogInMenu extends Menu
{
	
	public LogInMenu()
	{
		super();
	}

	public LogInMenu(AccountDaoImpl adi)
	{
		super(adi, null);
		options.add("1. Create new account");
		options.add("2. Log in");
		options.add("3. Exit");
	}

	@Override
	public void takeAction(int choice)
	{
		if(choice == 1)
		{
			createNewUser();
		}
		else if(choice == 2)
		{
			logIn();
		}
		else
		{
			System.exit(0);
		}
	}

	private void logIn()
	{
		Scanner sc = new Scanner(System.in);
		//Prompt the user for the username
		System.out.print("Enter your username: ");
		String name = sc.nextLine();
		//If the username doesn't exist in the table
		if(adi.isValidUsername(name))
		{
			System.out.println("There is no account with that username.");
			logIn();
		}
		
		//If there is a password for the account, prompt the user for the password
		if(adi.hasPassword(name))
		{
			System.out.print("Enter the password for the account: ");
			String password = sc.nextLine();
			while(adi.logIn(name, password) == null)
			{
				System.out.println("Incorrect password.");
				System.out.print("Reenter password: ");
				password = sc.nextLine();
			}
			currentAccount = adi.logIn(name, password);
		}
		else
		{
			currentAccount = adi.logIn(name);
		}
	}

	private void createNewUser()
	{
		Scanner sc = new Scanner(System.in);
		System.out.print("Enter a username: ");
		String name = sc.nextLine();
		while(!adi.isValidUsername(name))
		{
			System.out.print("Username already exists or is empty.  Please enter another: ");
			name = sc.nextLine();
		}
		
		adi.createAccount(name);
	}

	
	@Override
	public boolean continueRunning()
	{
		return currentAccount == null;
	}

	@Override
	public Menu transitionsTo()
	{
		return new LoggedInMenu(adi, currentAccount);
	}
}
