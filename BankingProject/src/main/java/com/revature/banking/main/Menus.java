package com.revature.banking.main;

import java.io.IOException;
import java.sql.CallableStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Scanner;

import com.revature.banking.pojos.Access;
import com.revature.banking.pojos.Account;
import com.revature.banking.pojos.BankAccount;
import com.revature.banking.util.ConnectionUtil;

public class Menus {

	Scanner scanner=new Scanner(System.in);
	Access access = new Access();
	Account account;
	
	public Menus() {
		super();
	}

	public void mainMenu() {
		System.out.println("Welcom to Java Banking Application 2.0");
		System.out.println();
		System.out.println("1. Sign In");
		System.out.println("2. Sign Up");
		System.out.println("3. Exit");
		
		switch (scanner.nextLine()) {
		case "1":
			clear();
			signIn();
			break;
		case "2":
			clear();
			signUpMenu();
			break;
		case "3":
			clear();
			System.out.println("Good bye! Thanks for using Java Banking Application 2.0");
			break;
		default:
			clear();
			System.out.println("Invalid Entry, please try again");
			mainMenu();
			break;
		}
	}
	
	public void signIn() {
		String user=null;
		String pass = null;
		
		System.out.println("Sign In");
		System.out.println();
		
		System.out.print("Username/Email:");
		user=scanner.nextLine();
		System.out.println();
		
		if(user.equals("")) {
			clear();
			System.out.println("Username/Email required");
			signIn();
		}
		else {
			do {
				System.out.print("Password:");
				pass=scanner.nextLine();
				if(pass.equals("")) {
					clear();
					System.out.println("Password required");
				}
				System.out.println();
			}while(pass.equals(""));
			
			account=access.logIn(user, pass);
			
			if(account==null) {
				clear();
				System.out.println("Username/Email or Password incorrect, please try again");
				signIn();
			}
			
			else {
				accountMenu();
			}
		}
		
	}
	
	public void signUpMenu() {
		String user=null;
		String user2=null;
		String pass = "";
		String pass2=null;
		
		System.out.println("Sign Up");
		System.out.println();
		
		System.out.print("Enter Email or Username:");
		user=scanner.nextLine();
		if(user.equals("") || user.equals(" ")) {
			clear();
			System.out.println("Email/Username is required");
			System.out.println();
			signUpMenu();
		}
		else {
			System.out.println();
			
			System.out.print("Re-Enter Email or Username:");
			user2=scanner.nextLine();
			if(user2.equals("") || user2.equals(" ")) {
				clear();
				System.out.println("Email/Username is required");
				signUpMenu();
			}
			else if(!user2.equals(user)) {
				clear();
				System.out.println("Emails/Usernames did not match");
				System.out.println();
				signUpMenu();
			}
			
			System.out.println();
			
			while(pass.equals(pass2)==false){
				do {
					System.out.print("Enter Password:");
					pass=scanner.nextLine();
					
					if(pass.equals("") || pass.equals(" ")) {
						clear();
						System.out.println("Password required");
						pass="";
					}
				}while(pass.equals("") || pass.equals(" "));
				
				System.out.println();
				
				System.out.print("Re-Enter Password:");
				pass2=scanner.nextLine();
				
				if(pass.equals(pass2)==false) {
					clear();
					System.out.println("Passwords did not match");
					pass2="";
				}
			}
			
			account=access.signUp(user, pass);
			
			if(account==null) {
				clear();
				System.out.println("Username or Email already in use. Please try with a different Username or Email");
				System.out.println();
				signUpMenu();
			}
			
			else {
				clear();
				System.out.println("Success! Welcome to Java Banking Application 2.0");
				accountMenu();
			}
		}
		
		
	}
	
	private void accountMenu() {
		String which;
		do {
			System.out.println("Account Menu");
			System.out.println();
			System.out.println("1. Manage Bank Accounts");
			System.out.println("2. Create New Bank Account");
			System.out.println("3. Log Out");
			
			which=scanner.nextLine();
			System.out.println(which);
			if(which.equals("1")==false && which.equals("2")==false && which.equals("3")==false) {
				clear();
				System.out.println("Invalid Entry, please try again");
				System.out.println();
				accountMenu();
			}
		}while(which.equals("1")==false && which.equals("2")==false && which.equals("3")==false);
		
		clear();
		
		switch(which) {
		case "1":
			manageMenu();
			break;
		case "2":
			createMenu();
			break;
		case "3":
			account=null;
			mainMenu();
			break;
		default:
			System.out.println("Invalid Entry");
			break;
		}
		
	}
	
	private void manageMenu() {
		String which;
		ArrayList<BankAccount> bankAccounts = account.getBankAccounts();
		
		System.out.println("Manage Account Menu");
		System.out.println();
		System.out.println("1. Make Deposit");
		System.out.println("2. Make Withdraw");
		System.out.println("3. Check Balance");
//		System.out.println("4. View Account History");
		System.out.println("4. Exit to Account Menu");
		which=scanner.nextLine();
		
		clear();
		
		switch(which) {
		case "1":
			deposit_withdraw(bankAccounts, 'd');
			break;
			
		case "2":
			deposit_withdraw(bankAccounts, 'w');
			break;
			
		case "3":
			int whichAccount=goThroughBankAccounts(bankAccounts);
			System.out.println("Balance of "+bankAccounts.get(whichAccount-1).getAcc_type()+" ACCOUNT "+bankAccounts.get(whichAccount-1).getAcc_num()+" is $"+bankAccounts.get(whichAccount-1).getBalance());
			System.out.println();
			System.out.println("Press Enter to Return to Manage Account Menu");
			scanner.nextLine();
			manageMenu();
			break;
			
		case "4":
			accountMenu();
			break;
			
//		case "5":
//			
//			break;
			
		default:
			System.out.println("Invalid Entry");
			System.out.println();
			manageMenu();
			break;
		}
		
	}
	
	private void createMenu() {
		String which;
		double deposit;
		System.out.println("New Bank Account Menu");
		System.out.println();
		System.out.println("1. Checking");
		System.out.println("2. Savings");
		System.out.println("3. Exit to Account Menu");
		
		which=scanner.nextLine();
		clear();
		switch(which) {
		case "1":
			deposit=-1;
			while(deposit<0) {
				System.out.println("How much would you like to deposit into your new bank account?");
				try {
				deposit=Double.parseDouble(scanner.nextLine());
				}catch(Exception e) {
					clear();
					System.out.println("Invalid Entry");
				}
				if(deposit<0) {
					clear();
					System.out.println("Invalid Entry");
				}
				System.out.println();
			}
			try {
				CallableStatement call = ConnectionUtil.getConnection().prepareCall("call NEW_CHECKING(?,?,?,?)");
				call.setInt(1, account.getUser_id());
				call.setDouble(2, deposit);
				call.setString(3, null);
				call.setString(4, null);
		
				call.executeQuery();
				
				clear();
				System.out.println("Checking account created successfully");
				account=access.logIn(account.getUser_name(), account.getPass());
				createMenu();
				
				
			} catch (SQLException | IOException e) {
				e.printStackTrace();
			}
			break;
		case "2":
			deposit=-1;
			while(deposit<0) {
				System.out.println("How much would you like to deposit into your new bank account?");
				try {
				deposit=Double.parseDouble(scanner.nextLine());
				}catch(Exception e) {
					clear();
					System.out.println("Invalid Entry");
				}
				if(deposit<200 && deposit!=-1) {
					clear();
					deposit=-1;
					System.out.println("Savings Accounts must be created with at least a $200.00 deposit");
				}
				System.out.println();
			}
			try {
				CallableStatement call = ConnectionUtil.getConnection().prepareCall("call NEW_SAVINGS(?,?,?,?)");
				call.setInt(1, account.getUser_id());
				call.setDouble(2, deposit);
				call.setString(3, null);
				call.setString(4, null);
				call.executeQuery();
				clear();
				System.out.println("Saving account created successfully");
				account=access.logIn(account.getUser_name(), account.getPass());
				createMenu();
				
				
			} catch (SQLException | IOException e) {
				e.printStackTrace();
			}
			break;
		case "3":
			accountMenu();
			break;
		default:
			System.out.println("Invalid Entry");
			System.out.println();
			createMenu();
			break;
		}
	}
	
	private void clear() {
		try {
			int clear = new ProcessBuilder("cmd", "/c", "cls").inheritIO().start().waitFor();
		} catch (InterruptedException | IOException e) {
			e.printStackTrace();
		}
	}
	
	private void deposit_withdraw(ArrayList<BankAccount> bankAccounts, char which) {
		int whichAccount=0;
		BankAccount current;
		
		bankAccounts=account.getBankAccounts();
		if(bankAccounts.isEmpty()) {
			System.out.println("You have not created a bank account yet");
			System.out.println();
			System.out.println("Press Enter to Return to Account Menu");
			scanner.nextLine();
			clear();
			accountMenu();
		}
		else {
			int count=1;
			double amount=-1;
			String check;
			
			if(bankAccounts.size()>1) {
				whichAccount=goThroughBankAccounts(bankAccounts);
			}
			
			current=bankAccounts.get(whichAccount-1);
			
			
			while(amount<0) {
				if(which=='d')
					System.out.println("How much would you like to deposit?");
				else
					System.out.println("How much would you like to withdraw?");
				try {
					check=scanner.nextLine();
					amount=Double.parseDouble(check);
					if(check.contains(".") && check.substring(check.indexOf(".")).length()>2) {
						clear();
						System.out.println("Can only take a number with up to 2 decimal places");
						amount=-1;
						continue;
					}
					
				}catch(Exception e) {
					e.printStackTrace();
					clear();
					System.out.println("Invalid Entry");
					amount=-1;
				}
				if(amount>0) {
					boolean allGood;
					if(which=='d') {
						allGood=current.depsoit(amount);
						if(allGood)
							System.out.println("Deposit successful. Account balance is now $"+current.getBalance());
						else
							System.out.println("Error, something went wrong. Please try again");
					}
					else {
						allGood=current.withdraw(amount);
						if(allGood)
							System.out.println("Withdraw successful. Account balance is now $"+current.getBalance());
						else
							System.out.println("Amount is higher than balance. Balance is $"+current.getBalance());
					}
					
					System.out.println();
					System.out.println("Press Enter to Return to Manage Account Menu");
					account=access.logIn(account.getUser_name(), account.getPass());
					clear();
					manageMenu();
				}
				else
					clear();
					manageMenu();
			}
			
		}
	}
	
	private int goThroughBankAccounts(ArrayList<BankAccount> bankAccounts) {
		int whichAccount=0;
		int count=1;
		
		while(whichAccount==0) {
			System.out.println("Which Account");
			for(BankAccount ba: bankAccounts) {
				System.out.println(count+". "+ba.getAcc_type()+" "+ba.getAcc_num());
				count++;
			}
			
			try {
				whichAccount=Integer.parseInt(scanner.nextLine());
			}catch(Exception e){
				clear();
				System.out.println("Invalid Entry");
				whichAccount=0;
				count=1;
			}
			
			if(whichAccount>=count || whichAccount<=0) {
				clear();
				System.out.println("Invalid Entry");
				whichAccount=0;
				count=1;
			}
		}
		
		return whichAccount;
	}
	
}
