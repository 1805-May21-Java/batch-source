package com.adora.main;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.adora.beans.Calculator;

public class CalculatorDriver {

	public static void main(String[] args) {
		ApplicationContext ac = new ClassPathXmlApplicationContext("beans.xml");
		Calculator calculator = (Calculator) ac.getBean("calculator");
		
		System.out.println(calculator.add(1, 2));
		System.out.println(calculator.subtract(1, 5));
		System.out.println(calculator.multiply(4, 7));
		System.out.println(calculator.divide(10, 4));
		System.out.println(calculator.divide(10, 0));
	}
	
	
	
	

}
