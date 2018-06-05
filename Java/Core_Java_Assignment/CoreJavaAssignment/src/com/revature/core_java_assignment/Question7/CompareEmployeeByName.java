package com.revature.core_java_assignment.Question7;

import java.util.Comparator;

public class CompareEmployeeByName implements Comparator<Employee>{

	@Override
	public int compare(Employee e1, Employee e2) {
		return e1.getName().compareTo(e2.getName());
	}

}
