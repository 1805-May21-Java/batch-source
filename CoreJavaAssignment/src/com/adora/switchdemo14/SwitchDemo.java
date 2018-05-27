package com.adora.switchdemo14;

import java.time.LocalDate;

public class SwitchDemo {
	
	
	public static void main(String[] args) {
		
		int option = 3;
		int n = 16;
		
		
		switch (option) {
		
		case 1: 
			double sqrt = Math.sqrt(n);
//			System.out.println(sqrt);
			break;
		case 2:
			System.out.println(LocalDate.now());
			break;
		case 3:
			String string = "I am learning Core Java";
			String[] strArr = string.split(" ");
//			for(String s : strArr) {
//				System.out.print(s + " ");
//			}
		}	
		
	}

}
