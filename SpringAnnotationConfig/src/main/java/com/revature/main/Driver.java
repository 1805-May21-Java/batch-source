package com.revature.main;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.revature.SpringConfig;

public class Driver {

	public static void main(String[] args) {

		AnnotationConfigApplicationContext ac = new AnnotationConfigApplicationContext(SpringConfig.class);
		System.out.println(ac.getBean("bear"));

	}

}
