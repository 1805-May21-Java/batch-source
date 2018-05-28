package javacore;

import java.util.Collections;
import java.util.Comparator;
import java.util.LinkedList;


public class EmployeeDriver {
	public static void main(String[] args) {
		LinkedList<Employee> employeeList = new LinkedList<Employee>();
		
		employeeList.add(new Employee("Johnny", 1, 24));
		employeeList.add(new Employee("Janey", 2, 27));
		
		System.out.println("Employees sorted by name:");
		Comparator<Employee> compareName = (Employee emp1, Employee emp2) -> emp1.getName().compareTo(emp2.getName());
		Collections.sort(employeeList, compareName);
		for(Employee e : employeeList) {
			System.out.println(e);
		}
		
		System.out.println();
		
		System.out.println("Employees sorted by Department:");
		Comparator<Employee> CompareDept = (emp1 , emp2) -> {
			if (emp1.getDepartmentID() == emp2.getDepartmentID()) {
				return 0;
			} else {
				return(emp1.getDepartmentID()-emp2.getDepartmentID() > 0 ? 1 : -1);
			}
		}; 
		
		Collections.sort(employeeList,CompareDept);
		
		for(Employee e : employeeList) {
			System.out.println(e);
		}
		
		System.out.println();
		
		System.out.println("Employees sorted by Age:");
		Comparator<Employee> CompareAge = (emp1 , emp2) -> {
			if (emp1.getAge() == emp2.getAge()) {
				return 0;
			} else {
				return(emp1.getAge()-emp2.getAge() > 0 ? 1 : -1);
			}
		}; 
		
		Collections.sort(employeeList,CompareAge);
		
		for(Employee e : employeeList) {
			System.out.println(e);
		}
		
	}
}
