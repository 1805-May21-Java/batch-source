package com.revature.q17;

public class InterestDriver {
	public static void main(String[] args) {
		Bank bank = new Bank();
		double interest = bank.computeInterest();
		
		System.out.println("Your interest is " + interest + ".");
	}
}
