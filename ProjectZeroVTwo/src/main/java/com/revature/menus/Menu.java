package com.revature.menus;

import java.util.*;

import com.revature.dao.AccountDaoImpl;
import com.revature.pojos.Account;

public abstract class Menu
{
	protected ArrayList<String> options;
	protected AccountDaoImpl adi = new AccountDaoImpl();
	protected Account currentAccount;
	
	
	
	public Menu()
	{
		super();
	}

	public Menu(AccountDaoImpl adi, Account currentAccount)
	{
		super();
		options = new ArrayList<String>();
		this.options = options;
		this.adi = adi;
		this.currentAccount = currentAccount;
	}

	public ArrayList<String> getOptions()
	{
		return options;
	}

	public void setOptions(ArrayList<String> options)
	{
		this.options = options;
	}

	public AccountDaoImpl getAdi()
	{
		return adi;
	}

	public void setAdi(AccountDaoImpl adi)
	{
		this.adi = adi;
	}

	public Account getCurrentAccount()
	{
		return currentAccount;
	}

	public void setCurrentAccount(Account currentAccount)
	{
		this.currentAccount = currentAccount;
	}

	@Override
	public int hashCode()
	{
		final int prime = 31;
		int result = 1;
		result = prime * result + ((adi == null) ? 0 : adi.hashCode());
		result = prime * result + ((currentAccount == null) ? 0 : currentAccount.hashCode());
		result = prime * result + ((options == null) ? 0 : options.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj)
	{
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Menu other = (Menu) obj;
		if (adi == null)
		{
			if (other.adi != null)
				return false;
		}
		else if (!adi.equals(other.adi))
			return false;
		if (currentAccount == null)
		{
			if (other.currentAccount != null)
				return false;
		}
		else if (!currentAccount.equals(other.currentAccount))
			return false;
		if (options == null)
		{
			if (other.options != null)
				return false;
		}
		else if (!options.equals(other.options))
			return false;
		return true;
	}

	/**
	 * Runs the user once through the menu
	 */
	public void run()
	{
		int choice = this.getChoice();
		this.takeAction(choice);
	}
	
	/**
	 * Tells the driver whether or not to keep using this menu or whether to switch to another menu
	 * @return
	 */
	public abstract boolean continueRunning();
	
	public void printMenu()
	{
		for(String option : options)
		{
			System.out.println(option);
		}
		System.out.print("Enter the number associated with your choice: ");
	}
	
	public int getChoice()
	{
		Scanner sc = new Scanner(System.in);
		printMenu();
		try
		{
			int choice = sc.nextInt();
			if(choice <= 0 || choice > options.size())
			{
				System.out.println("Invalid choice");
				return getChoice();
			}
			return choice;
		}
		catch (InputMismatchException e)
		{
			System.out.println("Invalid choice.");
			return getChoice();
		}
	}
	
	public abstract void takeAction(int choice);
	
	/**
	 * Returns a menu to run after this menu stops running
	 * @return
	 */
	public abstract Menu transitionsTo();
}
