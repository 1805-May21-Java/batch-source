package com.revature.lab2;

public class Associate {

	private String name;
	private int age;
	public Associate() {
		// TODO Auto-generated constructor stub
		super();
	}
	public Associate(String n, int a) {
		super();
		this.setName(n);
		this.setAge(a);
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	

}
