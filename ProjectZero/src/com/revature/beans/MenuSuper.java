package com.revature.beans;

import java.util.*;

import com.revature.accountGrouping.*;

public abstract class MenuSuper
{
	protected ArrayList<String> options;
	protected Account currentAccount;

	public MenuSuper()
	{
		super();
	}
	
	public MenuSuper(Account account)
	{
		super();
		currentAccount = account;
	}
	
	public ArrayList<String> getOptions()
	{
		return options;
	}

	public void setOptions(ArrayList<String> options)
	{
		this.options = options;
	}

	@Override
	public int hashCode()
	{
		final int prime = 31;
		int result = 1;
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
		MenuSuper other = (MenuSuper) obj;
		if (options == null)
		{
			if (other.options != null)
				return false;
		}
		else if (!options.equals(other.options))
			return false;
		return true;
	}

	public void printMenu()
	{
		for(String option : options)
		{
			System.out.println(option);
		}
		System.out.println("Enter the number associated with your choice: ");
	}
	
	public int getChoice()
	{
		Scanner sc = new Scanner(System.in);
		int choice = -1;
		//While we don't have a valid choice...
		while(choice < 1 || choice > options.size())
		{
			try
			{
				choice = sc.nextInt();
				if(choice < 1 || choice > options.size())
				{
					System.out.println("Invalid choice.  Please enter a number between 1 and " + options.size());
				}
			}
			catch(InputMismatchException e)
			{
				System.out.println("Invalid choice.  Please enter a number between 1 and " + options.size());					
			}
		}
		
		return choice;		
	}
	
	public Account getCurrentAccount()
	{
		return currentAccount;
	}
}
