package com.revature.corejava;

import java.util.Comparator;
//Q7
public class SortByDept implements Comparator<Employee> {

	@Override
	public int compare(Employee o1, Employee o2) {
		return o1.getDepartment().compareTo(o2.getDepartment());
	}

}
