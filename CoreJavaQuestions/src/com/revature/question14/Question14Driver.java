package com.revature.question14;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;

public class Question14Driver {

	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		System.out.println("Enter a choice:");
		System.out.println("1.  Square root:");
		System.out.println("2.  Today's date:");
		System.out.println("3.  Split a string:");
		int option = Integer.parseInt(s.nextLine());
		switch (option) {
	        case 1:  option = 1;
	        		 case1();
	                 break;
	        case 2:  option = 2;
	        		 case2();
	                 break;
	        case 3:  option = 3;
	        		 case3();
	        		 break;
	        default:
            		 break;
		}
		s.close();
	}

	public static void case1() {

		Scanner s = new Scanner(System.in);
		System.out.println("Entered 1, enter number to square root: ");
		System.out.println();
		double db = Double.parseDouble(s.nextLine());
		System.out.print(Math.sqrt(db));
	}

	public static void case2() {

		 System.out.println("Entered 2, todays date: ");
		 DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm:ss");  
		 LocalDateTime now = LocalDateTime.now(); 
		 System.out.println(now);
	
	}

	public static void case3() {

		System.out.println("Entered 3, splitting string: ");
        String temp = "I am learning Core Java";
        String [] arrString = temp.split("[\\s]");
        for(String splitString:arrString)
        {
            System.out.println(splitString);
        }
	
	}

	
}

