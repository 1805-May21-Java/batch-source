package project0.src.main.java;

import java.io.IOException;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.SQLException;
import java.text.DecimalFormat;
import java.util.Locale;
import java.util.Scanner;

import project0.src.main.java.project0.data.AccountDao;
import project0.src.main.java.project0.data.User;
import project0.src.main.java.project0.data.UserDao;
import project0.src.main.java.project0.util.ConnectionUtil;

public class main { 

	private static AccountDao accountDao;
	private static UserDao userDao;
	private static Connection connection;
	private static User currentUser;
	private static boolean validInput;
	private static Scanner scanner = new Scanner(System.in);
	private static int bloop;
	private static double bloops;
	private static DecimalFormat twoDecimal = new DecimalFormat("#0.00");

	public static void main(String[] args) throws IOException, SQLException {
		connection = ConnectionUtil.getConnection();
		currentUser = null;
		accountDao = new AccountDao();
		userDao = new UserDao();
		menu1();
	}

	public static void menu1() throws SQLException {
		while (!validInput) {
			System.out.println("Choose an option:");
			System.out.println("1. Login");
			System.out.println("2. Create Account");
			System.out.println("3. Exit");
			if (scanner.hasNextInt()) {
				bloop = scanner.nextInt();
				if (bloop > 0 && bloop < 4) {
					menu1Select(bloop);
					validInput = true;
				} else {
					System.out.println("Selection is out of range.");
				}
			} else {
				System.out.println("Not a valid input.");
				scanner.next();
			}
		}
	}

	public static void menu2() throws SQLException {
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
					System.out.println("Selection is out of range.");
				}
			} else {
				System.out.println("Not a valid input.");
				scanner.next();
			}
		}
	}

	public static void menu1Select(int choice) throws SQLException {
		validInput = false;
		String tempUsername = "";
		String tempPassword = "";
		switch (choice) {
		case 1:
			System.out.println("Enter a username: ");
			while (scanner.hasNext()) {
				tempUsername = "";
				tempUsername = scanner.next().replaceAll("[^a-zA-Z0-9]", "");
				if (userDao.checkUser(connection, tempUsername)) {
					break;
				}
				System.out.println("Enter a valid username: ");
			}
			currentUser = userDao.getUserByName(connection, tempUsername);
			System.out.println("Enter password for: " + tempUsername);
			while (scanner.hasNext()) {
				tempPassword = "";
				tempPassword = scanner.next();
				if (currentUser.getPassword().equals(tempPassword)) {
					menu2();
					break;
				} else {
					System.out.println("Password incorrect.");
					menu1();
					break;
				}
			}
			break;
		case 2:
			System.out.println("Enter a username (50 characters, Alpha-numeric only): ");
			tempUsername = scanner.next().replaceAll("[^a-zA-Z0-9]", "");
			if (userDao.checkUser(connection, tempUsername)) {
				System.out.println("Username is longer than 50 characters or is invalid. Enter a new one: ");
				while (scanner.hasNext()) {
					tempUsername = "";
					tempUsername = scanner.next().replaceAll("[^a-zA-Z0-9]", "");
					if (!userDao.checkUser(connection, tempUsername)) {
						if (tempUsername.length() <= 50) {
							break;
						}
					}
					System.out.println("Username is longer than 50 characters or is invalid. Enter a new one: ");
				}
			}
			System.out.println("Enter a password (Up to 10 characters): ");
			tempPassword = scanner.next();
			if (tempPassword.length() > 10 || tempPassword.contains(";")) {
				System.out.println("Password is longer than 10 characters or is invalid. Enter a new one: ");
				while (tempPassword.length() > 10 || scanner.hasNext()) {
					tempPassword = "";
					tempPassword = scanner.next();
					if (!tempPassword.contains(";")) {
						if (tempPassword.length() <= 10) {
							break;
						}
					}
					System.out.println("Password is longer than 10 characters or is invalid. Enter a new one: ");
				}
			}
			userDao.createUser(connection, tempUsername, tempPassword, accountDao);
			System.out.println("Account " + tempUsername + " has been created.");
			menu1();
			break;
		case 3:
			String sql = "{call INTEREST(?,?)}";
			CallableStatement cs = connection.prepareCall(sql);
			cs.setLong(1, 2);
			cs.setDouble(2, 1);
			cs.execute();
			connection.close();
			System.exit(0);
			break;
		}
	}

	public static void menu2Select(int choice) throws SQLException {
		validInput = false;
		scanner.useLocale(Locale.US);
		switch (choice) {
		case 1:
			System.out.println("Enter a value to deposit: ");
			while (!validInput) {
				if (scanner.hasNextDouble()) {
					bloops = twoDecimalPlace(scanner.nextDouble());
					accountDao.updateBalance(connection, currentUser.getAccountId(), bloops);
					System.out.println("Deposit of $" + bloops + " succesful.");
					System.out.println(
							"Current balance is: $" + accountDao.getBalance(connection, currentUser.getAccountId()));
					menu2();
					validInput = true;
				} else {
					System.out.println("Not a double.");
					scanner.next();
				}
			}
			menu2();
			break;
		case 2:
			System.out.println("Enter a value to withdraw: ");
			while (!validInput) {
				if (scanner.hasNextDouble()) {
					bloops = twoDecimalPlace(scanner.nextDouble());
					double currentBalance = accountDao.getBalance(connection, currentUser.getAccountId());
					System.out.println(currentBalance);
					if ((currentBalance - bloops) >= 0) {
						accountDao.updateBalance(connection, currentUser.getAccountId(), bloops*-1);
						System.out.println("Withdrawal of $" + bloops + " succesful.");
						System.out.println("Current balance is: " + accountDao.getBalance(connection, currentUser.getAccountId()));
						menu2();
						validInput = true;
					} else {
						 System.out.println("Withdrawal of $"+ bloops + " unsuccessful.");
						 menu2();
						 break;
					}

				} else {
					System.out.println("Not a double.");
					menu2();
					break;
				}

			}
			break;
		case 3:
			 System.out.println("Current balance is: $" + accountDao.getBalance(connection, currentUser.getAccountId()));
			menu2();
			break;
		case 4:
			System.out.println("Logged out.");
			currentUser = null;
			menu1();
			break;
		}
	}

	private static double twoDecimalPlace(double number) {
		return Double.valueOf(twoDecimal.format(number));
	}

}
