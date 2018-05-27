package com.revature.assignment;

import java.util.ArrayList;

public class QuestionEight {
		
	public static void main(String[] args) {
		
		//create arrList storing the names to be compared
		ArrayList<String> arrList = new ArrayList<String>();
		arrList.add("karan");
		arrList.add("madam");
		arrList.add("tom");
		arrList.add("civic");
		arrList.add("radar");
		arrList.add("jimmy");
		arrList.add("kayak");
		arrList.add("john");
		arrList.add("refer");
		arrList.add("billy");
		arrList.add("did");
		
		System.out.println(arrList);
		System.out.println();
		
		//create palList to store palindromes in later
		ArrayList<String> palList = new ArrayList<String>();
		
		//for loop cycles through each item of arrList
		for(int i=0; i<arrList.size(); i++) {
			String strBackwards = "";
			
			//nested for loop reverses each string
			for(int j=arrList.get(i).length()-1; j>=0; j--) {
				strBackwards += arrList.get(i).charAt(j);
			}
			
			//checks to see if the reversed version is equal to the original, if so add to the ArrayList
			if(arrList.get(i).equals(strBackwards)) {
				palList.add(strBackwards);
			}
		}
		
		System.out.println("The palindromes from the previous list are:");
		System.out.println(palList);
		
	}
	
}
