package com.revature.banking.menus;

import java.util.ArrayList;

public class AccountMenu extends Menu{
	
private static AccountMenu accountMenu=null;
	
	AccountMenu() {
		options=new ArrayList<String>();
		message="Account Menu";
		options.add("1. Manage Bank Accounts");
		options.add("2. Create New Bank Account");
		options.add("3. Log Out");
	}
	public static Menu getInstance() {
		if(accountMenu==null)
			accountMenu=new AccountMenu();
		return accountMenu;
	}

	@Override
	public void switcher() {
		int which=select();
		switch(which) {
		case 1:
			new ManageMenu().getInstance().switcher();
			break;
		case 2:
			new CreateMenu().getInstance().switcher();
			break;
		case 3:
			account=null;
			new MainMenu().getInstance().switcher();
			break;
		default:
			new AccountMenu().getInstance().switcher();
			break;
	}

	}
	
}
