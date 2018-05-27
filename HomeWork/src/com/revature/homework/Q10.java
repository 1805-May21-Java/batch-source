package com.revature.homework;

import java.util.Scanner;

public class Q10 {

	public static void main(String[] args) {
		int x, y, result, temp;
        /* Scanner is used for getting user input. 
         * The nextInt() method of scanner reads the
         * integer entered by user.
         */
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter First Number:");
        x = scanner.nextInt();
        System.out.println("Enter Second Number:");
        y = scanner.nextInt();
        
        scanner.close();// closing the scanner 
        
        /* In first step we are comparing only num1 and
         * num2 and storing the smallest number into the
         * temp variable and then comparing the temp and
         * num3 to get final result.
         */
        
        temp =x < y ? x:y; // using ternary operators
        result = y< temp ? y:temp;
        System.out.println("Smallest Number is:"+result);
    }


}
