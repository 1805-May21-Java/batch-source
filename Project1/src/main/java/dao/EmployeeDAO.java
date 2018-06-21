package dao;

import java.util.ArrayList;

import model.Employee;

public interface EmployeeDAO {

	public Employee getEmployeeById(int id);
	public Employee getEmployeeByEmail(String email);
	public ArrayList<Employee> getEmployees();
	public ArrayList<Employee> getEmployeesByManager(int id);
	public int getEmployeeIdByEmail(String email);
	public void updateEmployee(int id, String email, String firstname, String lastname, String phone);
}
