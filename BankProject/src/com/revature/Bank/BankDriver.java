package com.revature.Bank;

import java.io.IOException;
import java.util.Scanner;

public class BankDriver {

		

			public static void main(String[] args) throws IOException {
				Scanner in = new Scanner(System.in);

				//1int userChoice;

				boolean quit = false;

				BankAccount ba = new BankAccount();

				do {

					System.out.println("1. login");

					System.out.println("2. Deposit money");

					System.out.println("3. Withdraw money");
				

					System.out.println("4. Check balance");

					System.out.println("5.  logout: ");
					System.out.println("what would you like to do :: ?");

					 int userChoice = in.nextInt();

					switch (userChoice) {

					case 1:
						BankAccount.login();

						break;

					case 2:

						System.out.println("enter amount for deposit");
						double deposit = in.nextDouble();
						ba.deposit(deposit);
						System.out.print("you have deposited + " + deposit);
						System.out.println();

						break;

					case 3:

						System.out.println("enter amount to withdraw");
						double withdraw = in.nextDouble();
						ba.withdraw(withdraw);
						// System.out.println("you have withdrawn $ " + withdraw);

						break;
					case 4:
						ba.viewBalance();
						break;

					case 5:

						quit = true;

						System.out.print("Bye!" + "");
						break;

					default:

						System.out.println("Wrong choice.");

						break;

					}

				} while (!quit);

				System.out.println(" Thanks for using App");
				in.close();

			}

		

	}


