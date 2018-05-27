package com.revature.homework;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

public class Q14 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		 System.out.println("enter selection ");
		 String selection = sc.nextLine();
		 

		 switch(selection) {
		
		 case "sqrt":System.out.println(" enter double number ");
			 double number = sc.nextDouble();
		
			 System.out.println(Math.sqrt(number));
		          break;
		 case "date":   DateFormat df = new SimpleDateFormat("MM/dd/YYYY");  // using date function 
		  Date date = new Date();
		  System.out.println(df.format(date));
		  break;
		 case "Split": String s = "I am learning Core Java";
		   String[] coreJava = s.split(" "  ); // using split method
		   //System.out.println(coreJava.length);
		   for(String a:coreJava) {
			   System.out.println(a);
		   }
		 }
sc.close();
	}

}
