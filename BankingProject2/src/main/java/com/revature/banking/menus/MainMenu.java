package com.revature.banking.menus;

import java.util.ArrayList;

public class MainMenu extends Menu{
	
	private static MainMenu mainMenu=null;
	
	MainMenu() {
		options=new ArrayList<String>();
		message="Java Banking Application 2.0";
		options.add("1. Sign In");
		options.add("2. Sign Up");
		options.add("3. Exit");
	}
	public static Menu getInstance() {
		if(mainMenu==null)
			mainMenu=new MainMenu();
		return mainMenu;
	}

	@Override
	public void switcher() {
		clear();
		int which=select();
		switch(which) {
		case 1:
			clear();
			new SignIn().getInstance().switcher();
			break;
		case 2:
			new SignUp().getInstance().switcher();
			break;
		case 3:
			clear();
			System.out.println("Goodbye! Thanks for using Java Banking Application 2.0");
			break;
		default:
			new MainMenu().getInstance().switcher();
	}
	
	}
}
