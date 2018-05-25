package com.revature.q17;

import java.util.*;

public class Bank {
	//Set up scanner
	private static Scanner sc = new Scanner(System.in);
	
	double principal;
	double rate;
	int time;
	public Bank() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Bank(double principal, double rate, int time) {
		super();
		this.principal = principal;
		this.rate = rate;
		this.time = time;
	}
	
	public double computeInterest() {	
		//for each field, loop until a valid value is entered
		while(true) {
			try {
				System.out.println("What was your principal amount invested?");
				principal = Double.parseDouble(sc.nextLine());
				//check value
				if(principal < 0) {
					throw new NumberFormatException();
				}
				break;
			} catch(NumberFormatException e) {
				System.out.println("Please enter a valid value.");
			}
		}
		
		while(true) {
			try {
				System.out.println("What was your interest rate?");
				rate = Double.parseDouble(sc.nextLine());
				//check values
				if(rate < 0 || rate > 1) {
					throw new NumberFormatException();
				}
				break;
			} catch(NumberFormatException e) {
				System.out.println("Please enter a valid value.");
			}
		}
		
		while(true) {
			try { 
				System.out.println("How many years has it been?");
				time = Integer.parseInt(sc.nextLine());
				//check values
				if(time < 0) {
					throw new NumberFormatException();
				}
				break;
			} catch(NumberFormatException e) {
				System.out.println("Please enter a valid value.");
			}
		}
		
		//calculate interest
		return (principal*(1 + rate*time));
	}
}
