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
		options.add("4. Transfer funds");
		options.add("5. Switch account");
		options.add("6. Log off");
		options.add("7. Exit");
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
			transfer();
			break;
		case 5:
			currentAccount = null;
			break;
		case 6:
			currentUser = null;
			break;
		case 7:
			System.exit(0);
		}
	}

	private void transfer()
	{
		Scanner sc = new Scanner(System.in);
		System.out.print("Enter the username for the account to transfer to: ");
		String toName = sc.nextLine();
		
		while(!udi.hasAccounts(toName))
		{
			System.out.println("No such user found.");
			System.out.print("Please reenter username: ");
			toName = sc.nextLine();
		}
		
		if(!udi.hasAccounts(toName))
		{
			System.out.println("The selected user has no accounts to transfer to.");
		}
		
		System.out.print("Enter the account type to transfer to: ");
		String toAccount = sc.nextLine();
		
		while(!madi.accountTypeExists(toAccount, toName))
		{
			System.out.println(toName + " has no account of type " + toAccount);
			System.out.print("Please reenter account type: ");
			toAccount = sc.nextLine();
		}
		
		double value = getTransferValue();
		
		//Decrement the current account balance by value
		madi.changeBalance(currentAccount.getAccountType(), currentUser.getUsername(), -1 * value);
		madi.changeBalance(toAccount, toName, value);
		currentAccount.setBalance(currentAccount.getBalance() - value);
		System.out.println("Successfully transfered $ " + formatter.format(value) + " into " + toName + "'s " + toAccount + " account.");
	}

	private double getTransferValue()
	{
		Scanner sc = new Scanner(System.in);
		double value;
		System.out.print("Please enter an amount to transfer: ");
		try
		{
			value = sc.nextDouble();
			
			if(value < 0)
			{
				System.out.println("Cannot transfer a negative amount.");
				value = getTransferValue();
			}
			else if(value > madi.getAccountBalance(currentAccount.getAccountType(), currentUser.getUsername()))
			{
				System.out.println("Cannot transfer more than the current balance.");
				value = getTransferValue();
			}
		}
		catch(InputMismatchException e)
		{
			System.out.println("Invalid entry.  Please enter a number.");
			value = getTransferValue();
		}
		
		return value;
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
			currentAccount.setBalance(currentAccount.getBalance() + value);
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
			currentAccount.setBalance(currentAccount.getBalance() - value);
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
