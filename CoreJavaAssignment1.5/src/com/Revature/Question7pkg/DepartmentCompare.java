package com.Revature.Question7pkg;

import java.util.Comparator;

public class DepartmentCompare implements Comparator<Employee> {
	//Compares departments alphabetically
	@Override
	public int compare(Employee e1, Employee e2) {
		return e1.getDepartment().compareTo(e2.getDepartment());
	}
}
