package com.revature.pojos;

import java.util.ArrayList;

public class Employee extends Worker {

	ArrayList<Reimbursement> employeeReimbursements;

	public Employee() {
		super();
	}

	public Employee(String name, String email, String password) {
		super(name, email, password);
	}
	
	public Employee(int id, String name, String email, String password) {
		super(id, name, email, password);
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
		int result = super.hashCode();
		result = prime * result + ((employeeReimbursements == null) ? 0 : employeeReimbursements.hashCode());
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
		Employee other = (Employee) obj;
		if (employeeReimbursements == null) {
			if (other.employeeReimbursements != null)
				return false;
		} else if (!employeeReimbursements.equals(other.employeeReimbursements))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Employee [employeeReimbursements=" + employeeReimbursements + "]";
	}
	
	
}
