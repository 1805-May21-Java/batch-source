package com.revature.corejava;

import java.util.Comparator;

public class CompareDepartment implements Comparator<Employee> {

	public int compare(Employee a, Employee b) {
		return a.dpt.compareTo(b.dpt);
	}
	
}
