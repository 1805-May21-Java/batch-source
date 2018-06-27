package com.revature.main;

import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.revature.beans.Calculator;

public class Driver {
	
	public static void main(String[] args) {
		
		ConfigurableApplicationContext ac = new ClassPathXmlApplicationContext("beans.xml");
		Calculator c = (Calculator) ac.getBean("calculator");
		c.setX(6);
		c.setY(3);
		System.out.println(c.add());
		System.out.println(c.subtract());
		System.out.println(c.multiplication());
		try {
		System.out.println(c.division());
		c.setY(0);
		c.division();
		}catch (Exception e) {
			
		}
		ac.close();
		
		
	}

}
