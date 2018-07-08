package com.revature.main;

import org.springframework.context.ApplicationContext;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.revature.beans.Bear;

public class Driver {

	public static void main(String[] args) {
		
		ConfigurableApplicationContext ac = new ClassPathXmlApplicationContext("beans.xml");
		
		Bear.setWinter(true);
		Bear b = (Bear) ac.getBean("bear");
		b.setFull(false);
		System.out.println("bear full? "+ b.isFull());
		System.out.println("bear awake? "+ b.isAwake());
		
		try {
			b.bearHibernates();
			b.wakeUpBear();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		ac.close();
		

	}

}
