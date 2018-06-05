package com.revature.dao;

import java.util.List;

import com.revature.pojos.Department;

public interface DepartmentDAO {

	public List<Department> getDepartments();
	public Department getDepartmentById(int id);
	public void increaseBudget(int dept, int val);
}
