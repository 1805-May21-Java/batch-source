package com.revature.menus;

import com.revature.pojos.User;

public class Menu {
	public static void display() {
		UserMenu userMenu = new UserMenu();
		User user = userMenu.display();
		
		AccountMenu accountMenu = new AccountMenu();
		accountMenu.display(user);
	}
}
