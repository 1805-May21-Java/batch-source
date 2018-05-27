package com.revature.question3;

import java.io.*;
import java.util.*;

public class Question3Driver {

	public Question3Driver() {
		// TODO Auto-generated constructor stub
		super();
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
        Scanner read = new Scanner(System.in);
        while(true) {
			System.out.println("Enter string to reverse, type quit to quit:");
	        
	        String str = read.nextLine();
	        if(str.equals("quit")){
	            break;
	        }
	        String reverse = "";
	        int num = str.length();
	   	 	String result = "";
		   	 for(int i = str.length() - 1; i >= 0; i--)
		     {
		         result = result+ str.charAt(i);
		     }
	 
	        System.out.println(result);
        }
	}


	 
	
	
}
