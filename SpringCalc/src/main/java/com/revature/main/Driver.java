package com.revature.main;

import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.revature.beans.Calculator;

public class Driver {

	public static void main(String[] args) {

		ConfigurableApplicationContext applicationContext = new ClassPathXmlApplicationContext("beans.xml");
		Calculator calculator = applicationContext.getBean(Calculator.class);
		calculator.add(5, 3.6);
		calculator.subtract(3, 8);
		calculator.multiply(4, 8);
		System.out.println(calculator.divide(5, 0));
	}

}
