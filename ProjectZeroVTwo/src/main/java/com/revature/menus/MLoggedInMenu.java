package com.revature.menus;

import java.text.*;
import java.util.*;

import com.revature.dao.*;
import com.revature.pojos.*;

public class MLoggedInMenu extends MMenu
{
	NumberFormat formatter = new DecimalFormat("#0.00");
	
	public MLoggedInMenu()
	{
		super();
	}

	public MLoggedInMenu(MultiAccountDaoImpl madi, UserDaoImpl udi, MultiAccount currentAccount, User currentUser)
	{
		super(madi, udi, currentAccount, currentUser);
		options.add("1. View Balance");
		options.add("2. Make a deposit");
		options.add("3. Make a withdrawl");
		options.add("4. Switch account");
		options.add("5. Log off");
		options.add("6. Exit");
	}

	@Override
	public boolean continueRunning()
	{
		return (currentUser != null) && (currentAccount != null);
	}

	@Override
	public void takeAction(int choice)
	{
		switch(choice)
		{
		case 1:
			displayBalance();
			break;
		case 2:
			deposit();
			break;
		case 3:
			withdraw();
			break;
		case 4:
			currentAccount = null;
			break;
		case 5:
			currentUser = null;
			break;
		case 6:
			System.exit(0);
		}
	}

	private void displayBalance()
	{
		String name = currentUser.getUsername();
		String type = currentAccount.getAccountType();
		String output = name + "'s " + type + " account has a balance of: $" + formatter.format(madi.getAccountBalance(type, name));
		
		System.out.println(output);
	}

	private void deposit()
	{
		String username = currentAccount.getUsername();
		String type = currentAccount.getAccountType();
		Scanner sc = new Scanner(System.in);
		System.out.print("Enter an amount to deposit: ");
		try
		{
			double value = sc.nextDouble();
			
			while(value < 0)
			{
				System.out.println("Cannot deposit a negative amount.");
				System.out.print("Reenter the amount to deposit: ");
				value = sc.nextDouble();
			}
			
			madi.changeBalance(type, username, value);
		}
		catch(InputMismatchException e)
		{
			System.out.println("Invalid entry.  Please enter a number");
			deposit();
		}
		System.out.println("New balance: $" + formatter.format(madi.getAccountBalance(type, username)));
	}

	private void withdraw()
	{
		String username = currentAccount.getUsername();
		String type = currentAccount.getAccountType();
		Scanner sc = new Scanner(System.in);
		System.out.print("Enter an amount to withdraw: ");
		try
		{
			double value = sc.nextDouble();
			
			while(value < 0)
			{
				System.out.println("Cannot withdraw a negative amount.");
				System.out.print("Reenter the amount to withdraw: ");
				value = sc.nextDouble();
			}
			
			madi.changeBalance(type, username, -1 * value);
		}
		catch(InputMismatchException e)
		{
			System.out.println("Invalid entry.  Please enter a number");
			deposit();
		}
		System.out.println("New balance: $" + formatter.format(madi.getAccountBalance(type, username)));
	}

	@Override
	public MMenu transitionsTo()
	{
		if(currentUser == null)
		{
			return new MLogInMenu(madi, udi);
		}
		return new AccountSelectMenu(madi, udi, currentUser);
	}

}
