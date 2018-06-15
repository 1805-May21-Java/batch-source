package com.revature.daos;

import java.io.*;
import java.sql.*;
import java.util.*;

import com.revature.pojos.*;
import com.revature.util.ConnectionUtil;

public class ReimbursementRequestDaoImpl implements ReimbursementRequestDao
{
	EmployeeDaoImpl edi = new EmployeeDaoImpl();
	
	@Override
	public ReimbursementRequest getRiRbyID(int rirId)
	{
		try
		{
			Connection con = ConnectionUtil.getConnection();
			String sql = "SELECT * FROM RIR WHERE RIR_ID=?";
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setInt(1, rirId);
			ResultSet rs = ps.executeQuery();
			int empId = 0;
			ReimbursementRequest rir = null;
			int approverId = 0;
			Employee approver = null;
			
			while(rs.next())
			{
				empId = rs.getInt("EMP_ID");
				boolean isPending = (rs.getInt("IS_PENDING") != 0);
				String description = rs.getString("DESCRIPTION");
				double value = rs.getDouble("VALUE");
				if(!isPending) {
					approverId = rs.getInt("APPROVER");
				}
				rir = new ReimbursementRequest(rirId, null, isPending, description, value, approver);
			}
			
			con.close();
			
			rir.setEmployeeId(edi.getEmployeeById(empId));
			rir.setApproverId(edi.getEmployeeById(approverId));
			return rir;
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
	public List<ReimbursementRequest> getRiRsByEmpId(int empId)
	{
		ArrayList<ReimbursementRequest> result = new ArrayList<ReimbursementRequest>();
		Employee employee = edi.getEmployeeById(empId);
		
		try
		{
			Connection con = ConnectionUtil.getConnection();
			String sql = "SELECT * FROM RIR WHERE EMP_ID=?";
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setInt(1, empId);
			ResultSet rs = ps.executeQuery();
			ArrayList<Integer> approverIds = new ArrayList<Integer>();
			
			while(rs.next()) {
				int rirId = rs.getInt("RIR_ID");
				boolean isPending = (rs.getInt("IS_PENDING") != 0);
				String description = rs.getString("DESCRIPTION");
				double value = rs.getDouble("VALUE");
				int approverId = rs.getInt("APPROVER");
				approverIds.add(approverId);
				result.add(new ReimbursementRequest(rirId, employee, isPending, description, value, null));
			}
			
			con.close();
			
			for(int i = 0; i < result.size(); i++)
			{
				int id = approverIds.get(i);
				if(id == 0)
				{
					result.get(i).setApproverId(null);
				}
				else
				{
					result.get(i).setApproverId(edi.getEmployeeById(id));
				}
			}
		}
		catch (IOException e)
		{
			e.printStackTrace();
		}
		catch (SQLException e)
		{
			e.printStackTrace();
		}
		
		return result;
	}

	@Override
	public void createRiR(int empId, String description, double value)
	{
		try
		{
			Connection con = ConnectionUtil.getConnection();
			String sql = "INSERT INTO RIR (EMP_ID, IS_PENDING, DESCRIPTION, VALUE) VALUES (?, ?, ?, ?)";
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setInt(1, empId);
			ps.setInt(2, 1);
			ps.setString(3, description);
			ps.setDouble(4, value);
			
			ps.executeUpdate();
			
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
	}

	@Override
	public void approveRiR(int rirId, int managerId)
	{
		try
		{
			Connection con = ConnectionUtil.getConnection();
			String sql = "UPDATE RIR SET IS_PENDING=0, APPROVER=? WHERE RIR_ID=?";
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setInt(1, managerId);
			ps.setInt(2, rirId);
			ps.executeUpdate();
			
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
	}

}
