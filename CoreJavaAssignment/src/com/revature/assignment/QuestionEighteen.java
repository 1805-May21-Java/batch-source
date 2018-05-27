package com.revature.assignment;

import com.revature.background.QuestionEighteenSuper;

public class QuestionEighteen extends QuestionEighteenSuper{

	//create variables for testing
	public static String strTrue = "Testing";
	public static String strFalse = "testing";
	
	//overrides method checkUpper to see if there is an upper case letter in a string
	@Override
	public boolean checkUpper(String str) {
		if(str.toLowerCase() == str) {
			System.out.println("False");
			return false;
		}
		System.out.println("True");
		return true;
	}

	//overrides method toUpper convert a string into all uppercase
	@Override
	public String toUpper(String str) {
		System.out.println(str.toUpperCase());
		return str.toUpperCase();
	}

	//overrides addTen to take a string number and add ten to it
	@Override
	public int addTen(String str) {
		int num = Integer.parseInt(str);
		num += 10;
		System.out.println(num);
		return num;
	}
	
	public static void main(String[] args) {
		
		//calls each method and tests it, printing the results
		QuestionEighteen q18 = new QuestionEighteen();
		q18.checkUpper(strTrue);
		q18.checkUpper(strFalse);
		q18.toUpper("testing");
		q18.addTen("24");
	}
}