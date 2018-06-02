package com.revature.main;

import java.io.IOException;
import java.sql.*;
import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.util.*;

import com.revature.dao.*;
import com.revature.menus.*;
import com.revature.pojos.Account;
import com.revature.util.*;

public class Driver
{
	public static void main(String[] args)
	{
		AccountDaoImpl adi = new AccountDaoImpl();
		Account currentAccount = null;
		Menu currentMenu = new UserCreationMenu(adi);
		
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
