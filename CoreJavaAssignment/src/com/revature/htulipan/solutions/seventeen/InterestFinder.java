package com.revature.htulipan.solutions.seventeen;

import java.util.Scanner;

public class InterestFinder {
	private double principal;
	private double rate;
	private int years;
	
	private Scanner sc;
	
	public InterestFinder() {
		super();
	}
	
	public InterestFinder(double principal, double rate, int years) {
		super();
		this.principal = principal;
		this.rate = rate;
		this.years = years;
	}
	
	public double getPrincipal() {
		return principal;
	}
	
	public void setPrincipal(double principal) {
		this.principal = principal;
	}
	
	public double getRate() {
		return rate;
	}
	
	public void setRate(double rate) {
		this.rate = rate;
	}
	
	public int getYears() {
		return years;
	}
	
	public void setYears(int years) {
		this.years = years;
	}
	
	public void fetchPrincipal() {
		if (sc == null) {
			sc = new Scanner(System.in);
		}
		
		boolean foundValid = false;
		double p = 0.0;
		String line;
		
		while(!foundValid) {
			System.out.println("Please Enter A Principal Amount: ");
			line = sc.nextLine();
			try {
				p = Double.parseDouble(line);
			} catch (NumberFormatException nfe) {
				System.out.println("Invalid Input");
				continue;
			}
			foundValid = true;
		}
		this.principal = p;
	}
	
	public void fetchRate() {
		if (sc == null) {
			sc = new Scanner(System.in);
		}
		
		boolean foundValid = false;
		double r = 0.0;
		String line;
		
		while(!foundValid) {
			System.out.println("Please Enter A Rate Amount: ");
			line = sc.nextLine();
			try {
				r = Double.parseDouble(line);
			} catch (NumberFormatException nfe) {
				System.out.println("Invalid Input");
				continue;
			}
			foundValid = true;
		}
		this.rate = r;
	}
	
	public void fetchYears() {
		if (sc == null) {
			sc = new Scanner(System.in);
		}
		
		boolean foundValid = false;
		int y = 0;
		String line;
		
		while(!foundValid) {
			System.out.println("Please Enter A Year Amount: ");
			line = sc.nextLine();
			try {
				y = Integer.parseInt(line);
			} catch (NumberFormatException nfe) {
				System.out.println("Invalid Input");
				continue;
			}
			foundValid = true;
		}
		this.years = y;
	}
	
	public double getInterest() {
		return principal * rate * years;
	}
}
