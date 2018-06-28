package com.revature.main;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.revature.beans.BearWithAutomagic;
import com.revature.beans.BearWithSetter;

public class Driver {

	public static void main(String[] args) {
		
		ApplicationContext aContext = new ClassPathXmlApplicationContext("beans.xml");
		
		BearWithConstructor b1 = (BearWithConstructor) aContext.getBean("bearWithConstructor");
		b1.methodInBear();
		
		BearWithSetter b2 = (BearWithSetter) aContext.getBean("bearWithSetter");
		b2.methodInBear();
		
		BearWithAutomagic b3 = (BearWithAutomagic) aContext.getBean(")

	}

}
