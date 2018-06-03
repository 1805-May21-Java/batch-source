package com.revature.menus;

import java.util.Scanner;

import com.revature.dao.MultiAccountDaoImpl;
import com.revature.dao.UserDaoImpl;
import com.revature.pojos.User;

public class AccountCreationMenu extends MMenu
{
	
	public AccountCreationMenu()
	{
		super();
	}

	public AccountCreationMenu(MultiAccountDaoImpl madi, UserDaoImpl udi, User currentUser)
	{
		super(madi, udi, currentUser);
		options.add("1. Create a new account");
		options.add("2. Change password");
		options.add("3. Log off");
		options.add("4. Exit");
	}

	@Override
	public boolean continueRunning()
	{
		return (currentUser != null) && (!udi.hasAccounts(currentUser.getUsername()));
	}

	@Override
	public void takeAction(int choice)
	{
		switch(choice)
		{
		case 1:
			createAccount();
			break;
		case 2:
			changePassword();
			break;
		case 3:
			currentUser = null;
			break;
		case 4:
			System.exit(0);
		}
	}

	private void changePassword()
	{
		Scanner sc = new Scanner(System.in);
		System.out.print("Enter the new password: ");
		String password = sc.nextLine();
		udi.changePassword(password, currentUser.getUsername());
	}

	private void createAccount()
	{
		Scanner sc = new Scanner(System.in);
		System.out.print("Enter the type of the new account: ");
		String type = sc.nextLine();
		while(!madi.isValidType(type, currentUser.getUsername()))
		{
			System.out.println("An account of this type already exists.  Please choose another.");
			createAccount();
		}
		madi.createAccount(type, currentUser.getUsername());
	}

	@Override
	public MMenu transitionsTo()
	{
		if(currentUser == null)
			return new MLogInMenu(madi, udi);
		return new AccountSelectMenu(madi, udi, currentUser);
	}

}
