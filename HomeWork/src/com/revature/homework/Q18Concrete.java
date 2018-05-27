package com.revature.homework;

public class Q18Concrete extends Q18Abstract{
	
	

	boolean checkUpper(String str) {
		String test = str.toUpperCase();
		if(test.equals(str)) {
			return true;
		}
		return false;
		
	}

	boolean checkLower(String str) { // check lower case
		String test =str.toLowerCase();
		if(test.equals(str)) {
			return true;
		}
		return false;
	}
	
	

	@Override
	int addString(String str) { // add string 
		String numberAsString = str;
		int number = Integer.parseInt(numberAsString)+ 10;
		
		return number;
	}
	
	

	public static void main(String[] args) {
		Q18Concrete c = new Q18Concrete();
		
		System.out.println(c.addString("34"));
		System.out.println(c.checkLower("HELLOW"));
		System.out.println(c.checkUpper("HI"));
		
	}

	
}
