package com.revature.menus;

import java.util.Scanner;

import com.revature.dao.*;
import com.revature.pojos.*;

public class MUserCreationMenu extends MMenu
{
	
	public MUserCreationMenu()
	{
		super();
	}

	public MUserCreationMenu(MultiAccountDaoImpl madi, UserDaoImpl udi)
	{
		super(madi, udi);
		options.add("1. Create a user");
		options.add("2. Exit");
	}

	@Override
	public boolean continueRunning()
	{
		return !udi.usersExist();
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

	@Override
	public MMenu transitionsTo()
	{
		return new MLogInMenu(madi, udi);
	}

}
