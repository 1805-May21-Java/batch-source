package com.revature.htulipan.project0hibernate.ui;

import java.util.Scanner;

public class BankingHibernateDriver {
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
