package com.revature.homework;

import java.util.Scanner;

public class Q3 {

	public static void main(String[] args) { 
		
// length()  gives total length of string
// charAt() gives the index character		
	  Scanner sc = new Scanner(System.in);
      System.out.println(" please enter String");
      String str = sc.nextLine(); // user input takes string from scanner
      String rev = " "; // assigning empty string
   sc.close();
      
	int length = str.length(); // gives the total length of string
	for(int i = length -1; i>=0; i--) { //  start loop from total length - 1;
		rev = rev + str.charAt(i); // gives string reverse string 
    	  
      }
	System.out.println(rev);//
	
}
}