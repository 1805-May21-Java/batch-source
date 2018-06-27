package com.revature.main;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.revature.beans.Calculator;

public class Drive {

	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		ApplicationContext context = new ClassPathXmlApplicationContext("beans.xml");
		
		Calculator c = context.getBean(Calculator.class);
		
		System.out.println(c.calculate("add", 1, 2));
		System.out.println(c.calculate("multiply", 1, 2));
		System.out.println(c.calculate("subtract", 1, 2));
		System.out.println(c.calculate("divide", 1, 2));
		System.out.println(c.calculate("divide", 1, 0));
	}

}
