package com.revature.main;

import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.revature.beans.Calculator;

public class Driver {

	public static void main(String[] args) {
		ConfigurableApplicationContext ac = new ClassPathXmlApplicationContext("beans.xml");
		int a;
		Calculator c = (Calculator) ac.getBean("calculator");
		c.setNum1(3);
		c.setNum2(2);
		a = c.add();
		c.setNum2(0);
		try {
			a = c.divide();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println(a);
		ac.close();
	}

}
