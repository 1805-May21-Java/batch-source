package com.revature.q07;

import java.util.Comparator;

public class CompareEmployeeDepartment implements Comparator<Employee>{

	@Override
	public int compare(Employee o1, Employee o2) {
		//uses the compareTo String method to generate the comparison
		return o1.getDepartment().compareTo(o2.getDepartment());
	}

}
