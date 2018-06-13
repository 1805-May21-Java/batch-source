package com.revature.dao;

import java.util.List;

import com.revature.pojos.Department;

public interface DepartmentDao {
	
	public List<Department> getDepartments();
	public Department getDepartmentById(int id);
	public Department getDepartmentByName(String name);
	public int createDepartment(Department department);
	public int updateDepartment(Department department);
	public int deleteDepartmentById(int id);
	public void increaseBudget(int dept, int val);

}
