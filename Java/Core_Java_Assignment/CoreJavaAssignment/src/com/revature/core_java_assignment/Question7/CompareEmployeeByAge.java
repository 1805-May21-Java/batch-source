package com.revature.core_java_assignment.Question7;

import java.util.Comparator;

public class CompareEmployeeByAge implements Comparator<Employee>{

	@Override
	public int compare(Employee e1, Employee e2) {
		return e1.getAge() - e2.getAge();
	}

}
