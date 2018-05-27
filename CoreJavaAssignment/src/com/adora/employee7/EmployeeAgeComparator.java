package com.adora.employee7;

import java.util.Comparator;

public class EmployeeAgeComparator implements Comparator<Employee>{

	@Override
	public int compare(Employee o1, Employee o2) {
		if(o1.getAge() == o2.getAge())
			return 0;
		else 
			return o1.getAge() - o2.getAge();
	}

}
