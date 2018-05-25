package com.revature.q07;

import java.util.Comparator;

public class CompareEmployeeAge implements Comparator<Employee>{

	@Override
	public int compare(Employee arg0, Employee arg1) {
		//is arg0 is less than arg1, it will return a negative
		return arg0.getAge() - arg1.getAge();
	}
	
}
