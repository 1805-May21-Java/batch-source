package com.revature.algorithms;
import java.util.Scanner;

public class Financial {

	private double principal;
	private double rateOfInterest;
	private double time;
	
	public Financial() {
		super();
	}

	public Financial(double principal, double rateOfInterest, double time) {
		super();
		this.principal = principal;
		this.rateOfInterest = rateOfInterest;
		this.time = time;
	}

	public double getPrincipal() {
		return principal;
	}

	public void setPrincipal(double principal) {
		this.principal = principal;
	}

	public double getRateOfInterest() {
		return rateOfInterest;
	}

	public void setRateOfInterest(double rateOfInterest) {
		this.rateOfInterest = rateOfInterest;
	}

	public double getTime() {
		return time;
	}

	public void setTime(double time) {
		this.time = time;
	}

	// prompts the user for the 3 parameter values, restarts if invalid input is given
	public void promptValues() {
		Scanner input = new Scanner(System.in);
		String tempInput = null;
		try {
			System.out.print("Please enter the principal: ");
			tempInput = input.nextLine();
			this.principal = Double.parseDouble(tempInput);
			
			System.out.print("Please enter the interest rate: ");
			tempInput = input.nextLine();
			this.rateOfInterest = Double.parseDouble(tempInput);
			
			System.out.print("Please enter the time elapsed: ");
			tempInput = input.nextLine();
			this.time = Double.parseDouble(tempInput);
		} catch(NumberFormatException e) {
			System.out.println("Invalid entry, value must be a number. Please reenter information.\n");
			promptValues();
		}
		input.close();
	}
	
	// calculates simple interest by taking the product of the three parameters
	public double calculateSimpleInterest() {
		return principal * rateOfInterest * time;
	}
}
