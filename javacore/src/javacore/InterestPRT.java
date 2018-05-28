package javacore;

import java.util.Scanner;

public class InterestPRT {
	static double interestRate(double principal, double rate, int time) {
		double interest = principal*rate*time;
		
		return interest;
	}
	
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		
		System.out.println("Enter Principle amount: ");
		double ppl = scan.nextDouble();
		
		System.out.println("Enter decimal rate per year ");
		double rate = scan.nextDouble();
		
		System.out.println("Enter Time in years ");
		int time = scan.nextInt();
		
		System.out.print("Simple interest amount is: ");
		System.out.print(interestRate(ppl, rate, time));
		
		scan.close();
		
	}
}
