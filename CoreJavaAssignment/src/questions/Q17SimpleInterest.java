package questions;

import java.util.Scanner;

//Q17SimpleInterest uses Scanner sc to take user input and compute simple interest.
public class Q17SimpleInterest {
	
	public static void main(String[] args) {

		//Three user inputs are read by Scanner sc
		//and stored in three variables
		Scanner sc = new Scanner(System.in);
		System.out.println("$Principal:");
		double principal = sc.nextDouble();
		System.out.println("Interest rate (Give decimal input to do percentage):");
		double rateOfInterest = sc.nextDouble();
		System.out.println("Give number of years");
		int numberOfYears = sc.nextInt();
		
		//Calculation to find addition money gained from interest.
		double moneyFromInterest = principal * (rateOfInterest * numberOfYears);
		//Principal plus interest.
		double newTotal = principal + moneyFromInterest;
		//The new principal is then printed and Scanner is closed.
		System.out.println("Principal is now: $" + newTotal);
		sc.close();
		
	}

}
