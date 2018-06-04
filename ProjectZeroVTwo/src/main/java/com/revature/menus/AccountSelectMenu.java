package com.revature.menus;

import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.util.*;

import com.revature.dao.*;
import com.revature.pojos.*;

public class AccountSelectMenu extends MMenu
{
	NumberFormat formatter = new DecimalFormat("#0.00");

	public AccountSelectMenu()
	{
		super();
	}

	public AccountSelectMenu(MultiAccountDaoImpl madi, UserDaoImpl udi, User currentUser)
	{
		super(madi, udi, currentUser);
		options.add("1. Change password");
		options.add("2. Create account");
		options.add("3. Display accounts");
		options.add("4. Choose account");
		options.add("5. Log out");
		options.add("6. Exit");
	}

	@Override
	public boolean continueRunning()
	{
		return (currentUser != null) && (currentAccount == null);
	}

	@Override
	public void takeAction(int choice)
	{
		switch(choice)
		{
		case 1:
			changePassword();
			break;
		case 2:
			createAccount();
			break;
		case 3:
			displayAccounts();
			break;
		case 4:
			chooseAccount();
			break;
		case 5:
			currentUser = null;
			break;
		case 6:
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

	private void displayAccounts()
	{
		String name = currentUser.getUsername(); 
		List<MultiAccount> accounts = udi.getAccountsByUser(name);
		
		for(MultiAccount account : accounts)
		{
			System.out.println(name + "'s " + account);
		}
	}

	private void chooseAccount()
	{
		if(!madi.acctsExits(currentUser.getUsername()))
		{
			System.out.println("No accounts to select from.  Please make another choice.");
			return;
		}
		
		Scanner sc = new Scanner(System.in);
		System.out.print("Enter the account type: ");
		String type = sc.nextLine();
		while(!madi.accountTypeExists(type, currentUser.getUsername()))
		{
			System.out.println("No account of that type exists.  Make another selection.");
			chooseAccount();
		}
		currentAccount = madi.getAccountByType(type, currentUser.getUsername());
	}

	@Override
	public MMenu transitionsTo()
	{
		if(currentUser == null)
		{
			return new MLogInMenu(madi, udi);
		}
		return new MLoggedInMenu(madi, udi, currentAccount, currentUser);
	}

}
