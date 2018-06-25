package com.revature.banking.main;

import java.io.IOException;
import java.sql.SQLException;
import com.revature.banking.menus.MainMenu;
import com.revature.banking.menus.Menu;

public class Driver {

	public static void main(String args[]) throws SQLException, IOException {
		
		Menu mainMenu=MainMenu.getInstance();
		mainMenu.switcher();
		
	}
}
