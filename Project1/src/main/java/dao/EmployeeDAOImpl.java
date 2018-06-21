package dao;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import model.Employee;
import model.Manager;
import utilities.ConnectionUtil;

public class EmployeeDAOImpl implements EmployeeDAO {

	public Employee getEmployeeById(int empId) {
		Employee e1 = new Employee();
		try {
			Connection con = ConnectionUtil.getConnection();
			String sql = "SELECT * FROM EMPLOYEE WHERE EMP_ID = ?";
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setInt(1, empId);
			ResultSet rs = ps.executeQuery();
			
			while(rs.next()) {
				int id = rs.getInt("EMP_ID");
				String email = rs.getString("EMP_EMAIL");
				String password = rs.getString("EMP_PASSWORD");
				String firstName = rs.getString("EMP_FIRSTNAME");
				String lastName = rs.getString("EMP_LASTNAME");
				String phone = rs.getString("EMP_PHONE");
				String title = rs.getString("EMP_TITLE");
				String department = rs.getString("EMP_DEPARTMENT");
				long salary = rs.getLong("EMP_SALARY");
				int manId = rs.getInt("MANAGER_ID");
				
				e1 = new Employee(id, email, password, firstName, lastName, phone, title, department, salary, manId);
				//System.out.println(e1);
			}
			
			
		} catch (IOException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return e1;
	}

	public Employee getEmployeeByEmail(String empEmail) {
		Employee e1 = new Employee();
		try {
			Connection con = ConnectionUtil.getConnection();
			String sql = "SELECT * FROM EMPLOYEE WHERE EMP_EMAIL = ?";
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setString(1, empEmail);
			ResultSet rs = ps.executeQuery();
			
			while(rs.next()) {
				int id = rs.getInt("EMP_ID");
				String email = rs.getString("EMP_EMAIL");
				String password = rs.getString("EMP_PASSWORD");
				String firstName = rs.getString("EMP_FIRSTNAME");
				String lastName = rs.getString("EMP_LASTNAME");
				String phone = rs.getString("EMP_PHONE");
				String title = rs.getString("EMP_TITLE");
				String department = rs.getString("EMP_DEPARTMENT");
				long salary = rs.getLong("EMP_SALARY");
				int manId = rs.getInt("MANAGER_ID");
				
				e1 = new Employee(id, email, password, firstName, lastName, phone, title, department, salary, manId);
				//System.out.println(e1);
			}
			
			
		} catch (IOException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return e1;
	}

	public void updateEmployee(int id, String email, String firstname, String lastname, String phone) {
		
		try {
			Connection con = ConnectionUtil.getConnection();
			String sql = "UPDATE EMPLOYEE SET EMP_EMAIL = ?, EMP_FIRSTNAME = ?, EMP_LASTNAME = ?, EMP_PHONE = ? WHERE EMP_ID = ?";
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setString(1, email);
			ps.setString(2, firstname);
			ps.setString(3, lastname);
			ps.setString(4, phone);
			ps.setInt(5, id);
			ResultSet rs = ps.executeQuery();
			
			System.out.println("updated");
			
			
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
	}

	public ArrayList<Employee> getEmployees() {
		ArrayList<Employee> employees = new ArrayList<Employee>();
		
		try {
			Connection con = ConnectionUtil.getConnection();
			String sql = "SELECT * FROM EMPLOYEE";
			PreparedStatement ps = con.prepareStatement(sql);
			ResultSet rs = ps.executeQuery();
			
			while(rs.next()) {
				int id = rs.getInt("EMP_ID");
				String email = rs.getString("EMP_EMAIL");
				String password = rs.getString("EMP_PASSWORD");
				String firstName = rs.getString("EMP_FIRSTNAME");
				String lastName = rs.getString("EMP_LASTNAME");
				String phone = rs.getString("EMP_PHONE");
				String title = rs.getString("EMP_TITLE");
				String department = rs.getString("EMP_DEPARTMENT");
				long salary = rs.getLong("EMP_SALARY");
				int manId = rs.getInt("MANAGER_ID");
				
				employees.add(new Employee(id, email, password, firstName, lastName, phone, title, department, salary, manId));
			}
			
			
		} catch (IOException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return employees;
	}

	public ArrayList<Employee> getEmployeesByManager(int manId) {
		ArrayList<Employee> employees = new ArrayList<Employee>();
		
		try {
			Connection con = ConnectionUtil.getConnection();
			String sql = "SELECT * FROM EMPLOYEE WHERE MANAGER_ID = ?";
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setInt(1, manId);
			ResultSet rs = ps.executeQuery();
			
			while(rs.next()) {
				int id = rs.getInt("EMP_ID");
				String email = rs.getString("EMP_EMAIL");
				String password = rs.getString("EMP_PASSWORD");
				String firstName = rs.getString("EMP_FIRSTNAME");
				String lastName = rs.getString("EMP_LASTNAME");
				String phone = rs.getString("EMP_PHONE");
				String title = rs.getString("EMP_TITLE");
				String department = rs.getString("EMP_DEPARTMENT");
				long salary = rs.getLong("EMP_SALARY");
				int managerId = rs.getInt("MANAGER_ID");
				
				employees.add(new Employee(id, email, password, firstName, lastName, phone, title, department, salary, managerId));
			}
			
		} catch (IOException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return employees;
	}

	@Override
	public int getEmployeeIdByEmail(String email) {
		int id = 0;
		
		try {
			Connection con = ConnectionUtil.getConnection();
			String sql = "SELECT EMP_ID FROM EMPLOYEE WHERE EMP_EMAIL = ?";
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setString(1, email);
			ResultSet rs = ps.executeQuery();
			
			while(rs.next()) {
				 id = rs.getInt("EMP_ID");
				
				System.out.println(id);
			}
			
			
		} catch (IOException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return id;
	}

}
