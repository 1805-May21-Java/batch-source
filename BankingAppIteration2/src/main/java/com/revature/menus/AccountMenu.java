package com.revature.menus;

import java.util.ArrayList;
import java.util.List;

import com.revature.actors.Teller;
import com.revature.dao.AccountDaoImpl;
import com.revature.dao.JointAccountDaoImpl;
import com.revature.dao.TransactionDaoImpl;
import com.revature.dao.UserDaoImpl;
import com.revature.exceptions.NoSuchOptionException;
import com.revature.pojos.Account;
import com.revature.pojos.Transaction;
import com.revature.pojos.User;
import com.revature.util.BankScanner;
import com.revature.util.FormatMoney;
import com.revature.util.GeneralConfirmation;

public class AccountMenu implements Menu{
	private UserDaoImpl udi;
	private AccountDaoImpl adi;
	private JointAccountDaoImpl jadi;
	private TransactionDaoImpl tdi;
	private BankScanner scan;
	private Teller myTeller;
	private User currentUser;
	private List<Account> userAccounts;
	
	public AccountMenu(Teller myTeller) {
		super();
		this.udi = new UserDaoImpl();
		this.adi = new AccountDaoImpl();
		this.jadi = new JointAccountDaoImpl();
		this.tdi = new TransactionDaoImpl();
		this.scan = BankScanner.getInstance();
		this.myTeller = myTeller;
		this.currentUser = new User();
		this.userAccounts = new ArrayList<Account>();
	}

	public boolean navigate() {		
		boolean finishedWithMenu = false;
		do {
			System.out.println("What would you like to do?\n"
							 + "    (1) Access an account\n"
							 + "    (2) Open new account\n"
							 + "    (3) Add existing user to one of your accounts\n"
							 + "Enter 1, 2, or 3. Enter 0 to log out");
			String option = scan.next();
			try {
				switch(Integer.parseInt(option)) {
				case 0: 
					return false;
				case 1:
					finishedWithMenu = accessAccount();
					break;
				case 2:
					finishedWithMenu = openAccount();
					break;
				case 3:
					finishedWithMenu = joinAccount();
					break;
				default:
					throw new NoSuchOptionException();
				}
			} catch (NumberFormatException e) {
				// If the string can't parse into an integer, this is displayed
				System.out.println("Sorry, we couldn't read that. Please try again.\n");
			} catch (NoSuchOptionException e) {
				// If the user inputs an invalid option, this is displayed 
				System.out.println("Sorry, that wasn't an option. Please try again.\n");
			}
		} while (!finishedWithMenu);
		return true;
	}
	
	private boolean accessAccount() {
		this.currentUser = this.udi.getUserById(myTeller.getCurrentUsersId());
		this.userAccounts = this.adi.getAccountsByUser(this.currentUser.getUserId());
		
		if(userAccounts.isEmpty()) {
			System.out.println("Looks like you haven't opened an account yet.");
			return openAccount();
		}
		
		String acctString;
		long acctNumber;
		boolean picked;
		do {
			System.out.println("Here are your accounts: ");
			for(Account a : this.userAccounts) {
				System.out.println("    " + a.getAccountNumber());
			}
			System.out.println("Enter the account number you wish to access: ");

			picked = false;
			try {
				acctString = scan.next();
				acctNumber = Long.parseLong(acctString);
				
				for(Account a: this.userAccounts) {
					if(acctNumber == a.getAccountNumber()) {
						picked = true;
						this.myTeller.setCurrentUserAccount(acctNumber);
						break;
					}
				}	
			} catch (NumberFormatException e) {
				System.out.println("Sorry, we couldn't read that.");
			}
			
			if(!picked) {
				System.out.println("Sorry, that wasn't one of your account numbers.");
				boolean cont = GeneralConfirmation.check("Would you like to try choosing an account again?");
				if(cont == false) {
					return false;
				}
			}
		} while (!picked);
		return true;		
	}
	
	private boolean openAccount() {
		this.currentUser = this.udi.getUserById(myTeller.getCurrentUsersId());
		boolean makeNew = GeneralConfirmation.check("Do you really wish to open a new account?");
		if (makeNew) {
			adi.createAccount(new Account(0), currentUser.getUserId());
			System.out.println("Account created!");
			return accessAccount();
		} else {
			return false;
		}				
	}
	
	private boolean joinAccount() {
		this.currentUser = this.udi.getUserById(myTeller.getCurrentUsersId());
		this.userAccounts = this.adi.getAccountsByUser(currentUser.getUserId());
		
		List<User> myUsers = this.udi.getUsers();
		String linkedUser = "ADMIN";
		int linkedUserId = 1;
		long linkedAccount = 100000000;
		
		boolean userPicked;
		do {
			System.out.println("Enter the username of the person you want to link with one of your accounts: ");
			userPicked = false;
			
			linkedUser = scan.next().toUpperCase();
			for(User u : myUsers) {
				if(linkedUser.equals(u.getUsername())) {
					linkedUserId = u.getUserId();
					userPicked = true;
					break;
				}
			}
			if(!userPicked) {
				System.out.println("Sorry the user \"" + linkedUser +"\" doesn't exist");
				boolean cont = GeneralConfirmation.check("Would you like to try choosing a different user to link with?");
				if(cont == false) {
					return false;
				}
			}			
		} while (!userPicked);
		
		boolean accountPicked;
		do {
			System.out.println("Here are your accounts: " );
			for(Account a : userAccounts) {
				System.out.println("    " + a.getAccountNumber() + "    Balance: $" + FormatMoney.print(a.getBalance()));
			}
			System.out.println("Which one would you like to link with " + linkedUser + "?");
			
			accountPicked = false;
			try {
				linkedAccount = Long.parseLong(scan.next());
				
				for(Account a : this.userAccounts) {
					if(linkedAccount == a.getAccountNumber()) {
						accountPicked = true;
						break;
					}
				}
			} catch (NumberFormatException e) {
				System.out.println("Sorry, we couldn't read that.");
			}
			if(!accountPicked) {
				System.out.println("Sorry, that's not one of your accounts.");
				boolean cont = GeneralConfirmation.check("Would you like to choose a different account to link with " + linkedUser + "?");
				if(cont == false) {
					return false;
				}
			}
		} while(!accountPicked);
		
		
		jadi.joinAccountToNewUser(linkedAccount, linkedUserId);
		tdi.createTransaction(new Transaction(linkedAccount, linkedUser + " was joined to this account."));
		System.out.println(linkedUser + " was joined to your account, " + linkedAccount + ".");		
		return false;
	}
}


