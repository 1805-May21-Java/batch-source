package com.revature.htulipan.solutions.seventeen;

import java.util.Scanner;

/*
 * Q17. Write a program that calculates the simple interest on the principal, rate of interest and number of years provided by the user. Enter principal, rate and time through the console using the Scanner class.
Interest = Principal* Rate* Time
 */

public class SolutionSeventeenDriver {
	public static void main(String[] args) {
		InterestFinder iFinder = new InterestFinder();
		iFinder.fetchPrincipal();
		iFinder.fetchRate();
		iFinder.fetchYears();
		System.out.println("The interest is: ");
		System.out.println(iFinder.getInterest());
	}
}
