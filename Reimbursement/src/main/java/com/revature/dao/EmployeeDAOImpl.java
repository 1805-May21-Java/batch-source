package com.revature.dao;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import com.revature.pojos.*;

public interface EmployeeDAOImpl {
	public List<employee> getEmployees();
	public employee getEmployeeByID(int e_Id);
	public int createEmployee(employee emp);
	public int updateInfo(employee emp);
	public int removeEmp(int e_Id);
}

