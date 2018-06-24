package com.revature.menu;

import java.util.Scanner;

import com.revature.dao.DaoInterfaceImpl;
import com.revature.menu.Menu;
import com.revature.pojos.*;

//Stores methods that write and read bank account information
public class GetClient {
	
	private static Scanner scanner = new Scanner(System.in);
	private static DaoInterfaceImpl dImpl = new DaoInterfaceImpl();
	static String username;
	static String password;

	
	public static Client getClient() {
		do{
			//prompts the user for username and password
			//This method cannot be run in a separate thread, because the program needs to stop when the user
			//enters the username and password.
			//This is acceptable because while the user is logging in, nothing else should be happening
			System.out.println("Type 'exit' at any time to exit");
			System.out.println(Menu.lineBreak);
			System.out.print("Please enter your username: ");
			username = scanner.nextLine();
			if(username.equals("exit")) Menu.exit();
			System.out.print("Please enter your password: ");
			password = scanner.nextLine();
			if(password.equals("exit")) Menu.exit();

			Client client = dImpl.login(username, password);
			if(client != null) {
				return client;
			}	
		}while(true);
	}
}
