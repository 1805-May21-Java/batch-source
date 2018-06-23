package com.revature.menus;

import java.util.ArrayList;
import java.util.List;

import com.revature.actors.Teller;
import com.revature.dao.AccountDaoImpl;
import com.revature.dao.TransactionDaoImpl;
import com.revature.dao.UserDaoImpl;
import com.revature.exceptions.NegativeNumberException;
import com.revature.exceptions.NoSuchOptionException;
import com.revature.pojos.Account;
import com.revature.pojos.Transaction;
import com.revature.pojos.User;
import com.revature.utils.*;

public class TransactionMenu implements Menu{
	private UserDaoImpl udi;
	private AccountDaoImpl adi;
	private TransactionDaoImpl tdi;
	private Teller myTeller;
	private BankScanner scan;
	private User currentUser;
	private Account currentAccount;
	private List<Account> userAccounts;
	
	public TransactionMenu(Teller myTeller) {
		super();
		this.udi = new UserDaoImpl();
		this.adi = new AccountDaoImpl();
		this.tdi = new TransactionDaoImpl();
		this.myTeller = myTeller;
		scan = BankScanner.getInstance();
		this.currentUser = new User();
		this.currentAccount = new Account();
		this.userAccounts = new ArrayList<Account>();
	}

	public boolean navigate() {
		this.currentUser = this.udi.getUserById(myTeller.getCurrentUsersId());
		this.userAccounts = this.adi.getAccountsByUser(this.currentUser.getUserId());
		this.currentAccount = this.adi.getAccountByNumber(myTeller.getCurrentUserAccount());
		
		if(this.currentAccount.getUsers().size()>1) {
			System.out.print("This is a joint account between: ");
			for(User user : this.currentAccount.getUsers()) {
				System.out.print(user.getUsername() + " ");
			}
			System.out.print("\n");
		}
		
		boolean finishedWithMenu = false;
		do {
			System.out.println("What would you like to do?\n"
					 + "    (1) Withdraw\n"
					 + "    (2) Deposit\n"
					 + "    (3) Transfer Funds\n"
					 + "    (4) View Balance\n"
					 + "    (5) View Recent Transaction History\n"
					 + "    (6) View Full Transaction History\n"
					 + "    (7) Go back to your accounts menu\n"
					 + "Enter 1, 2, 3, 4, 5, 6, or 7. Enter 0 to back to log out");
			String option = scan.next();
			try {
				switch(Integer.parseInt(option)) {
				case 0: 
					return false;
				case 1:
					withdraw();
					break;
				case 2:
					deposit();
					break;
				case 3:
					transferFunds();
					break;
				case 4: 
					viewBalance();
					break;
				case 5:
					viewTransactions(false, 10);
					break;
				case 6:
					viewTransactions(true, 0);
					break;
				case 7:
					finishedWithMenu = true;
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
	
	private boolean withdraw() {
		this.currentUser = this.udi.getUserById(myTeller.getCurrentUsersId());
		this.currentAccount = this.adi.getAccountByNumber(myTeller.getCurrentUserAccount());
		
		double amount;
		boolean validWithdrawl = false;
		do {
			try {
				viewBalance();
				System.out.println("How much would yo like to withdraw? ");
				amount = FormatMoney.format(Double.parseDouble(scan.next()));
				
				if(this.currentAccount.getBalance() -  amount < 0) {
					throw new NegativeNumberException();
				} else {
					this.currentAccount.setBalance(this.currentAccount.getBalance() - amount);
					this.adi.updateAccount(this.currentAccount);
					this.tdi.createTransaction(new Transaction(this.currentAccount, 
															  "$" + FormatMoney.print(amount) + " withdrawn by " + this.currentUser.getUsername()));
					System.out.println("$" + FormatMoney.print(amount) + " withdrawn."); 
					viewBalance();
					validWithdrawl = true;
				}
			} catch (NumberFormatException e){
				System.out.println("Sorry, we couldn't read that.");
			} catch (NegativeNumberException e) {
				System.out.println("Sorry, you can't withdraw more than your balance.");
			}
			
			if(!validWithdrawl) {
				boolean cont = GeneralConfirmation.check("Would you like to try again?");
				if(cont == false) {
					return false;
				}
			}
		} while (!validWithdrawl);		
		return true;
	}
	
	private boolean deposit() {
		this.currentUser = this.udi.getUserById(myTeller.getCurrentUsersId());
		this.currentAccount = this.adi.getAccountByNumber(myTeller.getCurrentUserAccount());
		
		double amount;
		boolean validDeposit = false;
		do {
			try {
				System.out.println("How much would you like to deposit?");
				amount = FormatMoney.format(Double.parseDouble(scan.next()));
				if(amount < 0) {
					throw new NegativeNumberException();
				} else if (this.currentAccount.getBalance() + amount > 999999999.99) {
					throw new Exception();
				} else {
					this.currentAccount.setBalance(this.currentAccount.getBalance() + amount);
					this.adi.updateAccount(this.currentAccount);
					this.tdi.createTransaction(new Transaction(this.currentAccount,
															   "$" + FormatMoney.print(amount) + " deposited by " + this.currentUser.getUsername()));
					System.out.println("$" + FormatMoney.print(amount) + " deposited.");
					viewBalance();
					validDeposit = true;
				}
			} catch (NumberFormatException e){
				System.out.println("Sorry, we couldn't read that.");
			} catch (NegativeNumberException e) {
				System.out.println("Sorry, you can't deposit more than you have in your account.");
			} catch (Exception e) {
				System.out.println("Sorry, currently we can't hold more than $999,999,999.99 in an account.");
			}
			
			if(!validDeposit) {
				boolean cont = GeneralConfirmation.check("Would you like to try again?");
				if(cont == false) {
					return false;
				}
			}
		} while (!validDeposit);
		return true;
	}
	
	private boolean transferFunds() {
		this.currentUser = this.udi.getUserById(myTeller.getCurrentUsersId());
		this.userAccounts = this.adi.getAccountsByUser(this.currentUser.getUserId());
		this.currentAccount = this.adi.getAccountByNumber(myTeller.getCurrentUserAccount());
		
		if(this.userAccounts.size() < 2) {
			System.out.println("You don't have another account to transfer to.");
			return false;
		}
		
		long acct = 1000000000;
		boolean userPicked = false;
		do {
			try {
				System.out.println("Here are your other account(s): ");
				for(Account a : this.userAccounts) {
					if(this.currentAccount.getAccountNumber() != a.getAccountNumber()) {
						System.out.println("    " + a.getAccountNumber() + " Balance: $" + FormatMoney.print(a.getBalance()));
					}
				}
				System.out.println("Which account would you like to transfer to?");
				userPicked = false;
				
				acct = Long.parseLong(scan.next());
				for(Account a: this.userAccounts) {
					if(acct == a.getAccountNumber() && this.currentAccount.getAccountNumber() != a.getAccountNumber()) {
						userPicked = true;
						break;
					}
				}
				
				if(!userPicked) {
					System.out.println("Sorry, " + acct + " is not an account you can access.");
				}
			}catch (NumberFormatException e){
				System.out.println("Sorry, we couldn't read that.");
			}
			if(!userPicked) {
				boolean cont = GeneralConfirmation.check("Would you like to try a different account to transfer to?");
				if (cont == false) {
					return false;
				}
			}
		}while (!userPicked);
		
		double amount;
		boolean validTransfer = false;
		do {
			try {
				viewBalance();
				System.out.println("How much would you want to transfer to account #" + acct + "?");
				Account transferedTo  = this.adi.getAccountByNumber(acct);
				amount = FormatMoney.format(Double.parseDouble(scan.next()));
				if(amount < 0) {
					throw new NegativeNumberException();
				} else if (transferedTo.getBalance() + amount > 999999999.99) {
					throw new Exception();
				} else {
					this.currentAccount.setBalance(this.currentAccount.getBalance() - amount);
					transferedTo.setBalance(transferedTo.getBalance() + amount);
					this.adi.updateAccount(this.currentAccount);
					this.adi.updateAccount(transferedTo);
					this.tdi.createTransaction(new Transaction( this.currentAccount,
																"$" + FormatMoney.print(amount) + " transfered out to account #" + acct + " by " + this.currentUser.getUsername()));
					this.tdi.createTransaction(new Transaction( adi.getAccountByNumber(acct),
																"$" + FormatMoney.print(amount) + " transfered in from account #" + this.currentAccount.getAccountNumber() + " by " + this.currentUser.getUsername()));
					System.out.println("$" + FormatMoney.print(amount) + " transfered to " + acct + ".");
					viewBalance();
					validTransfer = true;
				}
			} catch (NumberFormatException e){
				System.out.println("Sorry, we couldn't read that.");
			} catch (NegativeNumberException e) {
				System.out.println("Sorry, you can't transfer out more than you have in your account.");
			} catch (Exception e) {
				System.out.println("Sorry, currently we can't hold more than $999,999,999.99 in an account.");
			}
			
			if(!validTransfer) {
				boolean cont = GeneralConfirmation.check("Would you like to try again?");
				if(cont == false) {
					return false;
				}
			}
		} while (!validTransfer);
		return true;
	}
	
	private boolean viewBalance() {
		this.currentAccount = this.adi.getAccountByNumber(myTeller.getCurrentUserAccount());
		
		double amount = this.currentAccount.getBalance();
		System.out.println("You have a balance of $" + FormatMoney.print(amount));
		return true;
	}
	
	private boolean viewTransactions(boolean all, int limit) {
		this.currentAccount = this.adi.getAccountByNumber(myTeller.getCurrentUserAccount());
		List<Transaction> transactionList;
		if(all) {
			transactionList = tdi.getAccountTransactions(this.currentAccount.getAccountNumber());
		} else {
			transactionList = tdi.getAccountTransactions(this.currentAccount.getAccountNumber(), limit);
		}
		
		System.out.println("\nAccout #" + this.currentAccount.getAccountNumber() + "\'s Transaction History: \n");
		for(Transaction t : transactionList) {
			System.out.println(t.getTransactionDate() + " | " + t.getDescription());
		}
		System.out.println("\n");
		
		return true;
	}

}
