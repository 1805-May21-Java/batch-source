package com.adora.factorial4;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Factorial {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);

		System.out.println("Enter a number to factorialize");
		
		try {
			int number = scanner.nextInt();
			long result = 1;
			
			for(int i = 1; i <= number; i++) {
				result *= (long) i;
			}
			
			System.out.println(result);
			
		} catch(InputMismatchException e) {
			System.out.println("You did not enter a number. Goodybye.");
		} finally {
			scanner.close();
		}
	}

}
