package com.revature.menus;

import java.util.ArrayList;
import java.util.Scanner;

import com.revature.dao.AccountDaoImpl;
import com.revature.pojos.Account;

public class UserCreationMenu extends Menu
{

	public UserCreationMenu()
	{
		super();
	}

	public UserCreationMenu(AccountDaoImpl adi)
	{
		super(adi, null);
		options.add("1. Create a new user");
		options.add("2. Exit");
	}
	
	/**
	 * Only run this menu if there are no accounts in the table
	 */
	@Override
	public boolean continueRunning()
	{
		return !adi.accountsExist();
	}

	@Override
	public void takeAction(int choice)
	{
		if(choice == 1)
		{
			createNewUser();
		}
		else
		{
			System.exit(0);
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
	public Menu transitionsTo()
	{
		return new LogInMenu(adi);
	}
}
