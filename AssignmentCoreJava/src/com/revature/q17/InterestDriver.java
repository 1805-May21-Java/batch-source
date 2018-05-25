package com.revature.q17;

public class InterestDriver {
	public static void main(String[] args) {
		//create Bank object
		Bank bank = new Bank();
		//compute interest
		double interest = bank.computeInterest();
		//display interest
		System.out.println("Your interest is " + interest + ".");
	}
}
