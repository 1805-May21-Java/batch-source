package com.revature.daos;

import java.io.IOException;
import java.sql.*;
import java.util.*;

import com.revature.pojos.Employee;
import com.revature.util.*;

public class EmployeeDaoImpl implements EmployeeDao
{
	public EmployeeDaoImpl()
	{
		super();
	}

	@Override
	public Employee getEmployeeById(int id)
	{
		try
		{
			Connection con = ConnectionUtil.getConnection();
			String sql = "SELECT * FROM EMPLOYEE WHERE EMP_ID=?";
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setInt(1, id);
			
			ResultSet rs = ps.executeQuery();
			while(rs.next())
			{
				String firstname = rs.getString("FNAME");
				String lastname = rs.getString("LNAME");
				String email = rs.getString("EMAIL");
				String password = rs.getString("PWORD");
				int managerID = rs.getInt("MANAGER_ID");
				Employee manager = this.getEmployeeById(managerID);
				return new Employee(id, firstname, lastname, email, password, manager);
			}
			
			con.close();
		}
		catch (IOException e)
		{
			e.printStackTrace();
		}
		catch (SQLException e)
		{
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public Employee getEmployeeByCredentials(String email, String pass)
	{
		try
		{
			Connection con = ConnectionUtil.getConnection();
			String sql = "SELECT * FROM EMPLOYEE WHERE EMAIL=? AND PWORD=?";
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setString(1, email);
			ps.setString(2, pass);
			
			ResultSet rs = ps.executeQuery();
			while(rs.next())
			{
				int id = rs.getInt("EMP_ID");
				String firstname = rs.getString("FNAME");
				String lastname = rs.getString("LNAME");
				int managerId = rs.getInt("MANAGER_ID");
				Employee manager = this.getEmployeeById(managerId);
				return new Employee(id, firstname, lastname, email, pass, manager);
			}
			
			con.close();
		}
		catch (IOException e)
		{
			e.printStackTrace();
		}
		catch (SQLException e)
		{
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public List<Employee> getAllEmployees()
	{
		ArrayList<Employee> results = new ArrayList<Employee>();

		try
		{
			Connection con = ConnectionUtil.getConnection();
			String sql = "SELECT * FROM EMPLOYEE";
			Statement s = con.createStatement();
			ResultSet rs = s.executeQuery(sql);
			
			while(rs.next())
			{
				int id = rs.getInt("EMP_ID");
				String firstname = rs.getString("FNAME");
				String lastname = rs.getString("LNAME");
				String email = rs.getString("EMAIL");
				String password = rs.getString("PWORD");
				int managerId = rs.getInt("MANAGER_ID");
				Employee manager;
				if(managerId != 0) {
					manager = getEmployeeById(managerId);
				}
				else {
					manager = null;
				}
				results.add(new Employee(id, firstname, lastname, email, password, manager));
			}
			
			con.close();
		}
		catch (IOException e)
		{
			e.printStackTrace();
		}
		catch (SQLException e)
		{
			e.printStackTrace();
		}
		return results;
	}

	@Override
	public boolean isValidLogin(String email, String pass)
	{
		return this.getEmployeeByCredentials(email, pass) != null;
	}

	@Override
	public void updateEmployee(Employee emp)
	{
		try
		{
			Connection con = ConnectionUtil.getConnection();
			String sql = "UPDATE EMPLOYEE SET FNAME=?, LNAME=?, EMAIL=?, PWORD=? WHERE EMP_ID=?";
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setString(1, emp.getFirstName());
			ps.setString(2, emp.getLastName());
			ps.setString(3, emp.getEmail());
			ps.setString(4, emp.getPassword());
			ps.setInt(5, emp.getId());
			
			ps.executeUpdate();
			
			con.close();
		}
		catch (IOException e)
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		catch (SQLException e)
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
