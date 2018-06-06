package com.revature.MockBank2;
import java.util.Scanner;

import com.revature.dao.BankInfoDaoImpl;

public class SpecificCommand {
	BankInfoDaoImpl bidi = new BankInfoDaoImpl();
	private Scanner scan = new Scanner(System.in);
	
	
	protected String username() {
		String username;
		String yorn;
		System.out.println("Customer, please enter your username: ");
		//set local username = next entry
		username = scan.nextLine();
		//make sure there are no two usernames that are the same
		if(bidi.checkEqualUser(username) == false) {
			if(username != null) {
				//if entry isn't null, ask user if what he entered is what he wants
				System.out.println("Is this your intended username: " + username);
				System.out.println("Enter y for yes, and n for no: ");
				yorn = scan.nextLine().toLowerCase();
				//confirmation
				while(!yorn.equals("y") && !yorn.equals("n")){
					System.out.println("Invalid Command, please re-enter your command");
					System.out.println("Enter y for yes, and n for no: ");
					yorn = scan.nextLine().toLowerCase();
				}
				if(yorn.equals("y")) {
					//if user agrees, return username entered out to signup
					return username;
				} else if (yorn.equals("n")) {
					//if not, re do the whole function again to ask username
					username();
				}
			}
			return username();
		}
		else {
			System.out.println("Sorry, already taken username, please try again");
			return username();
		}
	}
	
	protected String email() {
		String email;
		String yorn;
		//similar process for email as well
		System.out.println("Customer, please enter your email: ");
		email = scan.nextLine();
		if (bidi.checkEqualEmail(email) == false) {
			if(email != null) {
				System.out.println("Is this your intended email: " + email);
				System.out.println("Enter y for yes, and n for no: ");
				yorn = scan.nextLine().toLowerCase();
				while(!yorn.equals("y") && !yorn.equals("n")){
					System.out.println("Invalid Command, please re-enter your command");
					System.out.println("Enter y for yes, and n for no: ");
					yorn = scan.nextLine().toLowerCase();
				}
				if(yorn.equals("y")) {
					return email;
				} else if (yorn.equals("n")) {
					email();
				}
			}
			return email();
		}
		else {
			System.out.println("Sorry, already taken email, please try again");
			return email();
		}
	}
	
	protected String password() {
		String password;
		//asking for password, and then go to password confirmation
		System.out.println("Customer, please enter your password: ");
		password = scan.nextLine();
		if(password != null) {
			return passwordConfirmation(password);
		}
		return password();
	}
	
	protected String passwordConfirmation(String p) {
		String passwordc;
		String yorn;
		System.out.println("Customer, please confirm your password: ");
		//asks the user to reenter his password, if 2 entry are equal, return passwword into signup function
		passwordc = scan.nextLine();
		if(passwordc != null) {
			if(passwordc.equals(p)) {
				return p;
			} else {
				//password doesn't match, gives customer 2 options: re enter the confirmation password
				//or re do the password process again
				System.out.println("Password doesn't match, do you want to re-enter your password?");
				yorn = scan.nextLine();
				while(!yorn.equals("y") && !yorn.equals("n")){
					System.out.println("Invalid Command, please re-enter your command");
					System.out.println("Enter y for yes, and n for no: ");
					yorn = scan.nextLine().toLowerCase();
				}
				if(yorn.equals("y")) {
					return passwordConfirmation(p);
				} else if (yorn.equals("n")) {
					password();
				}
			}
		}
		return passwordConfirmation(p);
	}
	
	protected String logUserOrEmail () {
		//simple method to input the login username
		String username;
		System.out.println("Enter your username or email: ");
		username = scan.nextLine();
		return username;
	}
	protected String logPassword () {
		//simple method to ask the password
		String password;
		System.out.println("Enter your password: ");
		password = scan.nextLine();
		return password;
	}
}
