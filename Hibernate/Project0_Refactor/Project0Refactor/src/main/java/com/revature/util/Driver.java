package com.revature.util;

import com.revature.menus.AccountMenu;
import com.revature.menus.UserMenu;
import com.revature.models.*;

public class Driver {

	public static void main(String[] args) {
		UserMenu userMenu = new UserMenu();
		BankUser user = userMenu.display();
		
		AccountMenu accountMenu = new AccountMenu();
		accountMenu.display(user);
	}

}