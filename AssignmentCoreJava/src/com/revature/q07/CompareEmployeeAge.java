package com.revature.q07;

import java.util.Comparator;

public class CompareEmployeeAge implements Comparator<Employee>{

	@Override
	public int compare(Employee arg0, Employee arg1) {
		return arg0.getAge() - arg1.getAge();
	}
	
}
