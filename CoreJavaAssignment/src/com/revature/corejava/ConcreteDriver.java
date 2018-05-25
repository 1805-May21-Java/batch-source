package com.revature.corejava;
//Q18

import java.util.Scanner;

public class ConcreteDriver {

	private static Scanner scanner = new Scanner(System.in);
	public static void main(String[] args) {
		ConcreteSub sub = new ConcreteSub();
		String input = "";
		System.out.println("Enter a string: ");
		input = scanner.nextLine();
		boolean b = sub.checkCase(input);
		System.out.println(b?"You have capitol letters":"You have no capitol letters");
		System.out.println("Enter a string: ");
		input = scanner.nextLine();
		System.out.println(sub.makeUpperCase(input));
		System.out.println("Enter a number: ");
		input = scanner.nextLine();
		sub.changeNum(input);
		
	}

}
