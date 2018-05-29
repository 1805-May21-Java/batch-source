package com.revature.htulipan.banking.project0;

import java.util.Scanner;

public class Project0BankingApp {
	
	public static void main(String[] args) {
		BankingSession bs = new BankingSession();
		Scanner scan = new Scanner(System.in);
		while (bs.getExitStatus()) {
			System.out.print(bs.getDisplayText());
			bs.interpretInput(scan.nextLine());
		}

	}

}
