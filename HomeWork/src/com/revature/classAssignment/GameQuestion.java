package com.revature.classAssignment;

import java.util.ArrayList;


public class GameQuestion {
	
	public void getAssociate() {
		 ArrayList<String> al = new ArrayList<String>();
		 al.add("paul");
		 al.add("mary");
		 al.add("jay");
		 al.add("david");
		 al.add("jacob");
		 
		 System.out.println(al.size());
	}
		 
		 public void getQuestions() {
			 ArrayList<String> al1 = new ArrayList<String>();
			  al1.add ("what is jdk ?");
			  al1.add("what is reflection ?");
			  al1.add("what is inheritance ?");
			  al1.add("why java popular ?");
			  al1.add("what is collection ?");
			  	  
			  for(String s : al1) {
				  System.out.println(s);
			  }
		 }

	public static void main(String[] args) {
	/*	
		//String[] Associate = {"paul","kristy","david"};
		//String[] Question = {"what is jdk ?", "what is reflection ?", "what is genric ?"};
		 ArrayList<String> al = new ArrayList<String>();
		 al.add("paul");
		 al.add("mary");
		 al.add("jay");
		 al.add("david");
		 al.add("jacob");
		 
		 for(String s : al) {
			 System.out.println(s);
			
		 }
		 System.out.println();
		 ArrayList<String> al1 = new ArrayList<String>();
		  al1.add("what is jdk ?");
		  al1.add("what is reflection ?");
		  al1.add("what is inheritance ?");
		  al1.add("why java popular ?");
		  al1.add("what is collection ?");
		  
		  for(String s : al1) {
			  System.out.println(s);
		  }
		   
		 */
		   
	
}
}