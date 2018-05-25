package com.revature.q07;

import java.util.Comparator;

//Make sure Comparitor takes the Employee as a generic so that it knows what to ork with
public class CompareEmployeeName implements Comparator<Employee>{

	@Override
	public int compare(Employee o1, Employee o2) {
		//uses the compareTo String method to generate the comparison
		return o1.getName().compareTo(o2.getName());
	}

}
