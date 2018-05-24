package core_java_assignment;

import java.util.Scanner;

public class Question17 {
	double principal, rate, time;
	
	public String simpleInterest(Scanner scanner) {
		principal = readInteger(scanner, "Enter a principal: ");
		rate = readInteger(scanner, "Enter a rate: ");
		time = readInteger(scanner, "Enter a time: ");
		
		return "Your interest is: " + principal * rate * time;
	}
	
	private double readInteger(Scanner scanner, String message) {
		double bloop = 0;
		boolean validInput = false;
		while (!validInput) {
			System.out.println(message);
			if (scanner.hasNextInt()) {
				bloop = scanner.nextInt();
				validInput = true;
			} else {
				System.out.println("Not an Integer.");
				scanner.next();
			}
		}
		return bloop;
	}
}
