package com.revature.main;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.revature.beans.Calculator;

public class Driver {
	
	public static void main(String[] args) {
		ApplicationContext ac = new ClassPathXmlApplicationContext("beans.xml");
		Calculator calculator =(Calculator) ac.getBean("calculator");
		calculator.add(2.0, 5.0);
		calculator.substract(2.0, 5.0);
		calculator.multiply(2.0, 5.0);
		calculator.devide(1.0, 0);
	}

}
