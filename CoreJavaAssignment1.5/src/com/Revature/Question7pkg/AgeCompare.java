package com.Revature.Question7pkg;

import java.util.Comparator;

public class AgeCompare implements Comparator<Employee>{
	//Compare two employees by age youngest to oldest
	@Override
	public int compare(Employee e1, Employee e2) {
		return e1.getAge()-e2.getAge();
	}

}
