package com.revature.question13;

public class Question13Driver {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String input = "0100101010";
		int[] breakpoints = {0,2,5,9}; 
		for(int i = 0;i<input.length();i++) {
			System.out.print(input.charAt(i));
			if(i==breakpoints[0]||i==breakpoints[1]||i==breakpoints[2]||i==breakpoints[3]) {
				System.out.println("");
			}
		}

	}

}
