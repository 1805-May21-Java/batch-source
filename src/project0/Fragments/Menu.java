package project0.Fragments;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.Locale;
import java.util.Scanner;

import project0.data.Account;
import project0.data.User;

public class Menu {

	private ArrayList<User> userList;
	private ArrayList<Account> accountList;
	String dir = System.getProperty("user.dir");
	private User currentUser;
	Scanner scanner = new Scanner(System.in);
	boolean validInput = false;
	int bloop;
	double bloops;

	public void start() {
		if (userList == null) {
			userList = new ArrayList();
		}
		if (accountList == null) {
			accountList = new ArrayList();
		}
		checkData();
		menu1();
	}

	public void menu1() {
		while (!validInput) {
			System.out.println("Choose option:");
			System.out.println("1. Login");
			System.out.println("2. Create Account");
			System.out.println("3. Exit");
			if (scanner.hasNextInt()) {
				bloop = scanner.nextInt();
				if (bloop > 0 && bloop < 4) {
					menu1Select(bloop);
					validInput = true;
				} else {
					System.out.println("Integer is not within range.");
				}
			} else {
				System.out.println("Not an Integer.");
				scanner.next();
			}
		}
	}

	public void menu2() {
		while (!validInput) {
			System.out.println("Choose option:");
			System.out.println("1. Deposit");
			System.out.println("2. Withdraw");
			System.out.println("3. View Balance");
			System.out.println("4. Logout");
			if (scanner.hasNextInt()) {
				bloop = scanner.nextInt();
				if (bloop > 0 && bloop < 5) {
					menu2Select(bloop);
					validInput = true;
				} else {
					System.out.println("Integer is not within range.");
				}
			} else {
				System.out.println("Not an Integer.");
				scanner.next();
			}
		}
	}

	public void menu1Select(int choice) {
		validInput = false;
		switch (choice) {
		case 1:
			System.out.println("Enter a username: ");
			login(scanner.next());
			break;
		case 2:
			// while(!validInput){
			System.out.println("Enter a username: ");
			createUser(scanner.next().replaceAll("[^a-zA-Z0-9]", ""));
			// }
			break;
		case 3:
			System.exit(0);
			writeData();
			break;
		}
	}

	public void menu2Select(int choice) {
		validInput = false; 
		scanner.useLocale(Locale.US);
		switch (choice) {
		case 1:
			System.out.println("Enter a value to deposit: ");
			while (!validInput) {
				if (scanner.hasNextDouble()) {
					bloops = scanner.nextDouble();
					deposit(bloops);
					validInput = true;
				} else {
					System.out.println("Not a double.");
					scanner.next();
				}

			}
			break;
		case 2:
			System.out.println("Enter a value to withdraw: ");
			while (!validInput) {
				if (scanner.hasNextDouble()) {
					bloops = scanner.nextDouble();
					withdraw(bloops);
					validInput = true;
				} else {
					System.out.println("Not a double.");
					scanner.next();
				}

			}
			break;
		case 3:
			System.out.println("Current balance is: " + accountList.get((int)currentUser.getAccountID()).getSavings());
			menu2();
			break;
		case 4:
			System.out.println("Logged out.");
			currentUser = null;
			writeData();
			menu1();
			break;
		}
	}
	
	public void deposit(double deposit){
		for(Account account: accountList){
			if(account.getAccountID() == currentUser.getAccountID()){
//				System.out.println("savings is: " + account.getSavings() + " deposit is: " + deposit);
				account.setSavings(account.getSavings() + deposit);
				System.out.println("Deposit succesful.");
				System.out.println("Current balance is: " + account.getSavings());
				break;
			}
		}
		writeData();
		menu2();
	}
	
	public void withdraw(double withdraw){
		for(Account account: accountList){
			if(account.getAccountID() == currentUser.getAccountID()){
				account.setSavings(account.getSavings() - withdraw);
				System.out.println("Withdraw succesful.");
				System.out.println("Current balance is: " + account.getSavings());
				break;
			}
		}
		writeData();
		menu2();
	}

	public void createUser(String username) {
		boolean nameExists = false;
		for (User user : userList) {
			if (user.getUsername().toLowerCase().equals(username.toLowerCase())) {
				nameExists = true;
				break;
			}
		}
		if (!nameExists) {
			currentUser = new User(username.toLowerCase(), getAccountId(accountList));
			userList.add(currentUser);
			accountList.add(new Account(currentUser.getUsername(), currentUser.getAccountID()));
			System.out.println(username + " username created.");
			menu1();
			writeData();
		} else {
			System.out.println("Username already exists. Please enter a new one.");
			createUser(scanner.next().replaceAll("[^a-zA-Z0-9]", ""));
		}
	}

	public void login(String username) {
		boolean nameExists = false;
		for (User user : userList) {
			if (user.getUsername().toLowerCase().equals(username.toLowerCase())) {
				currentUser = user;
				nameExists = true;
			}
		}
		if (!nameExists) {
			System.out.println("Username invalid.");
			login(scanner.next());
		} else {
			menu2();
		}
	}

	private int getAccountId(ArrayList<Account> accountList) {
		if (accountList.isEmpty())
			return 0;

		for (int i = 0; i < accountList.size(); i++) {

			if (accountList.get(i).getAccountID() != i) {
				return i;
			}
		}
		return accountList.size();
	}

	public void checkData() {
		try {
			FileInputStream userListFileInputStream = new FileInputStream(dir + "/bin/project0/raw/userlist.txt");
			ObjectInputStream userListObjectInputStream = new ObjectInputStream(userListFileInputStream);
			userList = (ArrayList) userListObjectInputStream.readObject();
			userListObjectInputStream.close();
			userListFileInputStream.close();
			FileInputStream accountListFileInputStream = new FileInputStream(dir + "/bin/project0/raw/accountlist.txt");
			ObjectInputStream accountListObjectInputStream = new ObjectInputStream(accountListFileInputStream);
			accountList = (ArrayList) accountListObjectInputStream.readObject();
			accountListObjectInputStream.close();
			accountListFileInputStream.close();
		} catch (IOException ioe) {
			ioe.printStackTrace();
			return;
		} catch (ClassNotFoundException c) {
			System.out.println("Class not found");
			c.printStackTrace();
			return;
		}
	}

	public void writeData() {
		try {
			File userListFile = new File(dir + "/bin/project0/raw/userlist.txt");
			if (!userListFile.exists()) {
				userListFile.createNewFile();
			}
			FileOutputStream userListFileOutputStream = new FileOutputStream(dir + "/bin/project0/raw/userlist.txt");
			ObjectOutputStream userListObjectOutputStream = new ObjectOutputStream(userListFileOutputStream);
			userListObjectOutputStream.writeObject(userList);
			userListObjectOutputStream.close();
			userListFileOutputStream.close();

			File accountListFile = new File(dir + "/bin/project0/raw/accountlist.txt");
			if (!accountListFile.exists()) {
				accountListFile.createNewFile();
			}
			FileOutputStream accountListFileOutputStream = new FileOutputStream(
					dir + "/bin/project0/raw/accountlist.txt");
			ObjectOutputStream accountObjectOutputStream = new ObjectOutputStream(accountListFileOutputStream);
			accountObjectOutputStream.writeObject(accountList);
			accountObjectOutputStream.close();
			accountListFileOutputStream.close();
		} catch (IOException ioe) {
			ioe.printStackTrace();
		}
	}
}
