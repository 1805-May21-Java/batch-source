package com.revature.corejava;

import java.util.Comparator;

public class CompareAge implements Comparator<Employee>{
	
	public int compare(Employee a, Employee b) {
		return a.age - b.age;
	}
}
