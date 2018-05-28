package com.revature.corejava;

import java.util.Comparator;
import java.util.Scanner;

public class EmployeeComparator implements Comparator<Employee>
{
	public static Scanner scanner = new Scanner(System.in);
	public static void main(String[] args) 
	{
	
		
	}


	@Override
	public int compare(Employee employee1, Employee employee2) 
	{
		
		//I have an isue where this statement prints more than it should and i'm not sure what to do
		System.out.println("What would you like to sort by: ");
		String sortBy = scanner.nextLine();
		
		//switch case that lets you choose what you would like to sort by
		switch(sortBy.toLowerCase())
		{
			case "age":
				if(employee1.getAge() == employee2.getAge()) //checks to see if the employees are the same age
					return 0;
					else
					{
						return (employee1.getAge() - employee2.getAge() > 0) ? 1 : -1;
					}
			case "name":
				if(employee1.getName().equalsIgnoreCase(employee2.getName()))
					return 0;
					else
					{
						return (employee1.getName().compareTo(employee2.getName()) > 0) ? 1 : -1;
					}
			case "department":
				if(employee1.getDepartment().equalsIgnoreCase(employee2.getDepartment()))
					return 0;
					else
					{
						return (employee1.getDepartment().compareTo(employee2.getDepartment()) > 0) ? 1 : -1;
					}
			default:
			{
				System.out.println("You cannot sort by that type!");
//				compare(employee1,employee2);
				break;
			}
		}
		return 0;
		
	}
	
	
	
	
}
