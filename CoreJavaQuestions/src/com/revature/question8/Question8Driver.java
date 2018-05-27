package com.revature.question8;

import java.util.*;

public class Question8Driver {

	public Question8Driver() {
		// TODO Auto-generated constructor stub
		super();
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
	      /*Creation of ArrayList: I'm going to add String
	       *elements so I made it of string type */
		  ArrayList<String> strArrList1 = new ArrayList<String>();
		  ArrayList<String> strArrList2 = new ArrayList<String>();
		  
//		  StringBuilder arr2 = 

		  /*This is how elements should be added to the array list*/
		  strArrList1.add("karan");
		  strArrList1.add("madam");
		  strArrList1.add("tom");
		  strArrList1.add("civic");
		  strArrList1.add("radar");
		  strArrList1.add("jimmy");
		  strArrList1.add("kayak");
		  strArrList1.add("john");
		  strArrList1.add("refer");
		  strArrList1.add("billy");
		  strArrList1.add("did");

		  System.out.println("Current string array list is: "+ strArrList1);

		StringBuffer buffer = null;
		String s;

		for(String f : strArrList1){
		  buffer = new StringBuffer(f);
		  buffer = buffer.reverse();
		  s = buffer.toString();
		  System.out.println("Current string array list is: "+ s);
	      strArrList2.add(s);
		}
		  System.out.println("Palindrome current string array list is:"+strArrList2);


	}
	

}
