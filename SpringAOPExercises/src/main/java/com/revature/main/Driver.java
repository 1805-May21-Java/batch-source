package com.revature.main;

import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.revature.beans.Calculator;

public class Driver
{

	public static void main(String[] args)
	{
		ConfigurableApplicationContext ac = new ClassPathXmlApplicationContext("beans.xml");
		
		Calculator c = (Calculator) ac.getBean("calculator");
		c.add(1, 2);
		c.subtract(5, 4);
		c.multiply(5, 2);
		c.divide(5, 0);
		c.divide(12, 2);
		ac.close();
		
	}

}
