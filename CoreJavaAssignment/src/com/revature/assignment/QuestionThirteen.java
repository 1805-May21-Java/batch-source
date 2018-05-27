package com.revature.assignment;

public class QuestionThirteen {
	
	//set number of intervals to run
	private static int num = 4;
	
	public static void main(String[] args) {
		
		//initial for loop runs the amount of times previously determined
		//nested for loop prints the mod of each iteration
		for (int i = 0; i<num; i++) {
		    for (int j = i; j >= 0; j--) {
		        System.out.print(j % 2);
		    }
		    System.out.println();
		}
	}
}
