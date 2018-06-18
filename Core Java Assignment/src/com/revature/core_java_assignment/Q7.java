package com.revature.core_java_assignment;
import java.util.Collections;
import java.util.Comparator;
import java.util.LinkedList;

public class Q7
{
	//Sort two employees based on their name, department, and age using the Comparator interface.
	public static void main(String[] args)
	{
		//creating a list of those two employees
		LinkedList<Employees> employeeList = new LinkedList<Employees>();
		
		employeeList.add(new Employees("Marceline", "IT", 30));
		employeeList.add(new Employees("Devon", "QC", 28));
		
		//sorted them by age
		Collections.sort(employeeList);
		for(Employees i : employeeList)
		{
			System.out.println(i);
		}

	}

}
