package com.revature.pojos;

//Account is created to simulate individual bank accounts
//Member variables include Strings username and password, 
//doubles checking and savings which will be accessed once user
//logs on to account. The boolean userLoggedOn will be used
//to ensure that user is still carrying out actions on their indivial
//account.
public class Account implements AccountActions{
	
	private String username;
	private String password;
	private double checking;
	private double savings;
	private boolean userLoggedOn;

	//The constructor will be used when reading from the text file
	//Using the data at each line to construct a new Account object
	public Account(String username, String password, double checking, double savings) {
		super();
		this.username = username;
		this.password = password;
		this.checking = checking;
		this.savings = savings;
	}

	//Getters and Setters for member variables have been created.
	//only userLoggedOn has a getter but not a setter, to restrict
	//setting access to only methods logOn() and logOff()
	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public double getChecking() {
		return checking;
	}

	public void setChecking(double checking) {
		this.checking = checking;
	}

	public double getSavings() {
		return savings;
	}

	public void setSavings(double savings) {
		this.savings = savings;
	}
	
	public boolean isUserLoggedOn() {
		return userLoggedOn;
	}

	//depositFunds takes in a double amount, for the money user wants to deposit,
	//and String checkingOrSavings, to store that money.
	@Override
	public void depositFunds(double amount, String checkingOrSavings) {
		//This returns if amount is less than or equal to zero
		if(amount <= 0) {
			System.out.println("Error, must input an amount greater than zero.");
			return;
		}
		
		//if and else if checks if String checkingOrSavings is equal to
		//"Savings or "Checking" ignoring String case.
		if(checkingOrSavings.equalsIgnoreCase("Savings")) {
			//adds amount to savings variable and prints a statement
			//of the deposit.
			this.savings += amount;
			System.out.println("Deposited $" + amount + " to Savings.");
		}else if(checkingOrSavings.equalsIgnoreCase("Checking")) {
			//adds amount to checking variable and prints a statement
			//of the deposit
			this.checking += amount;
			System.out.println("Deposited $" + amount + " to Checking.");
		}else {
			//Prints a statement that checkingOrSavings was not a valid input
			System.out.println("Error, you did not specify the correct account type.");
		}
	}
	
	//withdrawFunds takes in a double amount, for the money user wants to withdraw,
	//and String checkingOrSavings, to remove that money.
	@Override
	public void withDrawFunds(double amount, String checkingOrSavings) {
		//This returns if amount is less than or equal to zero
		if(amount <= 0) {
			System.out.println("Error, must input an amount greater than zero.");
			return;
		}
		
		
		//if and else if checks if String checkingOrSavings is equal to
		//"Savings or "Checking" ignoring String case.
		if(checkingOrSavings.equalsIgnoreCase("Savings")) {
			//Checks if withdrawal will result in a negative balance, returns if true.
			if((this.getSavings() - amount) < 0) {
				System.out.println("Withdrawal denied. Can only withdraw available amount in Savings.");
				return;
			}
			//subtracts amount from savings variable and prints a statement
			//of the withdrawal.
			this.savings -= amount;
			System.out.println("Withdrew $" + amount + " from Savings.");
		}else if(checkingOrSavings.equalsIgnoreCase("Checking")) {
			//Checks if withdrawal will result in a negative balance, returns if true.
			if((this.getChecking() - amount) < 0 ) {
				System.out.println("Withdrawal denied. Can only withdraw available amount in Checking.");
				return;
			}
			//subtracts amount from checking variable and prints a statement
			//of the withdrawal.
			this.checking -= amount;
			System.out.println("Withdrew $" + amount + " from Checking.");
		}else {
			//Prints a statement that checkingOrSavings was not a valid input
			System.out.println("Error, you did not specify the correct account type.");
		}
	}

	//viewBalance allows the user to view the status of their account,
	//specifically amount of money in Checking and Savings
	@Override
	public void viewBalance() {
		System.out.println("Now viewing balance in " + this.username + "'s account:");
		System.out.println("Checking: $" + this.getChecking());
		System.out.println("Savings: $" + this.getSavings());
	}

	@Override
	public String toString() {
		return "Account [username=" + username + ", password=" + password + ", checking="
				+ checking + ", savings=" + savings + "]";
	}

	//Method sets userLoggedOn to true
	@Override
	public void logOn() {
		this.userLoggedOn = true;
	}

	//Method sets userLoggedOn to false
	@Override
	public void logOff() {
		this.userLoggedOn = false;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		long temp;
		temp = Double.doubleToLongBits(checking);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		result = prime * result + ((password == null) ? 0 : password.hashCode());
		temp = Double.doubleToLongBits(savings);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		result = prime * result + (userLoggedOn ? 1231 : 1237);
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
		Account other = (Account) obj;
		if (Double.doubleToLongBits(checking) != Double.doubleToLongBits(other.checking))
			return false;
		if (password == null) {
			if (other.password != null)
				return false;
		} else if (!password.equals(other.password))
			return false;
		if (Double.doubleToLongBits(savings) != Double.doubleToLongBits(other.savings))
			return false;
		if (userLoggedOn != other.userLoggedOn)
			return false;
		if (username == null) {
			if (other.username != null)
				return false;
		} else if (!username.equals(other.username))
			return false;
		return true;
	}

	

}
