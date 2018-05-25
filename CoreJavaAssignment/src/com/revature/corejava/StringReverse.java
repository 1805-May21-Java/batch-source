package com.revature.corejava;

import java.util.Scanner;

//Q3
public class StringReverse {
	private static Scanner scanner = new Scanner(System.in);
	public static void main(String[] args) {
			System.out.println("Enter a string:");
			String s = scanner.nextLine();
			int len = s.length();
			for(int i=0; i<len; i++) {
				s+=s.charAt(len-i-1);
			}
			s = s.substring(len);
			System.out.println("The reversed String is: "+s);
		}
}
