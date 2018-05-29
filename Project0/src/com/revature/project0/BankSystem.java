package com.revature.project0;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.Scanner;

public class BankSystem {


	ArrayList<User> users;
	ArrayList<Account> accounts;
	
	public BankSystem() {
		super();
		this.users = new ArrayList();
		this.accounts = new ArrayList();
	}

	public BankSystem(ArrayList users, ArrayList accounts) {
		super();
		this.users = users;
		this.accounts = accounts;
	}
	
	public void addUser(User u) {
		
		this.users.add(u);
	}
	
	public void addAccount(Account a) {
		this.accounts.add(a);
	
	}
	
	public void checkBalance(Account a) {
		
		System.out.println("Balance: " + a.getBalance());
		
	}

	public void depositMoney(Account a, int m) {
		
		System.out.println("Adding: " + m + " dollars, current balance: " + a.getBalance());

		a.setBalance(a.getBalance()+m);

		System.out.println("Balance after deposit: " + a.getBalance());

		
	}
	
	public void withDrawMoney(Account a, int m) {
		
		if(a.getBalance()>m) {

			a.setBalance(a.getBalance()-m);
			System.out.println("Issueing: " + m + " dollars");
			System.out.println("Balance: " + a.getBalance());
		}
		else {

			System.out.println("Failed withdrawal, no money issued: ");
			System.out.println("Balance: " + a.getBalance());
			
		}
		
	}

	public void addAccount() {
		
        Scanner sc1 = new Scanner(System.in);
        String [] arrOfStr;
		System.out.println("Enter account info (balance($,double),accountid(int),pw(String): ");
		System.out.println("Enter 3 to finish adding accounts");
		String input = sc1.nextLine();

        while (Integer.parseInt(sc1.nextLine())!=3) {
            if (Integer.parseInt(sc1.nextLine())!=0) {
				System.out.println("Entered 0");
				System.exit(0);
            }
    		System.out.println("Enter account info (balance($,double),account(int),pw(String): ");
    		System.out.println("Enter 3 to finish adding accounts");
    		System.out.println("Enter 0 to exit");
            input = sc1.nextLine();
            arrOfStr = input.split(",");
            System.out.println("arr[0]:"+arrOfStr[0]+" arr[1]: "+arrOfStr[1]+" arr[2]: "+arrOfStr[2]);

            this.addAccount(new Account(Double.parseDouble(arrOfStr[3]),arrOfStr[1],arrOfStr[2]));

        }
        
        System.out.println("Finished adding bank system account data");

        sc1.close();		
	}

	public void addUser() {
        Scanner sc1 = new Scanner(System.in);
        String [] arrOfStr;
		System.out.println("Enter user info (email(String),pw(String): ");
		System.out.println("Entered 3 to finish adding accounts");
		System.out.println("Enter 0 to exit");

		String input = sc1.nextLine();

        while (Integer.parseInt(sc1.nextLine())!=3) {
            if (Integer.parseInt(sc1.nextLine())!=0) {
				System.out.println("Entered 0");
				System.exit(0);
            }
    		System.out.println("Enter user info (email(String),pw(String): ");
    		System.out.println("Enter 3 to finish adding users");
    		System.out.println("Enter 0 to exit");

            input = sc1.nextLine();
            arrOfStr = input.split(",");
            System.out.println("arr[0]:"+arrOfStr[0]+" arr[1]: "+arrOfStr[1]);

            this.addUser(new User(arrOfStr[0],arrOfStr[1]));
            
            
        }
        System.out.println("Finished adding bank system user data");
        sc1.close();		
	}
	
	
	public int userSize() {
		if(users!=null) {
			return users.size();

		}
		else {
			return 0;
		}
	}

	public int accountSize() {
		if(accounts!=null) {
			return accounts.size();

		}
		else {
			return 0;
		}	
	}

	public boolean verifyPassword(String user,String pw) {

		for(User u: users) {
			if(u.getEmail().equals(user)&&u.getPassword().equals(pw)) {
				System.out.println("Success!");
				return true;
			}
		}
		return false;

	}
	
	public Account findAcct(String email) {
		Iterator i = accounts.iterator();
		while(i.hasNext()) {
			if(i.next().equals(email)) {
				return (Account) i.next();
			}
			
		}
		return null;
	
	}
}
