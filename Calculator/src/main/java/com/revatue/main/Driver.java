package com.revatue.main;

import java.util.Scanner;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.revature.beans.Calculator;

public class Driver {

	static Scanner scan = new Scanner(System.in);
	
	public static void main(String[] args) {
		
		ApplicationContext ac = new ClassPathXmlApplicationContext("beans.xml");
		
		
		System.out.println("Welcome to Revature Calculator");
		System.out.println();
		int choice= 0;
		do {
			System.out.println("What would you like to do?");
			System.out.println();
			System.out.println("1. Addition"); 
			System.out.println("2. Subtraction");
			System.out.println("3. Multiplication");
			System.out.println("4. Division");
			System.out.println("5. Quit");
			
			choice=scan.nextInt();
			System.out.println();
			
			int one=0;
			int two=0;
			
			Calculator cal = (Calculator) ac.getBean("calculator");
			
			switch(choice) {
			case 1:
				one=getNumber(1);
				two=getNumber(2);
				System.out.println(cal.add(one, two));
				break;
			case 2:
				one=getNumber(1);
				two=getNumber(2);
				System.out.println(cal.sub(one, two));
				break;
			case 3:
				one=getNumber(1);
				two=getNumber(2);
				System.out.println(cal.mul(one, two));
				break;
			case 4:
				one=getNumber(1);
				two=getNumber(2);
				System.out.println(cal.div(one, two));
				break;
			}
		}while(choice != 5);
		
		System.out.println("Good-bye");

		((AbstractApplicationContext) ac).close();
	}
	
	public static int getNumber(int num) {
		if(num==1) {
			System.out.println("Enter first number");
		}
		else {
			System.out.println("Enter second number");
		}
		
		return scan.nextInt();
	}
}
