package com.revature.main;

import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.revature.beans.Calculator;

public class Driver {

	public static void main(String[] args) {
		
		ConfigurableApplicationContext ac = new ClassPathXmlApplicationContext("beans.xml");
		
		Calculator c = (Calculator) ac.getBean("calculator");
		System.out.println(c.add(5, 2));
		System.out.println(c.subtract(13.5, 2.7));
		System.out.println(c.multiply(7, 3));
		System.out.println(c.divide(9, 2));
		System.out.println(c.divide(10, 0));
		
		ac.close();
	}

}
