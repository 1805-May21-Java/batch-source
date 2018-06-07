package com.revature.pojos;

import java.util.ArrayList;

public class Manager extends Worker {
	ArrayList<Employee> employees;
	ArrayList<Reimbursement> allPendingReimbursements;
	
	public Manager() {
		super();
	}
	public Manager(String name, String email, String password) {
		super(name, email, password);
	}
	public Manager(int id, String name, String email, String password) {
		super(id, name, email, password);
	}
	public ArrayList<Employee> getEmployees() {
		return employees;
	}
	public void setEmployees(ArrayList<Employee> employees) {
		this.employees = employees;
	}
	public ArrayList<Reimbursement> getAllPendingReimbursements() {
		return allPendingReimbursements;
	}
	public void setAllPendingReimbursements(ArrayList<Reimbursement> allPendingReimbursements) {
		this.allPendingReimbursements = allPendingReimbursements;
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = super.hashCode();
		result = prime * result + ((allPendingReimbursements == null) ? 0 : allPendingReimbursements.hashCode());
		result = prime * result + ((employees == null) ? 0 : employees.hashCode());
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
		if (allPendingReimbursements == null) {
			if (other.allPendingReimbursements != null)
				return false;
		} else if (!allPendingReimbursements.equals(other.allPendingReimbursements))
			return false;
		if (employees == null) {
			if (other.employees != null)
				return false;
		} else if (!employees.equals(other.employees))
			return false;
		return true;
	}
	@Override
	public String toString() {
		return "Manager [employees=" + employees + ", allPendingReimbursements=" + allPendingReimbursements + "]";
	}
	
	
	
}
