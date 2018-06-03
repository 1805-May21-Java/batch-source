package com.revature.Bank;

import java.io.*;
import java.util.*;

public class BankDriver {

	@SuppressWarnings("resource")
	public static void main(String[] args) throws ClassNotFoundException, IOException {
		String filename = "src/com/revature/Bank/Account.txt";
		Scanner sc = new Scanner(System.in);
		String choice="";
		ArrayList<BankAccounts> Account = getAccounts(filename);
		while(!choice.equalsIgnoreCase("E")) {
			MainMenu();
			choice = sc.nextLine();
			if(choice.equalsIgnoreCase("1")) {
				if(Account.size()==0) {
					System.out.println("There are no accounts listed for login");
				}
				else {
					System.out.print("Username: ");
					String UName = sc.nextLine();
					System.out.print("Password: ");
					String Passw = sc.nextLine();
					int index = retrieveIndex(Account,UName,Passw);
					if(index == -1) {
						System.out.println("Error: No account with those Login credentials");
					}
					
					else {
						System.out.println();
						LoggedIn(Account,index);
					}
				}
			}
			else if(choice.equalsIgnoreCase("2")) {
				newAccount(Account);
			}
			else if(choice.equalsIgnoreCase("3")) {
				createObjectFile(filename,Account);
				System.out.println("Terminating: Thank you for bankig with us!");
			}
			else {
				System.out.println();
			}
			System.out.println();
		}
	}
	
	//Returns an ArrayList from reading the file
	private static ArrayList<BankAccounts> getAccounts(String filename) throws IOException, ClassNotFoundException {
		ArrayList<BankAccounts> accounts = new ArrayList<BankAccounts>();
		FileInputStream fos;
		ObjectInputStream object_reader = null;
		try {
			fos = new FileInputStream(filename);
			object_reader = new ObjectInputStream(fos);
		}
		catch(IOException e) {
			System.out.println("No file was found");
			return accounts;
		}
		while(true) {
			try {
				BankAccounts account =(BankAccounts)object_reader.readObject();
				accounts.add(account);
			}
			catch(Exception ex) {
				break;
			}
		}
		object_reader.close();
		return accounts;
	}


	@SuppressWarnings("resource")
	private static void createObjectFile(String filename, ArrayList<BankAccounts> account) throws IOException, ClassNotFoundException {
		//Creates an instance for the write object
		FileOutputStream fos = new FileOutputStream(filename);
		ObjectOutputStream objectWrite = new ObjectOutputStream(fos);
		for(int i=0; i<account.size();i++) {
			objectWrite.writeObject(account.get(i));
		}
		objectWrite.flush();
	}


	//Method to create new account and info for it
	@SuppressWarnings("resource")
	private static void newAccount(ArrayList<BankAccounts> account) {
		String name;
		int accNum;
		double balance;
		String nameUser;
		String passWd;
		//Random Variable that will be used for account number
		Random r = new Random();
		int High =9999;
		int Low =1000;
		Scanner sc = new Scanner(System.in);
		System.out.println("Account Name: ");
		name = sc.nextLine();
		System.out.println("Account Number Created");
		accNum = r.nextInt(High-Low)+Low;
		System.out.print("Deposit Starting Money amount and Enter for Verification: ");
		balance = Double.parseDouble(sc.nextLine());
		System.out.print("Username for this account: ");
		nameUser = sc.nextLine();
		System.out.print("Password for this account: ");
		passWd = sc.nextLine();
		BankAccounts acc  = new BankAccounts(name,accNum,balance,nameUser,passWd);
		account.add(acc);
	}
	
	@SuppressWarnings("resource")
	private static void LoggedIn(ArrayList<BankAccounts> account, int index) {
		Scanner sc = new Scanner(System.in);
		String decision="";
		while(!decision.equalsIgnoreCase("1")) {
			logInMenu();
			decision = sc.nextLine();
			System.out.println();
			if(decision.equalsIgnoreCase("2")) {
				System.out.print("Enter amount to deposit:$ ");
				double amount = Double.parseDouble(sc.nextLine());
				int flag = account.get(index).deposit(amount);
				if(flag == -1) {
					System.out.println("Invalid amount");
				}
				else if(flag == -2) {
					System.out.println("Requested amount not avaliable for withdrawl");
				}
				else {
					System.out.println("Money being deposited");
				}
			}
			else if(decision.equalsIgnoreCase("3")) {
				System.out.println("Avaliable Balance: $"+ account.get(index).getBalance());
			}
			else if(decision.equalsIgnoreCase("4")) {
				System.out.print(account.get(index));
			}
			else if(decision.equalsIgnoreCase("5")) {
			}
			else {
				System.out.println("That choice isn't listed for selection");
				return;
			}
			System.out.println();
		}
	}
	//Displays Login Menu after User enters in their login information on file
	private static void logInMenu() {
		System.out.println("Selection Menu");
		System.out.println();
		System.out.println("1.Deposit");
		System.out.println("2.Withdraw");
		System.out.println("3.Balance Request");
		System.out.println("4.Account Information");
		System.out.println("5.Logout");
		System.out.println("");
		System.out.println("Enter Selection: ");
	}
	//Receives and returns index from the Account List
	private static int retrieveIndex(ArrayList<BankAccounts> account, String uName, String passw) {
		for(int i=0;i<account.size();i++) {
			BankAccounts acc = account.get(i);
			if(acc.getUName().equals(uName) && acc.getPassw().equals(passw)) {
				return i;
			}
		}
		return -1;
	}
	//Displays main menu when the program starts
	private static void MainMenu() {
		System.out.println("Main Menu:");
		System.out.println("1.Login to your Account");
		System.out.println("2.Create new Account");
		System.out.println("3.Exit");
		System.out.println("Enter your choice: ");
	}

}
