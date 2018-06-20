package com.revature.pojos;

import java.util.ArrayList;

import com.revature.dao.DaoEmployeeImpl;

public class Manager extends Employee {
	
	ArrayList<Employee> employeeList;
	
	private static DaoEmployeeImpl daoEmployeeImpl = new DaoEmployeeImpl();
	
	public Manager(ArrayList<Employee> employeeList) {
		super();
		this.employeeList = employeeList;
	}

	public Manager() {
		super();
	}
	
	
	public Manager(int id, String name, String email, String password, int managerId) {
		super(id, name, email, password, managerId);
	}

	public Manager(int id, String name, String email, String password) {
		super(id, name, email, password);
	}

	public Manager(String name, String email, String password, int managerId) {
		super(name, email, password, managerId);
	}

	public Manager(String name, String email, String password) {
		super(name, email, password);
	}

	public ArrayList<Employee> getEmployeeList() {
		return employeeList;
	}

	public void setEmployeeList(ArrayList<Employee> employeeList) {
		this.employeeList = employeeList;
	}

	public ArrayList<Employee> getEmployeesUnderManager(){
		 return daoEmployeeImpl.getEmployeesByManagerId(this.idNumber);
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = super.hashCode();
		result = prime * result + ((employeeList == null) ? 0 : employeeList.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (!super.equals(obj))
			return false;
		if (getClass() != obj.getClass())
			return false;
		Manager other = (Manager) obj;
		if (employeeList == null) {
			if (other.employeeList != null)
				return false;
		} else if (!employeeList.equals(other.employeeList))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Manager [employeeList=" + employeeList + ", employeeReimbursements=" + employeeReimbursements
				+ ", managerId=" + managerId + ", IdNumber=" + idNumber + ", name=" + name + ", email=" + email
				+ ", password=" + password + "]";
	}
	
}
