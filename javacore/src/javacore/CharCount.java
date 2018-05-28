package javacore;

import java.util.Scanner;

public class CharCount {
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		System.out.println("Enter String here: ");
		String s = scan.nextLine();
		
		System.out.println(s.length());
	}
}
