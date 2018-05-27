package com.revature.homework;

import java.util.Scanner;

public class Q6 {

	public static void main(String[] args) {
		Scanner input =  new Scanner(System.in); // using scanner 
		
		System.out.println("please enter an integer ");
	
		int n;// assigning int variable to n
		n= input.nextInt(); // assign n variable from the scanner 
		
		
		if(n/2*2 == n) { // checking even numbers 
				System.out.println("even");
			}else {
				System.out.println("odd");
			}
		
		
		
				input.close();// closing scanner 
	}

}
