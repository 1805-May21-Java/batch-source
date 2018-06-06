package com.revature.menus;

import java.util.*;

import com.revature.dao.*;
import com.revature.pojos.*;

public abstract class MMenu
{
	protected ArrayList<String> options;
	protected MultiAccountDaoImpl madi;
	protected UserDaoImpl udi;
	protected MultiAccount currentAccount;
	protected User currentUser;
	
	
	
	public MMenu()
	{
		super();
	}
	
	public MMenu(MultiAccountDaoImpl madi, UserDaoImpl udi, MultiAccount currentAccount, User currentUser)
	{
		super();
		this.madi = madi;
		this.udi = udi;
		this.currentAccount = currentAccount;
		this.options = new ArrayList<String>();
		this.currentUser = currentUser;
	}

	public MMenu(MultiAccountDaoImpl madi, UserDaoImpl udi)
	{
		super();
		this.madi = madi;
		this.udi = udi;
		this.options = new ArrayList<String>();
		currentAccount = null;
	}

	public MMenu(MultiAccountDaoImpl madi, UserDaoImpl udi, User currentUser)
	{
		super();
		this.madi = madi;
		this.udi = udi;
		this.options = new ArrayList<String>();
		this.currentUser = currentUser;
	}

	public UserDaoImpl getUdi()
	{
		return udi;
	}

	public void setUdi(UserDaoImpl udi)
	{
		this.udi = udi;
	}

	public ArrayList<String> getOptions()
	{
		return options;
	}

	public void setOptions(ArrayList<String> options)
	{
		this.options = options;
	}

	public MultiAccountDaoImpl getMadi()
	{
		return madi;
	}

	public void setAdi(MultiAccountDaoImpl madi)
	{
		this.madi = madi;
	}

	public MultiAccount getCurrentAccount()
	{
		return currentAccount;
	}

	public void setCurrentAccount(MultiAccount currentAccount)
	{
		this.currentAccount = currentAccount;
	}
	
	@Override
	public int hashCode()
	{
		final int prime = 31;
		int result = 1;
		result = prime * result + ((currentAccount == null) ? 0 : currentAccount.hashCode());
		result = prime * result + ((madi == null) ? 0 : madi.hashCode());
		result = prime * result + ((options == null) ? 0 : options.hashCode());
		result = prime * result + ((udi == null) ? 0 : udi.hashCode());
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
		MMenu other = (MMenu) obj;
		if (currentAccount == null)
		{
			if (other.currentAccount != null)
				return false;
		}
		else if (!currentAccount.equals(other.currentAccount))
			return false;
		if (madi == null)
		{
			if (other.madi != null)
				return false;
		}
		else if (!madi.equals(other.madi))
			return false;
		if (options == null)
		{
			if (other.options != null)
				return false;
		}
		else if (!options.equals(other.options))
			return false;
		if (udi == null)
		{
			if (other.udi != null)
				return false;
		}
		else if (!udi.equals(other.udi))
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
	public abstract MMenu transitionsTo();
}
