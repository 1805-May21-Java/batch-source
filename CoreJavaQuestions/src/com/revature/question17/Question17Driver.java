package com.revature.question17;

import java.util.Scanner;

public class Question17Driver {

	public static void main(String[] args) {
	    Scanner sc = new Scanner(System.in);
        System.out.println("Enter principal");
	    String input1 = sc.nextLine();
	    int i1 = Integer.parseInt(input1);
        System.out.println("Enter rate");
        System.out.println("rate, double");
	    String input2 = sc.nextLine();
	    double i2 = Double.parseDouble(input2);
	    System.out.println("Enter time");
        System.out.println("years, int");
	    String input3 = sc.nextLine();
	    int i3 = Integer.parseInt(input3);
	    System.out.println("Interest: "+i1*i2*i3);
	}

}
