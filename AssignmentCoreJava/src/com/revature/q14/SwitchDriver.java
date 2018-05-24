package com.revature.q14;

import java.util.*;

public class SwitchDriver {
	static public void main(String[] args) {
		trySomething(1);
		trySomething(2);
		trySomething(3);
	}
	
	static void trySomething(int option) {
		switch(option) {
		case 1: 
			System.out.println(Math.sqrt(1290));
			break;
		case 2:
			Date date = new Date();
			System.out.println(date.toString());
			break;
		case 3:
			String completeString = "I am learning Core Java";
			String[] splitString = completeString.split(" ");
			for(String s : splitString) {
				System.out.println(s);
			}
			break;
		default:
			System.out.println("There are only three options");
		}
	}
}
