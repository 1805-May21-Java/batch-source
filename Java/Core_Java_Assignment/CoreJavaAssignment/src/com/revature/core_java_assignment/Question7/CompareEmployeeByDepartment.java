package com.revature.core_java_assignment.Question7;

import java.util.Comparator;

public class CompareEmployeeByDepartment implements Comparator<Employee> {

	@Override
	public int compare(Employee e1, Employee e2) {
		return e1.getDepartment().compareTo(e2.getDepartment());
	}

}
