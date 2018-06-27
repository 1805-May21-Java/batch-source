package com.revature.htulipan.springbeans.util;

import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.revature.htulipan.springbeans.beans.Calculator;

/**
 * 
 * Create a calculator java application with which you can perform basic arithmetic operations

Use Spring AOP to create advice which will:
log in a separate file the method signature of each operation as it is executed
log the operation arithmetically as it is performed - include the result (obtained by the join point, not from repeating the operation)
E.g. if add(2, 3) is called, “2 + 3 = 5” is logged
prevent the division method from executing if division is attempted by 0 and log an error

Exercise should be completed by 9am Thursday

Also 9am Thursday:
Global concept sheet should be complete with topics from Spring Core, AOP, and MVC
We’ll be having a mid-week quiz on these topics

 *
 */

public class CalculatorDriver {

	public static void main(String[] args) {
		
		ConfigurableApplicationContext ac = new ClassPathXmlApplicationContext("beans.xml");
		Calculator calc = (Calculator) ac.getBean("calculator");
		
		calc.add(1, 2);
		calc.div(1, 0);
		calc.mul(1, 2);
		calc.sub(1, 2);
		calc.div(1, 2);
		
		ac.close();
	}
}
