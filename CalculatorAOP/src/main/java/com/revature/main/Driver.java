package com.revature.main;

import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.revature.beans.Calculator;

public class Driver {

	public static void main(String[] args) {
		
		ConfigurableApplicationContext ac = new ClassPathXmlApplicationContext("beans.xml");
		Calculator myCalc = (Calculator) ac.getBean("calculator");
		
			myCalc.add(10, 4);
			myCalc.subtract(22, 3);
			myCalc.multiply(4, 5);
			myCalc.divide(50, 5);
			myCalc.divide(12, 0);
			

		ac.close();
	}

}
