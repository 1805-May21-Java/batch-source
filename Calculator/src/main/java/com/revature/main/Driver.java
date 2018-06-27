package com.revature.main;

import org.springframework.context.*;
import org.springframework.context.support.*;

import com.revature.beans.Calculator;

public class Driver
{

	public static void main(String[] args)
	{
		ConfigurableApplicationContext ac = new ClassPathXmlApplicationContext("beans.xml");
		
		Calculator calc = (Calculator)ac.getBean("calculator");
		
		System.out.println(calc.add(8, 7.5));
		System.out.println(calc.subtract(11.73, 2.95));
		System.out.println(calc.multiply(4.007, 9.21));
		System.out.println(calc.divide(33, 21));
		System.out.println(calc.divide(44, 0));
		
		ac.close();
	}

}
