package com.Revature.Generals;

import java.util.Scanner;

public class Question16 {
	public static void main(String args[]) {
		if (args.length >= 1) { //Check if there are arguments given
			System.out.println(args[0].length()); //If so print the first args
			//length
			return;
		}
		
		Scanner sc = new Scanner(System.in);
		
		String inp = sc.nextLine(); //If no arguments given, get input from user
		
		System.out.println(inp.length()); //Output inputs length
	}
}
