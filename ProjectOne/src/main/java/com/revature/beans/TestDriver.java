package com.revature.beans;

import java.util.*;

import com.revature.daos.*;
import com.revature.pojos.*;

public class TestDriver
{

	public static void main(String[] args)
	{
		EmployeeDaoImpl edi = new EmployeeDaoImpl();
		ReimbursementRequestDaoImpl rdi = new ReimbursementRequestDaoImpl();
				
		Employee smith = edi.getEmployeeById(21);
		System.out.println(smith);
		
		List<Employee> managees = smith.managedEployees();
		
		for(Employee employee : managees) {
			System.out.println(employee);
		}
	}

}
