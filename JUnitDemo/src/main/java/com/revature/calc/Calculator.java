package com.revature.calc;

public class Calculator {
	
	/*
	 * 
	 * Creating a string calculator with a method which takes a string
	 * and returns an int
	 * 
	 * The method is going to take 0, 1, or 2 numbers, delimited by a 
	 * comma
	 * 
	 * It will return their sum; an empty string will also return 0
	 * 
	 * "2,4,1" -> 7
	 * "2,,4" if we split this ["2", "" , "4"]
	 */
	
	public static int add(String numbers) {
		int sum = 0;
		
		if(numbers.equals("")) {
			return sum;
		}
		String[] numbersArray = numbers.split(",");
		
		if(numbersArray.length>2) {
			throw new RuntimeException("Too many numbers");
		}
		
		for( String number : numbersArray) {
			if(!number.equals("")) {
				sum += Integer.parseInt(number);
			}
		}
		
		return sum;
	}

}
