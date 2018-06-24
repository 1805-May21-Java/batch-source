package com.revature.main;

import java.io.*;
import java.util.*;

import com.revature.dao.CustomerDaoImpl;
import com.revature.pojos.Customer;

public class Account {
	
	//declaring variables to use later
	private static String username = "";
//	private static String begBalance = "";
//	private static String currBalance = "0";
	private static Scanner sc = new Scanner(System.in);
	static BufferedWriter bw = null;
	static BufferedReader br = null;
//	static String userData = "src/com/revature/main/UserData";
//	static Map<String, ArrayList<String>> users = new HashMap<String, ArrayList<String>>();

	//retrieve user information and print menus
	public static void main(String[] args) {
		
		//populateList();
		//System.out.println(users);
		mainMenu();
		//begBalance = users.get(username).get(1);
		bankMenu();
	}
	
	//gets the amount the user would like to deposit, adds it to their balance and changes
	//it in the array
	static void deposit() {
		System.out.println("Please enter an amount to deposit.");
		int amount = Integer.parseInt(sc.nextLine());
		
		CustomerDaoImpl cdi = new CustomerDaoImpl();
		int balance = cdi.getBalanceByUsername(username);
		balance += amount;
		//System.out.println(balance);
		
		Customer c = cdi.getCustomerByUsername(username);
		c.setBalance(balance);
		//System.out.println(c);
		System.out.println("$"+amount+" deposited.");
		cdi.changeBalance(c);
		bankMenu();
	}
	
	//gets the amount the user would like to withdraw, adds it to their balance and changes
	//it in the array, doesn't allow user to withdraw more than balance
	static void withdraw() {
		System.out.println("Please enter an amount to withdraw.");
		int amount = Integer.parseInt(sc.nextLine());
		
		CustomerDaoImpl cdi = new CustomerDaoImpl();
		int balance = cdi.getBalanceByUsername(username);
		if(amount<=balance && amount > 0) {
			balance -= amount;
			//System.out.println(balance);
			
			Customer c = cdi.getCustomerByUsername(username);
			c.setBalance(balance);
			System.out.println("$"+amount+" withdrawn.");
			cdi.changeBalance(c);
			bankMenu();
		}else {
			System.out.println("Insufficient Funds, your current balance is "+balance+". Please try again.");
			bankMenu();
		}
	}
//	
	//retrieves the users current balance from the array
	static void viewBalance() {
		
		CustomerDaoImpl cdi = new CustomerDaoImpl();
		int balance = cdi.getBalanceByUsername(username);
		System.out.println("Your current balance is: $"+balance);
		bankMenu();	
	}
	
	//registers the user, not allowing a duplicate username
	//usernames and passwords are case sensitive
	static void register() {
		System.out.println("Please enter a username");
		String tempUsername = sc.nextLine();
		CustomerDaoImpl cdi = new CustomerDaoImpl();
		
		System.out.println("Please enter your password");
		String password = sc.nextLine();
		
		if(cdi.getCustomerByUsername(tempUsername)==null) {
			Customer c = new Customer(tempUsername, password, 0);
			//System.out.println(c);
			cdi.createCustomer(c);
			System.out.println("Account has been created.");
			mainMenu();
		}else {
			System.out.println("Username taken. Please try another.");
			register();
		}
		
//		Customer c = new Customer(tempUsername, password, 0);
//		System.out.println(c);
//		cdi.createCustomer(c);
//		mainMenu();
		
		//if(cdi.getCustomerByUsername(tempUsername)==null) {
			
			
			//String userInfo = "\n"+tempUsername+","+password+",0";
			
//			try {
//				//specifying the file we want to write to
//				File file = new File(userData);
//				//checking first to see if the file exists, creating it if it doesn't
//				if(!file.exists()) {
//					file.createNewFile();
//				}
//				
//				//our Filewriter has an optional argument which specifies whether it will append
//				FileWriter fw = new FileWriter(file, true);
//				bw = new BufferedWriter(fw);
//				
//				bw.write(userInfo);
//				System.out.println("Thank you for registering for the Bank of Java.");
//				
//			
//			} catch (IOException e) {
//				e.printStackTrace();
//			} finally {
//				if(bw != null) {
//					try {
//						bw.close();
//					} catch (IOException e) {
//						e.printStackTrace();
//					}
//				}
//				mainMenu();
//			}
//		}else {
//			System.out.println("Username is taken, please try another.");
//			register();
//		}
	}
	
	//log in method, checks the password in the list array
	static void logIn() {
		//populateList();
		System.out.println("Plese enter your username:");
		String tempUsername = sc.nextLine();
		System.out.println("Please enter your password");
		String password = sc.nextLine();
		CustomerDaoImpl cdi = new CustomerDaoImpl();
		
		if(cdi.getCustomerByUsername(tempUsername) == null) {
			System.out.println("null");
			System.out.println("Log In failed. Please try again.");
			logIn();
		}else if(password.equals(cdi.getCustomerByUsername(tempUsername).getPassword())) {
			System.out.println("Login Successful");
			username = tempUsername;
		}else {
			System.out.println("Log In failed. Please try again.");
			logIn();
		}
	}
	
	//log out writes the changed information back into the text file and returns to main menu
	static void logOut() {
		main(null);
//		try {
//			//specifying the file we want to write to
//			File file = new File(userData);
//			//checking first to see if the file exists, creating it if it doesn't
//			if(!file.exists()) {
//				file.createNewFile();
//			}
//			
//			//our Filewriter has an optional argument which specifies whether it will append
//			FileWriter fw = new FileWriter(file, true);
//			bw = new BufferedWriter(fw);
//			br = new BufferedReader(new FileReader(userData));
//
//			String line;
//			while ((line = br.readLine()) !=null) {
//				if(line.contains(username)) {
//					//System.out.println(begBalance);
//					//System.out.println(currBalance);
//					String newLine = line.replace(begBalance, currBalance);
//					bw.write("\n"+newLine);
//					//System.out.println(newLine);
//				}
//			}
//			
//		} catch (IOException e) {
//			e.printStackTrace();
//		} finally {
//			if(bw != null) {
//				try {
//					bw.close();
//				} catch (IOException e) {
//					e.printStackTrace();
//				}
//			}
//		}
//		main(null);
	}
	
	//prompts the user originally on registering or logging in
	static void mainMenu() {
		System.out.println("Welcome to the Bank of Java, please select an option."
				+ "\n1) Log In"
				+ "\n2) Register");
		String choice = sc.nextLine().toLowerCase();
		
		switch(choice) {
		case "1": case "log in":
			logIn();
			break;
		case "2": case "register":
			register();
			break;
		default:
			System.out.println("Invalid command, please try again.");
			mainMenu();
		}
	}
	
	//once logged in, menu prompts to withdraw, deposit, view balance, or log out
	static void bankMenu() {
		System.out.println("Please select an action."
				+ "\n1) Deposit"
				+ "\n2) Withdraw"
				+ "\n3) View Balance"
				+ "\n4) Log Out");
		String choice = sc.nextLine().toLowerCase();
		
		switch(choice) {
		case "1": case "deposit":
			deposit();
			break;
		case "2": case "withdraw":
			withdraw();
			break;
		case "3": case "view balance":
			viewBalance();
			break;
		case "4": case "log out":
			logOut();
			break;
		default:
			System.out.println("Invalid command, please try again.");
			bankMenu();
		}
	}

}