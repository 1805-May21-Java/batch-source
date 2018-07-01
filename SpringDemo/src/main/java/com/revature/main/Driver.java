package com.revature.main;

public class Driver {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ApplicationContext ac = new ClassPathXmlApplicationContext("beans.xml");
		BearWithConstructor b1 = (BearWithconstructor) ac.getBean("bearwithconstrutor");

	}

}
