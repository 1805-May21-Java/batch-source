package com.revature.pojos;

import java.util.ArrayList;

import com.revature.dao.DaoEmployeeImpl;
import com.revature.dao.DaoReimbursementImpl;


public class Employee{

	private static DaoReimbursementImpl daoReimbursementImpl = new DaoReimbursementImpl();
	private static DaoEmployeeImpl daoEmployeeImpl = new DaoEmployeeImpl();
	protected ArrayList<Reimbursement> employeeReimbursements;
	protected int managerId;
	protected int idNumber;
	protected String name;
	protected String email;
	protected String password;
	
	public Employee() {
		super();
	}

	public Employee(String name, String email, String password) {
		super();
		this.name = name;
		this.email = email;
		this.password = password;
	}
	public Employee(String name, String email, String password,int managerId) {
		super();
		this.managerId = managerId;
		this.name = name;
		this.email = email;
		this.password = password;
	}
	
	public Employee(int id, String name, String email, String password) {
		super();
		this.idNumber = id;
		this.name = name;
		this.email = email;
		this.password = password;
	}
	public Employee(int id, String name, String email, String password,int managerId) {
		super();
		this.idNumber = id;
		this.managerId = managerId;
		this.name = name;
		this.email = email;
		this.password = password;
	}
	
	public ArrayList<Reimbursement> findEmpolyeeReimbursements() {
		//finds all reimbursements associated with an empolyee
		setEmployeeReimbursements(daoReimbursementImpl.getReimbursementByEmployee(this.idNumber));
		return getEmployeeReimbursements();
	}
	
	public ArrayList<Employee> getEmployeesUnderManager(){
		 return daoEmployeeImpl.getEmployeesByManagerId(this.idNumber);
	}

	public int getIdNumber() {
		return idNumber;
	}

	public void setIdNumber(int idNumber) {
		this.idNumber = idNumber;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public int getManagerId() {
		return managerId;
	}

	public void setManagerId(int managerId) {
		this.managerId = managerId;
	}

	public ArrayList<Reimbursement> getEmployeeReimbursements() {
		return employeeReimbursements;
	}

	public void setEmployeeReimbursements(ArrayList<Reimbursement> employeeReimbursements) {
		this.employeeReimbursements = employeeReimbursements;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + idNumber;
		result = prime * result + ((email == null) ? 0 : email.hashCode());
		result = prime * result + ((employeeReimbursements == null) ? 0 : employeeReimbursements.hashCode());
		result = prime * result + managerId;
		result = prime * result + ((name == null) ? 0 : name.hashCode());
		result = prime * result + ((password == null) ? 0 : password.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Employee other = (Employee) obj;
		if (idNumber != other.idNumber)
			return false;
		if (email == null) {
			if (other.email != null)
				return false;
		} else if (!email.equals(other.email))
			return false;
		if (employeeReimbursements == null) {
			if (other.employeeReimbursements != null)
				return false;
		} else if (!employeeReimbursements.equals(other.employeeReimbursements))
			return false;
		if (managerId != other.managerId)
			return false;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		if (password == null) {
			if (other.password != null)
				return false;
		} else if (!password.equals(other.password))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Employee [employeeReimbursements=" + employeeReimbursements + ", employeeList=" + ", managerId=" + managerId + ", IdNumber=" + idNumber + ", name=" + name + ", email=" + email
				+ ", password=" + password + "]";
	}
	
	
}
