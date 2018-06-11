package com.revature.htulipan.banking2.ui;

import java.util.Scanner;

public class Project0Iteration2App {
	public static void main(String[] args) {
		BankingSession bs = new BankingSession();
		Scanner scan = new Scanner(System.in);
		while (!bs.isExiting()) {
			System.out.print(bs.getDisplayText());
			if (!bs.isWaiting()) bs.interpretInput(scan.nextLine());
		}
		scan.close();
	}
}