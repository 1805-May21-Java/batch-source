package com.revature.main;

import java.util.*;

import com.revature.dao.*;
import com.revature.menus.MMenu;
import com.revature.menus.MUserCreationMenu;
import com.revature.pojos.*;

public class MultiAccountDriver
{
	public static void main(String[] args)
	{
		MultiAccountDaoImpl madi = new MultiAccountDaoImpl();
		UserDaoImpl udi = new UserDaoImpl();
		MMenu currentMenu = new MUserCreationMenu(madi, udi);
		
		while(true)
		{
			while(currentMenu.continueRunning())
			{
				currentMenu.run();
			}
			currentMenu = currentMenu.transitionsTo();
		}
	}

}
