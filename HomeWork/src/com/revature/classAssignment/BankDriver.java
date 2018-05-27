package com.revature.classAssignment;

import java.util.Scanner;

public class BankDriver {

	public static void main(String[] args) {
		Scanner user = new Scanner(System.in);
		BankAccount cashAccount = new BankAccount("ND", "aaa@gmail.com", 100);
		cashAccount.depositBalance(500);
		cashAccount.withdrawBalance(2);
		cashAccount.viewBalance(cashAccount.getBalance());

		System.out.println("what do you want to do ?");
		System.out.println("enter 1 for deposit, 2 for withdraw, 3 for viewbalance, 4 for logout");
		int choice = user.nextInt();// taking user input from the scanner
		boolean exit = false; // if you logout it will exit the loop
		do {
			if (choice == 1) {
				System.out.println("how much do you like to deposit");
			} else if (choice == 2) {
				System.out.println(" how much you like to withdraw");

			} else if (choice == 3) {
				cashAccount.viewBalance(cashAccount.getBalance());
			}else if(choice == 4) {
				System.out.println("user logout from the account ");
				exit = true;
			} else {
				System.out.println(" invalid input ");
			}
		} while (exit);
user.close();
	}

}
