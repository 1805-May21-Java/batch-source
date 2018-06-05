package com.revature.menus;

import java.util.Scanner;
import com.revature.dao.AccountDaoImpl;
import com.revature.dao.UserDaoImpl;
import com.revature.pojos.User;

public class UserMenu {
	public User display() {
		Scanner sc = new Scanner(System.in);
		boolean flag = false;
		String operation = "";
		UserDaoImpl udi = new UserDaoImpl();
		AccountDaoImpl adi = new AccountDaoImpl();
		User user = null;

		while(flag != true) {
			System.out.println("Welcome!\nEnter 1 to create a new account or\n2 to log in to an existing account.");
			
			operation = sc.nextLine();
			switch(operation) {
				case "1":
					System.out.println("Enter your username.");
					String username = sc.nextLine();
					System.out.println("Enter your password.");
					String password = sc.nextLine();
					user = new User(username, password);
					if(udi.createUser(user) == 1) {
						flag = true;
						adi.createAccount(username);
					}
					break;
				case "2":
					System.out.println("Enter your username.");
					username = sc.nextLine();
					System.out.println("Enter your password.");
					password = sc.nextLine();
					//user = new User(username, password);
					user = udi.getUser(username, password);
					if(user != null)
						flag = true;
					break;
				default:
					System.out.println("Invalid operation");
					break;
			}
		}
		//sc.close();
		return user;
	}
}
