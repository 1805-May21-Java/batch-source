package com.revature.question4;

import java.util.Scanner;

public class Question4Driver {

	public Question4Driver() {
		// TODO Auto-generated constructor stub
		super();
	}

	
	public static int factorial(int n){    
		if (n == 0)    
			return 1;    
		else    
			return(n * factorial(n-1));    
	}    
	
	public static void main(String args[]){  
        Scanner read = new Scanner(System.in);
        while(true) {
			System.out.println("Enter n!, type quit to quit:");
	        
	        String str = read.nextLine();
	        if(str.equals("quit")){
	            break;
	        }
	        
	        System.out.println("Factorial of "+Integer.parseInt(str)+": " + factorial(Integer.parseInt(str)));
        }
		

	}  
  
}	


