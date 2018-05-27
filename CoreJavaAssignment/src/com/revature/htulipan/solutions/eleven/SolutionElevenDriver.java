package com.revature.htulipan.solutions.eleven;

import com.revature.htulipan.ancillary.eleven.TwoFloatContainer;

/*
 * Q11. Write a program that would access two float-variables from a class that exists in another package. Note, you will need to create two packages to demonstrate the solution.
 */

public class SolutionElevenDriver {
	
	public static void main(String[] args) {
		float f1 = TwoFloatContainer.firstFloat;
		float f2 = TwoFloatContainer.secondFloat;
		
		System.out.println("First Float: ");
		System.out.println(f1);
		System.out.println("Second Float: ");
		System.out.println(f2);
	}
	
	
}
