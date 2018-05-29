package com.revature.Bank;

	import java.io.File;
	import java.io.IOException;
	import java.util.Scanner;
	import java.util.StringTokenizer;

	public class BankAccount {
		private String email;
		private String username;
		private double balance;

		

		public BankAccount() {
			super();
			// TODO Auto-generated constructor stub
		}



		public BankAccount(String email, String username, double balance) {
			super();
			this.email = email;
			this.username = username;
			this.balance = balance;
		}
		
		

		public void deposit(double amount) { // add amount
			balance += amount;
		}

		public void withdraw(double amount) { // amount that needs to be withdraw
			if (amount <= balance) { // validation
				balance = balance - amount;

			} else

				System.err.println("Insufficient Fund : you cannot withdraw");// this will cancel the transaction cancel
		}

		// public static double getBalance() { // this will return balance
		// return balance;
		// }
		public void viewBalance() {
			System.out.println("you have balance of  $ " + balance); // display the balance
		}



		public static BankAccount login() throws IOException {

			Scanner sc = new Scanner(System.in);
			String email, username;
			System.out.println("enter email");
			email = sc.nextLine();
			System.out.println("enter username");
			username = sc.nextLine();
			String reademail = null;
			String readusername = null;
			//String path = "src/ProjectZero/Login.txt";
			Scanner loginFile;
			String loginData;
			//String fileName = "src/com/revature/BankProject/Login.txt";

			loginFile = new Scanner(new File("Login.txt")); // read file from the scanner
			do {
				loginData = loginFile.nextLine();
				StringTokenizer delimitedTokens = new StringTokenizer(loginData, ":");
				while (delimitedTokens.hasMoreTokens()) {
					reademail = delimitedTokens.nextToken();
					readusername = delimitedTokens.nextToken();
				}

			} while (loginFile.hasNext());
			loginFile.close();
			//System.out.println(reademail);
			//System.out.println(readusername);

			if (email.equals(reademail) & username.equals(readusername)) {
				System.out.println("login successfully");
				//BankAccount bk = new BankAccount(reademail, readusername, 0);
				//return bk;
			
		} else {
				System.out.println("invalid credential");
				sc.close();
			}
	       return null;
		}

		@Override
		public String toString() {
			return "BankAccount [email=" + email + ", username=" + username + ", balance=" + balance + "]";
		}

		@Override
		public int hashCode() {
			final int prime = 31;
			int result = 1;
			long temp;
			temp = Double.doubleToLongBits(balance);
			result = prime * result + (int) (temp ^ (temp >>> 32));
			result = prime * result + ((email == null) ? 0 : email.hashCode());
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
			if (email == null) {
				if (other.email != null)
					return false;
			} else if (!email.equals(other.email))
				return false;
			if (username == null) {
				if (other.username != null)
					return false;
			} else if (!username.equals(other.username))
				return false;
			return true;
		}

		

	}


