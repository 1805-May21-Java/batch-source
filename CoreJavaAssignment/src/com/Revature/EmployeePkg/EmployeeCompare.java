package com.Revature.EmployeePkg;

import java.util.ArrayList;
import java.util.Comparator;

public class EmployeeCompare implements Comparator<Employee> {

	//Compares the names of the employees alphabetically
	//Negative val means the first employees name comes first
	private int compareNames(Employee o1, Employee o2) {
		return o1.getName().compareToIgnoreCase(o2.getName());
	}

	//Same implementation as compareName
	private int compareDepartment(Employee o1, Employee o2) {
		return o1.getDepartment().compareToIgnoreCase(o2.getDepartment());
	}

	//Compares ages where return value matches string compare rval meaning
	private int compareAge(Employee o1, Employee o2) {
		return o1.getAge() - o2.getAge();
	}

	@Override
	public int compare(Employee o1, Employee o2) {
		int n;
		n = compareNames(o1, o2); //Check the names as first value to sort by
		if ( n != 0 ) {
			return n;
		}
		
		n = compareDepartment(o1,o2); //Compare the departments
		
		if ( n != 0 ) {
			return n;
		}
		
		n = compareAge(o1,o2); //Compare ages
		
		return n;
	}
	
	public static void main( String args[]) {
		Employee e = new Employee("Thomas" , "IT" , 22);
		Employee e2 = new Employee("Thomas","Help Desk" , 32);
		EmployeeCompare comp = new EmployeeCompare();
		ArrayList<Employee> arr = new ArrayList<Employee>();
		arr.add(new Employee("Jim","IT" , 23));
		arr.add(e);
		arr.add(e2);
		
		arr.sort(comp);
		
		for ( Employee temp : arr ) {
			System.out.println(temp.getName()+" "+temp.getDepartment());
		}
	}
}
