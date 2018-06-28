package com.revature.main;

import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.revature.beans.Bear;

public class Driver {

	public static void main(String[] args) {
		
		ConfigurableApplicationContext aContext = new ClassPathXmlApplicationContext("beans.xml");
		
		Bear.setWinter(true);
		Bear bear = (Bear) aContext.getBean("bear");
		bear.setFull(false);
		System.out.println("bear full? " + bear.isFull());
		System.out.println("bear awake? " + bear.isAwake());
		
		try {
			bear.bearHibernates();
			bear.wakeUpBear();
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		aContext.close();

	}

}
