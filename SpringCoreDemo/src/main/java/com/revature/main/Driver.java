package com.revature.main;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.revature.beans.*;

public class Driver {

	public static void main(String[] args) {
	
		ApplicationContext ac = new ClassPathXmlApplicationContext("beans.xml");
		
		BearWithConstructor b1 = (BearWithConstructor) ac.getBean("bearWithConstructor");
		b1.methodInBear();
		
		BearWithSetter b2 = (BearWithSetter) ac.getBean("bearWithSetter");
		b2.methodInBear();
		
		BearWithAutomagic b3 = (BearWithAutomagic) ac.getBean("bearWithAutomagic");
		b3.methodInBear();
		
		BearWithAutowiringByName b4 = (BearWithAutowiringByName) ac.getBean("bearWithAutowiringByName");
		b4.methodInBear();
		
		BearWithAutowiringByType b5 = (BearWithAutowiringByType) ac.getBean("bearWithAutowiringByType");
		b5.methodInBear();

	}

}
