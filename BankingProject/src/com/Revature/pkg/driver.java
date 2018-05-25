package com.Revature.pkg;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.text.NumberFormat;
import java.util.Scanner;

import javax.swing.text.NumberFormatter;

public class driver {
	public static boolean writeBank(String path, Bank b) {
		File file = new File(path);
		if (!file.exists()) {
			try {
				file.createNewFile();
			} catch (IOException e) {
				return false;
			}
		}

		try (FileOutputStream fw = new FileOutputStream(file); ObjectOutputStream os = new ObjectOutputStream(fw);) {
			os.writeObject(b);
		} catch (Exception e) {
			return false;
		}
		return true;
	}

	public static Bank readBank(String path) {
		Bank b = null;
		try (FileInputStream fr = new FileInputStream(path); ObjectInputStream os = new ObjectInputStream(fr);) {

			b = (Bank) os.readObject();
		} catch (Exception e) {
			return null;
		}

		return b;
	}

	public static void printCmds() {
		System.out.println("create\t\tCreate an account");
		System.out.println("login\t\tLog into an existing account");
		System.out.println("logout\t\tLog out of current account");
		System.out.println("deposit\t\tDeposit funds into current account");
		System.out.println("withdraw\tWithdraw funds from current account");
		System.out.println("balance\t\tView your current balance");
		System.out.println("quit\t\tTo quit the application");
		System.out.println("help\t\tDisplays this message");
	}

	public static Client login(Scanner sc, Client c, Bank b) {
		if (c != null) {
			System.out.println("You are already logged in");
			return null;
		}

		System.out.print("Username: ");
		String username = sc.nextLine();

		Client newC = b.login(username);
		if (newC == null) {
			System.out.println("Login failed");
		} else {
			System.out.println("Login success");
		}

		return newC;
	}

	public static void logout(Client c) {
		if (c == null) {
			System.out.println("You are not logged in");
		} else {
			System.out.println("Logged out");
		}
	}

	public static Client createAccount(Scanner sc, Client c, Bank b) {
		if (c != null) {
			System.out.println("You are already logged in");
			return c;
		}

		System.out.print("New Username: ");
		String username = sc.nextLine();

		Client newC = b.createUser(username);

		if (newC == null) {
			System.out.println("Creation failed");
		} else {
			System.out.println("Creation success");
		}
		return newC;
	}

	public static void deposit(Scanner sc, Client c, Bank b) {
		if (c == null) {
			System.out.println("You are not logged in");
			return;
		}

		System.out.print("Enter amount to deposit: ");
		String amount = sc.nextLine();

		try {
			boolean resp = b.deposit(c, Float.parseFloat(amount));
			if (resp) {
				System.out.println("Deposit Success");
			} else {
				System.out.println("Deposit Failure");
			}
		} catch (NumberFormatException e) {
			System.out.println("Invalid input");
		}
	}

	public static void withdraw(Scanner sc, Client c, Bank b) {
		if (c == null) {
			System.out.println("You are not logged in");
			return;
		}

		System.out.print("Enter amount to withdraw: ");
		String amount = sc.nextLine();

		try {
			boolean resp = b.withdraw(c, Float.parseFloat(amount));
			if (resp) {
				System.out.println("Withdraw Success");
			} else {
				System.out.println("Withdraw Failure");
			}
		} catch (NumberFormatException e) {
			System.out.println("Invalid input");
		}
	}

	public static void balance(Client c) {
		if (c == null) {
			System.out.println("You are not logged in");
		} else {
			System.out.println("Current balance: " + NumberFormat.getCurrencyInstance().format(c.getMoney()));
		}
	}

	public static void main(String args[]) {
		Bank b = null;
		String path = ".\\content";
		b = readBank(path);
		if (b == null) {
			b = new Bank();
		}

		Scanner sc = new Scanner(System.in);
		Client currentClient = null;

		printCmds();
		while (true) {
			System.out.println();
			String cmd = sc.nextLine();

			switch (cmd) {
			case "quit":
				return;
			case "help":
				printCmds();
				break;
			case "create":
				currentClient = createAccount(sc , currentClient , b);
				break;
			case "login":
				currentClient = login(sc, currentClient, b);
				break;
			case "logout":
				logout(currentClient);
				currentClient = null;
				break;
			case "deposit":
				deposit(sc, currentClient, b);
				break;
			case "withdraw":
				withdraw(sc, currentClient, b);
				break;
			case "balance":
				balance(currentClient);
				break;
			default:
				System.out.println("Invalid input");
			}
			writeBank(path,b);
		}
	}
}
