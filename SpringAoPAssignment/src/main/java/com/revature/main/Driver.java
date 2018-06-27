package com.revature.main;

import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.revature.beans.Calculator;

public class Driver {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		ConfigurableApplicationContext ac = new ClassPathXmlApplicationContext("beans.xml");

		Calculator c = ac.getBean(Calculator.class);
		System.out.println("1+2="+c.add(1, 2));
		System.out.println("3-2="+c.subtract(3, 2));
		System.out.println("4*5="+c.multiply(4, 5));
		System.out.println("8/2="+c.divide(8, 2));
		System.out.println("9%4="+c.mod(9, 4));
		System.out.println("6^29="+c.xor(6, 29));
		System.out.println("4/0="+c.divide(4, 0));

		ac.close();
	}

}
