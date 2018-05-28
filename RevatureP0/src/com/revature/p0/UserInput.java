package com.revature.p0;
import java.util.Scanner;

public class UserInput {
	
	Scanner sc;

	// TODO Auto-generated method stub
	
	public UserInput () {
		sc = new Scanner(System.in);
	}
	
	public int menu() {
		while(true) {
			if (sc.hasNextInt()) {
				return sc.nextInt();
			}
		}
	}
	
	public double money() {
		while(true) {
			if (sc.hasNextDouble()) {
				return sc.nextDouble();
			}
		}
	}
	public String names() {
		while(true) {
			if (sc.hasNext()) {
				return sc.next();
			}
		}
	}
}