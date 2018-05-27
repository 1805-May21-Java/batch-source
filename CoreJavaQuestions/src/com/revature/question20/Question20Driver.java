package com.revature.question20;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Question20Driver {

	public static void main(String[] args) {
				
	    File file = new File("resources/data");

	    try {

	        Scanner sc = new Scanner(file);

	        while (sc.hasNextLine()) {
	            String input = sc.nextLine();
	            System.out.println("\n");
	            print(input);
	        }
	        sc.close();
	    } 
	    catch (FileNotFoundException e) {
	        e.printStackTrace();
	    }
		
		
	}

	private static void print(String s) {
		// TODO Auto-generated method stub
		int l = s.length();
		int i = 0;
		int specialCharCount = 0;
		while(i < l) {
			if(i==0) {
				System.out.println("Name: ");
			}
			if(s.charAt(i)==(':')&&specialCharCount==0) {
				System.out.print(" ");
				specialCharCount+=1;
			}
			else if(s.charAt(i)==(':')&&specialCharCount==1) {
				System.out.print("\n");				
				System.out.print("Age: ");				
				specialCharCount+=1;
			}
			else if(s.charAt(i)==(':')&&specialCharCount==2) {
				System.out.print("\n");				
				System.out.print("State: ");	
				specialCharCount+=1;
			}
			
			if(s.charAt(i)!=(':')) {
				System.out.print(s.charAt(i));				
			}			
			i+=1;
		}
	}
	
	
}
