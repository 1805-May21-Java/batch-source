package com.revature.menus;

import java.util.Scanner;

import com.revature.dao.MultiAccountDaoImpl;
import com.revature.dao.UserDaoImpl;
import com.revature.pojos.*;

public class MLogInMenu extends MMenu
{
	public MLogInMenu()
	{
		super();
	}

	public MLogInMenu(MultiAccountDaoImpl madi, UserDaoImpl udi)
	{
		super(madi, udi);
		options.add("1. Create new user");
		options.add("2. Log in");
		options.add("3. Exit");
	}

	@Override
	public boolean continueRunning()
	{
		return currentUser == null;
	}

	@Override
	public void takeAction(int choice)
	{
		switch(choice)
		{
		case 1:
			createUser();
			break;
		case 2:
			logIn();
			break;
		case 3:
			System.exit(0);
		}
	}

	private void createUser()
	{
		Scanner sc = new Scanner(System.in);
		System.out.print("Enter the username: ");
		String name = sc.nextLine();
		
		while(!udi.isValidName(name))
		{
			System.out.println("Username already exists.");
			createUser();
		}
		
		udi.createUser(name);
	}

	private void logIn()
	{
		Scanner sc = new Scanner(System.in);
		System.out.print("Enter the username: ");
		String name = sc.nextLine();
		
		while(!udi.nameExists(name))
		{
			System.out.println("Username not found.");
			logIn();
		}
		
		if(udi.hasPassword(name))
		{
			System.out.print("Enter the password: ");
			String password = sc.nextLine();
			while(udi.logIn(name, password) == null)
			{
				System.out.println("Incorrect password.");
				System.out.print("Reenter password: ");
				password = sc.nextLine();
			}
			
			currentUser = udi.logIn(name, password);
		}
		else
		{
			currentUser = udi.logIn(name);
		}
	}

	@Override
	public MMenu transitionsTo()
	{
		if(!udi.hasAccounts(currentUser.getUsername()))
		{
			return new AccountCreationMenu(madi, udi, currentUser);
		}
		return new AccountSelectMenu(madi, udi, currentUser);
	}

}
