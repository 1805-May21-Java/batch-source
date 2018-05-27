package com.revature.question5;

import java.util.Scanner;

public class Question5Driver {

	public Question5Driver() {
		// TODO Auto-generated constructor stub
		super();
	}

	public static void main(String[] args) {
		
        Scanner read = new Scanner(System.in);
        String str, startIndex, endIndex;
        char[] charArray;
        while(true) {
			System.out.println("Enter string to find substring of, type quit to quit:");
	        
	        str = read.nextLine();
	        if(str.equals("quit")){
	            break;
	        }
	        charArray = str.toCharArray();
			
	        System.out.println("Enter starting index of substring, type quit to quit:");
	        
	        startIndex = read.nextLine();
	        if(startIndex.equals("quit")){
	            break;
	        }

	        System.out.println("Enter ending index for substring, type quit to quit:");

	        endIndex = read.nextLine();
	        if(endIndex.equals("quit")){
	            break;
	        }

	        String s = new String(charArray,Integer.parseInt(startIndex), Integer.parseInt(endIndex)-Integer.parseInt(startIndex));
	        System.out.println(s);
        }
		// TODO Auto-generated method stub

	}

}
