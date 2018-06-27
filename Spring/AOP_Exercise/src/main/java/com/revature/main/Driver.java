package com.revature.main;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.revature.beans.Calculator;

public class Driver {

	public static void main(String[] args) {
		ApplicationContext ac = new ClassPathXmlApplicationContext("beans.xml");
		Calculator c = (Calculator)ac.getBean("calculator");
		System.out.println(c.add(7, 8));
		System.out.println(c.subtract(22, 5));
		System.out.println(c.multiply(7, 9));
		System.out.println(c.divide(27, 0));
		System.out.println(c.divide(27, 5));
		((AbstractApplicationContext)ac).close();
	}
}
