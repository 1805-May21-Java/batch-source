package com.revature.actors;

import com.revature.menus.AccountMenu;
import com.revature.menus.LoginMenu;
import com.revature.menus.TransactionMenu;
import com.revature.utils.GeneralConfirmation;

public class Teller {
	private int currentUsersId;
	private long currentUserAccount;

	public int getCurrentUsersId() {
		return currentUsersId;
	}

	public void setCurrentUsersId(int currentUsersId) {
		this.currentUsersId = currentUsersId;
	}

	public long getCurrentUserAccount() {
		return currentUserAccount;
	}

	public void setCurrentUserAccount(long currentUserAccount) {
		this.currentUserAccount = currentUserAccount;
	}
	
	public void open() {
		boolean keepGoing;
		do {
			System.out.println("Welcome!");
			LoginMenu loginMenu = new LoginMenu(this);
			keepGoing = loginMenu.navigate();
			if(keepGoing) {
				do {
					AccountMenu accountMenu = new AccountMenu(this);
					keepGoing = accountMenu.navigate();
					if(keepGoing) {
						TransactionMenu transactionMenu = new TransactionMenu(this);
						keepGoing = transactionMenu.navigate();
					}
				} while (keepGoing);
			}
			System.out.println("Thank you for banking with us!\n");
			keepGoing = GeneralConfirmation.check("Do you wish to start a new session?");
		} while (keepGoing);
		
		System.out.println("Teller closed.");
	}
}
