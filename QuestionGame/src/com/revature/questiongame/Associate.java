package com.revature.questiongame;
import java.util.Scanner;

public class Associate {
	String name;
	int age;
	
	public Associate(String name, int age) {
		super();
		this.name = name;
		this.age = age;
	}
	
	public Associate() {
		super();
		// TODO Auto-generated constructor stub
	}

	@Override
	public String toString() {
		return name;
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
