package com.revature.util;

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
		return sc.nextLine();
	}
}
