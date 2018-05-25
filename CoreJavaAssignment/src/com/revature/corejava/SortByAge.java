package com.revature.corejava;

import java.util.Comparator;

//Q7
public class SortByAge implements Comparator<Employee>{

	@Override
	public int compare(Employee o1, Employee o2) {
		return o1.getAge() - o2.getAge();
	}

}
