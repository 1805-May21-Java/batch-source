package com.revature.menus;

import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.util.*;

import com.revature.dao.AccountDaoImpl;
import com.revature.pojos.Account;

public class LoggedInMenu extends Menu
{	
	NumberFormat formatter = new DecimalFormat("#0.00");

	
	public LoggedInMenu()
	{
		super();
	}

	public LoggedInMenu(AccountDaoImpl adi, Account currentAccount)
	{
		super(adi, currentAccount);
		options.add("1. Change password");
		options.add("2. View balance");
		options.add("3. Make a deposit");
		options.add("4. Make a withdrawl");
		options.add("5. Log out");
		options.add("6. Exit");
	}

	@Override
	public boolean continueRunning()
	{
		return currentAccount != null;
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
				System.out.println("Current balance: $" + formatter.format(adi.getBalance(currentAccount.getUsername())));
				break;
			case 3:
				deposit();
				break;
			case 4:
				withdraw();
				break;
			case 5:
				currentAccount = null;
				break;
			case 6:
				System.exit(0);
		}
	}

	private void withdraw()
	{
		String user = currentAccount.getUsername();
		double balance = adi.getBalance(user);
		Scanner sc = new Scanner(System.in);
		System.out.print("Enter an amount to withdraw: ");
		try
		{
			double value = sc.nextDouble();
			if(value < 0)
			{
				System.out.println("Cannot withdraw a negative amount.");
				withdraw();
			}
			else if(value > balance)
			{
				System.out.println("Cannot withdraw more than is in the account.");
				System.out.println("Current balance is $" + formatter.format(balance));
				withdraw();
			}
			else
			{
				adi.changeBalance(user, -1 * value);
				System.out.println("New balance is: $" + formatter.format(adi.getBalance(user)));
			}
		}
		catch(InputMismatchException e)
		{
			System.out.println("Invalid entry.  Please enter a number.");
		}
	}

	private void deposit()
	{
		Scanner sc = new Scanner(System.in);
		System.out.print("Enter amount to deposit: ");
		try
		{
			double deposit = sc.nextDouble();
			if(deposit < 0)
			{
				System.out.println("Cannot deposit a negative amount");
				deposit();
			}
			else
			{
				adi.changeBalance(currentAccount.getUsername(), deposit);
				System.out.println("New balance: $" + formatter.format(adi.getBalance(currentAccount.getUsername())));
			}
		}
		catch(InputMismatchException e)
		{
			System.out.println("Invalid entry.  Please enter a number.");
			deposit();
		}
	}

	private void changePassword()
	{
		Scanner sc = new Scanner(System.in);
		System.out.print("Enter new password: ");
		String password = sc.nextLine();
		adi.changePassword(currentAccount.getUsername(), password);
	}

	@Override
	public Menu transitionsTo()
	{
		return new LogInMenu(adi);
	}

}
