import java.util.Scanner;

public class BankAccount {
	
	private String username;
	private String password;
	private double balance;
	
	
	
	public BankAccount() {
		super();
	}

	BankAccount(String username, String password) {
		this.username = username;
		this.password = password;
		this.balance = 0;
	}
	
	BankAccount(String username, String password, double balance) {
		this.username = username;
		this.password = password;
		this.balance = balance;
	}
	
	boolean depositMoney () {
		Scanner sc = new Scanner(System.in);
		double deposit = 0;
		
		System.out.println("Please enter the amount that you would like to deposit");
		try {
			deposit = Double.parseDouble(sc.nextLine());
		} catch(NumberFormatException e) {
			deposit = 0;
		}
		if(deposit <= 0) {
			System.out.println("That is an invalid amount. Deposit not processed.");
			return false;
		}
		this.balance += deposit;
		return true;
	}
	
	boolean withdrawMoney() {
		Scanner sc = new Scanner(System.in);
		double withdrawal = 0;
		
		System.out.println("Please enter the amount that you would like to withdraw");
		try {
			withdrawal = Double.parseDouble(sc.nextLine());
		} catch(NumberFormatException e) {
			withdrawal = 0;
		}
		
		if(withdrawal <= 0) {
			System.out.println("That is an invalid amount. Withdrawal not processed.");
			return false;
		}
		if(withdrawal > balance) {
			System.out.println("You cannot withdraw more than the available balance.");
			return false;
		} 
		this.balance -= withdrawal;
		return true;
	}
	
	void viewBalance() {
		System.out.format("The avaiable balance is $%.2f \n", balance);
	}
	
	
	
	
	protected String getUsername() {
		return username;
	}

	protected String getPassword() {
		return password;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		long temp;
		temp = Double.doubleToLongBits(balance);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		result = prime * result + ((password == null) ? 0 : password.hashCode());
		result = prime * result + ((username == null) ? 0 : username.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		BankAccount other = (BankAccount) obj;
		if (Double.doubleToLongBits(balance) != Double.doubleToLongBits(other.balance))
			return false;
		if (password == null) {
			if (other.password != null)
				return false;
		} else if (!password.equals(other.password))
			return false;
		if (username == null) {
			if (other.username != null)
				return false;
		} else if (!username.equals(other.username))
			return false;
		return true;
	}


	protected String getRecord() {
		return (username + " " + password + " " + balance );
	}
	
	
	
	
}
