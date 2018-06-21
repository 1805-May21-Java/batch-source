package com.revature.pojos;

import java.util.*;

import com.revature.daos.*;

public class Employee
{
	private int id;
	private String firstName;
	private String lastName;
	private String email;
	private String password;
	private Employee manager;
	private EmployeeDaoImpl edi = new EmployeeDaoImpl();
	
	public Employee()
	{
		super();
		// TODO Auto-generated constructor stub
	}

	public Employee(int id, String firstName, String lastName, String email, String password, Employee manager,
			EmployeeDaoImpl edi)
	{
		super();
		this.id = id;
		this.firstName = firstName;
		this.lastName = lastName;
		this.email = email;
		this.password = password;
		this.manager = manager;
		this.edi = edi;
	}
	
	public Employee(int id, String firstName, String lastName, String email, String password, Employee manager)
	{
		super();
		this.id = id;
		this.firstName = firstName;
		this.lastName = lastName;
		this.email = email;
		this.password = password;
		this.manager = manager;
	}

	public Employee(int id, String firstName, String lastName, String email, String password)
	{
		super();
		this.id = id;
		this.firstName = firstName;
		this.lastName = lastName;
		this.email = email;
		this.password = password;
		this.manager = null;
	}

	public int getId()
	{
		return id;
	}

	public void setId(int id)
	{
		this.id = id;
	}

	public String getFirstName()
	{
		return firstName;
	}

	public void setFirstName(String firstName)
	{
		this.firstName = firstName;
	}

	public String getLastName()
	{
		return lastName;
	}

	public void setLastName(String lastName)
	{
		this.lastName = lastName;
	}

	public String getEmail()
	{
		return email;
	}

	public void setEmail(String email)
	{
		this.email = email;
	}

	public String getPassword()
	{
		return password;
	}

	public void setPassword(String password)
	{
		this.password = password;
	}

	public Employee getManager()
	{
		return manager;
	}

	public void setManager(Employee manager)
	{
		this.manager = manager;
	}
	
	@Override
	public int hashCode()
	{
		final int prime = 31;
		int result = 1;
		result = prime * result + ((edi == null) ? 0 : edi.hashCode());
		result = prime * result + ((email == null) ? 0 : email.hashCode());
		result = prime * result + ((firstName == null) ? 0 : firstName.hashCode());
		result = prime * result + id;
		result = prime * result + ((lastName == null) ? 0 : lastName.hashCode());
		result = prime * result + ((manager == null) ? 0 : manager.hashCode());
		result = prime * result + ((password == null) ? 0 : password.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj)
	{
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Employee other = (Employee) obj;
		return this.id == other.getId();
	}
	
	@Override
	public String toString()
	{
		return "Employee [id=" + id + ", firstName=" + firstName + ", lastName=" + lastName + ", email=" + email
				+ ", password=" + password + ", manager=" + manager + ", edi=" + edi + "]";
	}

	public List<Employee> managedEployees()
	{
		List<Employee> results = new ArrayList<Employee>();
		List<Employee> employees = edi.getAllEmployees();
		
		if(employees != null)
		{
			for(Employee employee : employees)
			{
				if(employee.getManager() != null && employee.getManager().getId() == this.id)
				{
					results.add(employee);
				}
			}
		}
		
		return results;
	}
	
	public boolean isManager()
	{
		return (this.managedEployees() != null && this.managedEployees().size() != 0);
	}
	
	public boolean isHeadHoncho() {
		return this.manager == null;
	}
}
