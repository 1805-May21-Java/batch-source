package com.revature.main;

import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.revature.beans.Bear;

public class Driver {
	
	public static void main(String[] args) {
		
		ConfigurableApplicationContext ac = new ClassPathXmlApplicationContext("beans.xml");
		
		Bear b = (Bear) ac.getBean("bear");
		b.setFull(true);
		System.out.println("bear full? " + b.isFull());
		System.out.println("bear awake? " + b.isAwake());
		try {
			b.bearHibernates();
			b.wakeUpBear();
		}catch (Exception e) {
			e.printStackTrace();
		}
		
		ac.close();
		
	}

}
