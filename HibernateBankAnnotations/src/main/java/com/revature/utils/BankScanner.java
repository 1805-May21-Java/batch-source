package com.revature.utils;

import java.util.Scanner;

public class BankScanner {
	private static BankScanner myScanner;
	static Scanner sc;
	private BankScanner() {
		super();
		sc = new Scanner(System.in);
	}
	public static BankScanner getInstance() {
		if (myScanner == null) {
			myScanner = new BankScanner();
		}
		return myScanner;
	}
	@Override
	public Object clone() throws CloneNotSupportedException {
		throw new CloneNotSupportedException();
	}
	public String next() {
		String s;
		do {
			s = sc.nextLine();
			//if user enters an empty line or a line that starts with a space, keep trying
		} while (s.isEmpty() || s.substring(0, 1).equals(" "));
		return s;
	}
}
