package com.revature.corejava;

import java.util.Scanner;

//Q18
public class ConcreteSub extends AbstractSuper {
//Concrete implementation of the Abstract Superclass
	private static Scanner scanner = new Scanner(System.in);
	@Override
	public boolean checkCase(String s) {
		for(char c: s.toCharArray()) {
			if(Character.isUpperCase(c)) {
				return true;
			}
		}
		return false;
	}

	@Override
	public String makeUpperCase(String s) {
		System.out.println(s.toUpperCase());
		return null;
	}

	@Override
	public void changeNum(String s) {
		int num=0;
		try {
			num = Integer.parseInt(s);
			
		} catch (NumberFormatException e) {
			System.out.println("Invalid input, please enter a Number");
			changeNum(scanner.nextLine());
		}
		int number = num+10;
		System.out.println("Your new number is: "+number);		
	}
}
