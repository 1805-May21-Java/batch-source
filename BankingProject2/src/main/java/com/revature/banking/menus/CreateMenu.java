package com.revature.banking.menus;

import java.io.IOException;
import java.sql.CallableStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

public class CreateMenu extends Menu{

private static CreateMenu createMenu=null;
	
	CreateMenu() {
		options=new ArrayList<String>();
		message="Create New Bank Account Menu";
		options.add("1. Checking");
		options.add("2. Savings");
		options.add("3. Exit to Account Menu");
	}
	public static Menu getInstance() {
		if(createMenu==null)
			createMenu=new CreateMenu();
		return createMenu;
	}

	@Override
	public void switcher() {
		int which=select();
		switch(which) {
		case 1:
			clear();
			newBankAccount('c');
			break;
		case 2:
			clear();
			newBankAccount('s');
			break;
		case 3:
			clear();
			new AccountMenu().getInstance().switcher();
			break;
	}

	}
	
	private void newBankAccount(char type) {
		double deposit;
		deposit=-1;
		boolean skip=false;
		while(deposit<0) {
			System.out.println("How much would you like to deposit into your new bank account?");
			try {
			deposit=Double.parseDouble(scanner.nextLine());
			}catch(Exception e) {
				
			}
			if(deposit<0) {
				clear();
				System.out.println("Invalid Entry");
			}
			else if(deposit<200 && type=='s') {
				clear();
				System.out.println("Saving Account requires a minimum $200 deposit");
				String choice=exitOut("Create New Bank Account Menu");
				
				if(choice.equals("1")) {
					clear();
					deposit=0;
					skip=true;
				}
				else {
					clear();
					deposit=-1;
				}
			}
			System.out.println();
		}
		if(skip==false) {
			if(type=='c') {
				account.newCheckingAccount(account.getUser_id(), deposit);
				account=access.logIn(account.getUser_name(), account.getPass());
				System.out.println();
				new CreateMenu().getInstance().switcher();
			}
			else {
				
				account.newSavingsAccount(account.getUser_id(), deposit);
				System.out.println("Savings account created successfully");
				account=access.logIn(account.getUser_name(), account.getPass());
				new CreateMenu().getInstance().switcher();
			}
			
		}
	}
}
