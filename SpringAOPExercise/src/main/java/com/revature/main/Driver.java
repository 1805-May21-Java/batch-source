package com.revature.main;

import java.util.Scanner;

import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.revature.beans.Calculator;

public class Driver {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		ConfigurableApplicationContext ac = new ClassPathXmlApplicationContext("beans.xml");
		boolean run=true;
		Calculator c = (Calculator) ac.getBean("calculator");
		
		do {
		int operation = c.getOperation();
		double num1 = c.getNum1();
		double num2 = c.getNum2();
		
		switch(operation) {
		case 1:
			System.out.println("Your result is: " + c.addition(num1, num2));
			break;
		
		case 2:
			System.out.println("Your result is: " + c.subtraction(num1, num2));
			break;
		case 3:
			System.out.println("Your result is: " + c.multiplication(num1, num2));
			break;
		case 4:
			System.out.println("Your result is: " + c.division(num1, num2));
			break;
		default: System.out.println("Invalid command");
	}
		} while(run);

		ac.close();
	}

}

