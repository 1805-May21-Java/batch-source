package com.revature.question6;

import java.util.Scanner;

public class Question6Driver {

	public Question6Driver() {
		// TODO Auto-generated constructor stub
	}

	public static void main(String[] args) {
		Scanner read = new Scanner(System.in);
        String str;
        char[] charArray;
        while(true) {
			System.out.println("Enter number to find if even or odd, quit to quit.");
	        
	        str = read.nextLine();
	        if(str.equals("quit")){
	            break;
	        }
	        if((Integer.parseInt(str)&1)==0){
	        	System.out.println("Number is: even");
	        }
	        else {
	        	System.out.println("Number is: odd");
	        	
	        	
	        }
        }
	}
}
