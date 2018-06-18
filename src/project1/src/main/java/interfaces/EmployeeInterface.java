package interfaces;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;

import data.Employee;

public interface EmployeeInterface {
	long createEmployee(Connection connection, long employeeId, long reportsTo, String employeeName, String password, String username) throws SQLException;
	long createEmployee(Connection connection, long employeeId, String employeeName, String password, String username) throws SQLException;
	boolean checkEmployee(Connection connection, String username) throws SQLException;
	Employee getEmployeeById(Connection connection, long employeeId) throws SQLException;
	Employee getEmployeeByName(Connection connection, String username) throws SQLException;
	void updateEmployeePassword(Connection connection, long employeeId, String newPassword) throws SQLException;
	ArrayList<Employee> getAllEmployee(Connection connection) throws SQLException;
}
