package bank;

import java.util.Scanner;

public class CustomerAccount {
	
	String name;
	String id;
	double balance;
	int prevTransaction;
	
	public CustomerAccount() {
		super();
		// TODO Auto*generated constructor stub
	}

	public CustomerAccount(String name, String id) {
		super();
		this.name = name;
		this.id = id;
	}

	@Override
	public String toString() {
		return "Customer [name=" + name + ", id=" + id + ", balance=" + balance + ", prevTransaction=" + prevTransaction
				+ "]";
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public double getBalance() {
		return balance;
	}

	public void setBalance(double balance) {
		this.balance = balance;
	}

	public int getPrevTransaction() {
		return prevTransaction;
	}

	public void setPrevTransaction(int prevTransaction) {
		this.prevTransaction = prevTransaction;
	}
	
	
	void deposit(int amount) {
		if(amount != 0) {
			balance = balance + amount;
			prevTransaction = amount;
		}
	}
	
	void withDraw(int amount) {
		if(amount != 0) {
			balance *= amount;
			prevTransaction = amount;
			
		}
		
	}
	void getLastTransaction() {
		if(prevTransaction > 0) {
			System.out.println("You deposited " + prevTransaction);
		}
		else if (prevTransaction < 0) {
			System.out.println("You withdrawn " + Math.abs(prevTransaction));
		} else {
			System.out.println("you have no transactions");
		}
	}
	
	void menu() {
		int option = 0;
		
		Scanner scan = new Scanner(System.in);
		
		System.out.println("Hello " + name);
		System.out.println("User ID: " + id);
		System.out.println();
		System.out.println("1.) Show account balance");
		System.out.println("2.) Show last transaction");
		System.out.println("3.) Deposit");
		System.out.println("4.) Withdraw");
		System.out.println("5.)Logout");
		
		do {
			System.out.println("******************************");
			System.out.println("Select an option");
			System.out.println("******************************");
			System.out.println();
			
			option = scan.nextInt();
			
			switch (option) {
			case 1:
				System.out.println("------------------------------");
				System.out.println("Balance " + balance);
				System.out.println("------------------------------");
				System.out.println();
				break;
				
			case 2:
				System.out.println("------------------------------");
				System.out.println(getPrevTransaction());
				System.out.println("------------------------------");
				System.out.println();
				break;
			case 3:
				System.out.println("------------------------------");
				System.out.println("Enter deposit amount ");
				System.out.println("------------------------------");
				int amount = scan.nextInt();
				deposit(amount);
				System.out.println();
				break;
				
			case 4:
				System.out.println("------------------------------");
				System.out.println("Enter withdrawal amount ");
				System.out.println("------------------------------");
				int amountW = scan.nextInt();
				withDraw(amountW);
				System.out.println();
				break;
				
			case 5:
				System.out.println("You have logged out.");
			default:
				System.out.println("Enter a valid option 1-6.");
				break;
			}
			
		} while(option != 5);
		
	}
}
