package com.revature.main;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.revature.bean.Calculator;

public class Driver {

	public static void main(String[] args) {
		ApplicationContext ac = new ClassPathXmlApplicationContext("beans.xml");
		
		Calculator calc = (Calculator) ac.getBean("calculator");
		
		calc.add(1, 2);
		calc.add(8.7, 0);
		calc.sub(4, 4);
		calc.sub(8, 1.1);
		calc.sub(0, -133);
		calc.mul(0, 1);
		calc.mul(2.2, 0.1);
		calc.div(1, 2);
		calc.div(0, 4.3);
		calc.div(1.33, 0);
		
		((AbstractApplicationContext) ac).close();
	}
}
