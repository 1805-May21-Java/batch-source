package com.revature.q17;

import java.util.Scanner;

public class Driver {

	public static void main(String[] args) {

		System.out.println("Enter principal:");
		Scanner sc = new Scanner(System.in);
		int princ = sc.nextInt();
		
		System.out.println("Enter rate:");
		int rate = sc.nextInt();
		
		System.out.println("Enter time:");
		int time = sc.nextInt();
		
		int interest = princ * rate * time;
		System.out.println(interest);

	}

}
