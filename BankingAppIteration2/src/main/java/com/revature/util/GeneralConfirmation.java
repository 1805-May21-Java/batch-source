package com.revature.util;

public class GeneralConfirmation {
	private static BankScanner scan = BankScanner.getInstance();
	
	public static boolean check(String s) {
		String option;
		boolean answer = false;
		boolean validYesNo = false;
		do {
			System.out.println(s);
			System.out.println("Enter 'y' for yes or 'n' for no");
			option = scan.next();
			if(option.toLowerCase().equals("y")) {
				answer = true;
				validYesNo = true;
				break;
			} else if(option.toLowerCase().equals("n")) {
				answer = false;
				validYesNo = true;
				break;
			} else {
				// If neither a 'y' or 'n' are entered, ask them to try again.
				System.out.println("Could not recognize input.");
			}
		} while(!validYesNo);
		return answer;
	}
}
