package com.revature.main;

import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.revature.beans.Calculator;

public class Driver {

	public static void main(String[] args) {
		
		ConfigurableApplicationContext aContext = new ClassPathXmlApplicationContext("beans.xml");
		
		Calculator calculator = (Calculator) aContext.getBean("calculator");
		
		// do a bunch of calculations
		calculator.add(2, 7);
		calculator.add(2.5, 7.6);
		calculator.add(27, 0);
		calculator.subtract(6, 3);
		calculator.subtract(6.45, 3.2);
		calculator.subtract(63, 0);
		calculator.multiply(10, 5.0);
		calculator.multiply(10.2, 5.3);
		calculator.multiply(105, 0);
		calculator.divide(4.0, 8);
		calculator.divide(8.6, 4.2);
		calculator.divide(48, 0);
		
		((AbstractApplicationContext) aContext).close();

	}

}
