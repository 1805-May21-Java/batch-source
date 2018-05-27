package com.revature.homework;

import com.revature.classAssignment.Question11; // importing class from different package
// Question11 class is in different package;
public class Q11 {

	public static void main(String[] args) {
	  Question11 q11 = new Question11(1f,3f);// assigning argument constructor and creating object
	  System.out.println(q11.f1); // accessing the variable from different package
	  System.out.println(q11.f2);
	  
	}

}
