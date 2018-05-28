package com.revature.assignment;

import java.util.ArrayList;
import java.util.Iterator;

public class Q8 {

	//Q8. Write a program that stores the following strings in an ArrayList and saves all the palindromes in another ArrayList.
	//“karan”, “madam”, ”tom”, “civic”, “radar”, “jimmy”, “kayak”, “john”,  “refer”, “billy”, “did”
	
	//I created an ArrayList with the names and then used the StringBuilder .reverse() method to get their palindromes and store 
	//them in a new palindromeList
	public void listMaker() {
		ArrayList<String> list = new ArrayList<String>();
		ArrayList<String> palindromeList = new ArrayList<String>();
		
		list.add("karan");
		list.add("madam");
		list.add("tom");
		list.add("civic");
		list.add("radar");
		list.add("jimmy");
		list.add("kayak");
		list.add("john");
		list.add("refere");
		list.add("billy");
		list.add("did");
		
		for(int i = 0; i < list.size(); i++) {
		    list.set(i, new StringBuilder(list.get(i)).reverse().toString());
		}
		palindromeList.addAll(list);
		System.out.println(palindromeList);
		
//		Driver Code
//		Q8 q = new Q8();
//		q.listMaker();
		
		
	}
	
}
