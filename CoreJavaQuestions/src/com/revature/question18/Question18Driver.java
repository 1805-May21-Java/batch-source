package com.revature.question18;

import java.util.Scanner;

public class Question18Driver {

	public static void main(String[] args) {

	    Scanner sc = new Scanner(System.in);
	    System.out.println("Enter option 1,2,3: ");
	    System.out.println("1.  Any uppercase?");
	    System.out.println("2.  Change all to lowercase");
	    System.out.println("3.  Add 10 to a input string integer value");

		int option = Integer.parseInt(sc.nextLine());
		Question18 q18 = new Question18();
	    

		switch (option) {
        case 1:  option = 1;
        		 System.out.println("Enter string to search case of: ");
        		 String s1 = sc.nextLine();
        		 q18.anyUpperCase(s1);
                 break;
        case 2:  option = 2;
        		 System.out.println("Enter string to change all chars to lowercase: ");
        		 String s2 = sc.nextLine();
        		 q18.toLowerCase(s2);
                 break;
        case 3:  option = 3;
        		 System.out.println("Enter string, integer value, to add 10 to: ");
        		 String s3 = sc.nextLine();        		 
           		 q18.convertAdd10(s3);
        		 break;
        default:
        		 break;
		}
	
	}

}
