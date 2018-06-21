package com.revature.dao;

import java.io.IOException;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.revature.pojos.EmployeeInfo;
import com.revature.pojos.ManagerInfo;
import com.revature.pojos.ReimbursementInfo;
import com.revature.util.ConnectionUtil;

public class ERSDaoImpl implements ERSDao{

	public List<EmployeeInfo> empList() {
		//lists out all the employees out there
		List<EmployeeInfo> emplist = new ArrayList<EmployeeInfo>();
		try {
			Connection con = ConnectionUtil.getConnection();
			//set autocommit to false for everything
			con.setAutoCommit(false);
			//code to get them from sql database
			String sql = "SELECT * From EMPLOYEE";
			Statement s = con.createStatement();
			//set the result set equals to the execute
			ResultSet rs = s.executeQuery(sql);
			while(rs.next()) {
				//if there are matches, then copy all the columns that you need here
				int userid = rs.getInt("USERID");
				String username = rs.getString("USERNAME");
				String password = rs.getString("EMP_PASS");
				String name = rs.getString("FNAME") + " " +rs.getString("LNAME");
				Date birthday = rs.getDate("BIRTHDAY");
				String email = rs.getString("EMAIL");
				String phone = rs.getString("PHONE");
				String street = rs.getString("STREET");
				String city = rs.getString("CITY");
				String state = rs.getString("STATES");
				int zipcode = rs.getInt("POSTCODE");
				//add the EmployeeInfo class using the columns from sql, and put it in a list
				emplist.add(new EmployeeInfo(userid, username, password, name, email, phone, birthday, street, city, state, zipcode));
				con.commit();
			}	
		} catch (IOException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return emplist;
	}

	public int approve(int id, String name, Date aday) {
		//asks for the reimbursement id, manager's name that approved it, and the today's date
		int rApprove = 0;
		Connection con;
		try {
			//update the pending status of reimbursement to accept, and add value to manager and approve date column
			//based on the reimbursement id
			con = ConnectionUtil.getConnection();
			con.setAutoCommit(false);
			String sql = "UPDATE RR SET STATUS='APPROVED', MANAGERAPPROVED=?, APPROVE_DATE=? WHERE REIMBURSEMENT_ID=?";
			PreparedStatement ps = con.prepareStatement(sql);
			//set the info you have on the question marks
			ps.setString(1, name);
			ps.setDate(2, aday);
			ps.setInt(3, id);
			rApprove = ps.executeUpdate();
			con.commit();
			
		} catch (IOException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return rApprove;
	}

	public int deny(int id) {
		//similar to approve, but it denys instead, and because it is denying, it doesn't need manager info
		int rDeny = 0;
		Connection con;
		try {
			con = ConnectionUtil.getConnection();
			con.setAutoCommit(false);
			String sql = "UPDATE RR SET STATUS='DENIED' WHERE REIMBURSEMENT_ID=?";
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setInt(1, id);
			rDeny = ps.executeUpdate();
			con.commit();
			
		} catch (IOException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return rDeny;
	}

	public int submit(ReimbursementInfo ri) {
		//add a new reimbursement request to the database
		int rSubmitted = 0;
		Connection con;
		try {
			con = ConnectionUtil.getConnection();
			con.setAutoCommit(false);
			//reimbursement id is not needed because of trigger and sequence in the database
			String sql = "INSERT INTO RR (REQUESTER, REQUESTER_ID, TOTAL_AMOUNT, REASON, BILL_DATE, STATUS) VALUES (?,?,?,?,?,'PENDING')";
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setString(1, ri.getReqname());
			ps.setInt(2, ri.getRequesterid());
			ps.setDouble(3, ri.getTotalcost());
			ps.setString(4, ri.getReason());
			ps.setDate(5, (java.sql.Date) ri.getBillDate());
			rSubmitted = ps.executeUpdate();
			con.commit();
			
		} catch (IOException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return rSubmitted;
	}

	public List<ReimbursementInfo> viewPending() {
		List<ReimbursementInfo> riplist = new ArrayList<ReimbursementInfo>();
		//view all the reimbursement table where the status column equals to pending
		//this is for manager use
		try {
			Connection con = ConnectionUtil.getConnection();
			String sql = "SELECT * From RR WHERE STATUS='PENDING'";
			Statement s = con.createStatement();
			//set the result set equals to the execute
			ResultSet rs = s.executeQuery(sql);
			while(rs.next()) {
				int riid = rs.getInt("REIMBURSEMENT_ID");
				String req = rs.getString("REQUESTER");
				int reqid = rs.getInt("REQUESTER_ID");
				double total = rs.getDouble("TOTAL_AMOUNT");
				String reason = rs.getString("REASON");
				Date billday = rs.getDate("BILL_DATE");
				String status = rs.getString("STATUS");
				riplist.add(new ReimbursementInfo(riid, req, reason, total, reqid, billday, status));
			}	
		} catch (IOException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return riplist;
		
	}

	public List<ReimbursementInfo> viewEPending(int userid) {
		List<ReimbursementInfo> riplist = new ArrayList<ReimbursementInfo>();
		//similar to previous function, but added a new requirement that this must have
		//the same id as the user, this is for employee
		try {
			Connection con = ConnectionUtil.getConnection();
			String sql = "SELECT * From RR WHERE REQUESTER_ID=? AND STATUS='PENDING'";
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setInt(1, userid);
			//set the result set equals to the execute
			ResultSet rs = ps.executeQuery();
			while(rs.next()) {
				int riid = rs.getInt("REIMBURSEMENT_ID");
				String req = rs.getString("REQUESTER");
				int reqid = rs.getInt("REQUESTER_ID");
				double total = rs.getDouble("TOTAL_AMOUNT");
				String reason = rs.getString("REASON");
				Date billday = rs.getDate("BILL_DATE");
				String status = rs.getString("STATUS");
				riplist.add(new ReimbursementInfo(riid, req, reason, total, reqid, billday, status));
			}	
		} catch (IOException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return riplist;
		
	}

	public List<ReimbursementInfo> viewApproved() {
		List<ReimbursementInfo> rialist = new ArrayList<ReimbursementInfo>();
		//similar to view pending, but for manager approved instead
		try {
			Connection con = ConnectionUtil.getConnection();
			String sql = "SELECT * From RR WHERE STATUS='APPROVED'";
			Statement s = con.createStatement();
			//set the result set equals to the execute
			ResultSet rs = s.executeQuery(sql);
			while(rs.next()) {
				int riid = rs.getInt("REIMBURSEMENT_ID");
				String req = rs.getString("REQUESTER");
				int reqid = rs.getInt("REQUESTER_ID");
				double total = rs.getDouble("TOTAL_AMOUNT");
				String reason = rs.getString("REASON");
				Date billday = rs.getDate("BILL_DATE");
				Date approveday = rs.getDate("APPROVE_DATE");
				String manager = rs.getString("MANAGERAPPROVED");
				String status = rs.getString("STATUS");
				rialist.add(new ReimbursementInfo(riid, req, reason, total, reqid, billday, approveday, manager, status));
			}	
		} catch (IOException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return rialist;
	}

	public List<ReimbursementInfo> viewEApproved(int userid) {
		//similar to view pending, but for employee approved instead
		List<ReimbursementInfo> rialist = new ArrayList<ReimbursementInfo>();
		try {
			Connection con = ConnectionUtil.getConnection();
			String sql = "SELECT * From RR WHERE REQUESTER_ID=? AND STATUS='APPROVED'";
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setInt(1, userid);
			//set the result set equals to the execute
			ResultSet rs = ps.executeQuery();
			while(rs.next()) {
				int riid = rs.getInt("REIMBURSEMENT_ID");
				String req = rs.getString("REQUESTER");
				int reqid = rs.getInt("REQUESTER_ID");
				double total = rs.getDouble("TOTAL_AMOUNT");
				String reason = rs.getString("REASON");
				Date billday = rs.getDate("BILL_DATE");
				Date approveday = rs.getDate("APPROVE_DATE");
				String manager = rs.getString("MANAGERAPPROVED");
				String status = rs.getString("STATUS");
				rialist.add(new ReimbursementInfo(riid, req, reason, total, reqid, billday, approveday, manager, status));
			}	
		} catch (IOException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return rialist;
		
	}

	public List<ReimbursementInfo> viewAllRR(int userid) {
		//similar to all other view lists things, but this is for seeing all the reimbursement request from one user
		List<ReimbursementInfo> rilist = new ArrayList<ReimbursementInfo>();
		try {
			Connection con = ConnectionUtil.getConnection();
			con.setAutoCommit(false);
			String sql = "SELECT * From RR WHERE REQUESTER_ID=?";
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setInt(1, userid);
			//set the result set equals to the execute
			ResultSet rs = ps.executeQuery();
			while(rs.next()) {
				int riid = rs.getInt("REIMBURSEMENT_ID");
				String req = rs.getString("REQUESTER");
				int reqid = rs.getInt("REQUESTER_ID");
				double total = rs.getDouble("TOTAL_AMOUNT");
				String reason = rs.getString("REASON");
				Date billday = rs.getDate("BILL_DATE");
				String status = rs.getString("STATUS");
				rilist.add(new ReimbursementInfo(riid, req, reason, total, reqid, billday, status));
				con.commit();
			}	
		} catch (IOException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return rilist;
	}

	public EmployeeInfo findEmpByUP(String user, String pass) {
		//this is used to find the employee using username and password, mainly used in login
		EmployeeInfo ei = null;
		Connection con;
		try {
			con = ConnectionUtil.getConnection();
			//find all the users that matches this part(must be one)
			String sql = "SELECT * FROM EMPLOYEE WHERE USERNAME=? AND EMP_PASS=?";
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setString(1, user);
			ps.setString(2, pass);
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				//get the info and put it in a employeeinfo class, and return it out
				int userid = rs.getInt("USERID");
				String username = rs.getString("USERNAME");
				String password = rs.getString("EMP_PASS");
				String name = rs.getString("FNAME") + " " +rs.getString("LNAME");
				Date birthday = rs.getDate("BIRTHDAY");
				String email = rs.getString("EMAIL");
				String phone = rs.getString("PHONE");
				String street = rs.getString("STREET");
				String city = rs.getString("CITY");
				String state = rs.getString("STATES");
				int zipcode = rs.getInt("POSTCODE");
				ei = new EmployeeInfo(userid, username, password, name, email, phone, birthday, street, city, state, zipcode);
			}
			
		} catch (IOException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return ei;
	}

	public ManagerInfo findManByUP(String user, String pass) {
		ManagerInfo mi = null;
		//similar to find employee, but is finding manager instead
		Connection con;
		try {
			con = ConnectionUtil.getConnection();
			String sql = "SELECT * FROM MANAGER WHERE USERNAME=? AND MAN_PASS=?";
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setString(1, user);
			ps.setString(2, pass);
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				int manid = rs.getInt("MANAGER_ID");
				String username = rs.getString("USERNAME");
				String password = rs.getString("MAN_PASS");
				String name = rs.getString("FNAME") + " " +rs.getString("LNAME");
				Date birthday = rs.getDate("BIRTHDAY");
				String email = rs.getString("EMAIL");
				String phone = rs.getString("PHONE");
				String street = rs.getString("STREET");
				String city = rs.getString("CITY");
				String state = rs.getString("STATES");
				int zipcode = rs.getInt("POSTCODE");
				mi = new ManagerInfo(manid, name, username, password, email, phone, birthday, street, city, state, zipcode);
			}
			
		} catch (IOException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return mi;
	}

	@Override
	public int updateEmployee(EmployeeInfo ei) {
		//update the employee information, using the update function, set all the strings into the right ?
		int updateEmp = 0;
		Connection con;
		try {
			con = ConnectionUtil.getConnection();
			String name = ei.getName();
			int a = name.indexOf(" ");
			String fname = name.substring(0,a);
			String lname = name.substring(a+1);
			String sql = "UPDATE EMPLOYEE SET USERNAME=?, EMP_PASS=?, FNAME=?, LNAME=?, BIRTHDAY=?, EMAIL=?, PHONE=?, STREET=?,"
					+ "CITY=?, STATES=?, POSTCODE=? WHERE USERID=?";
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setString(1, ei.getUsername());
			ps.setString(2, ei.getPassword());
			ps.setString(3, fname);
			ps.setString(4, lname);
			ps.setDate(5, ei.getBirthday());
			ps.setString(6, ei.getEmail());
			ps.setString(7, ei.getPhone());
			ps.setString(8, ei.getStreet());
			ps.setString(9, ei.getCity());
			ps.setString(10, ei.getState());
			ps.setInt(11, ei.getZipcode());
			ps.setInt(12, ei.getUserid());
			updateEmp = ps.executeUpdate();
			//con.commit();
			
		} catch (IOException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return updateEmp;
	}

	@Override
	public int createEmployee(EmployeeInfo ei) {
		//this adds a new row to the employee table in the databas using insertinto function, similar to submit()
		int empCreated = 0;
		Connection con;
		try {
			con = ConnectionUtil.getConnection();
			con.setAutoCommit(false);
			String sql = "INSERT INTO Employee (USERNAME, EMP_PASS, FNAME, LNAME, BIRTHDAY, EMAIL, PHONE, STREET, CITY, STATES, POSTCODE) VALUES (?,?,?,?,?,?,?,?,?,?,?)";
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setString(1, ei.getUsername());
			ps.setString(2, ei.getPassword());
			String name = ei.getName();
			int a = name.indexOf(" ");
			String fname = name.substring(0,a);
			String lname = name.substring(a+1);
			ps.setString(3, fname);
			ps.setString(4, lname);
			ps.setDate(5, ei.getBirthday());
			ps.setString(6, ei.getEmail());
			ps.setString(7, ei.getPhone());
			ps.setString(8, ei.getStreet());
			ps.setString(9, ei.getCity());
			ps.setString(10, ei.getState());
			ps.setInt(11, ei.getZipcode());
			empCreated = ps.executeUpdate();
			con.commit();
			
		} catch (IOException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return empCreated;
	}

	@Override
	public String emailfromId(int id) {
		//getting the email of the user from the userid inputed
		String email = null;
		Connection con;
		
		try {
			con = ConnectionUtil.getConnection();
			con.setAutoCommit(false);
			String sql = "SELECT EMAIL FROM EMPLOYEE WHERE USERID=?";
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setInt(1, id);
			ResultSet rs = ps.executeQuery();
			while(rs.next()) {
				email = rs.getString("EMAIL");
			}
		} catch (IOException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return email;
	}

	@Override
	public int idfromId(int id) {
		//getting the user id from reimbursement table based on the reimbursement id
		int bid = 0;
		Connection con;
		
		try {
			con = ConnectionUtil.getConnection();
			con.setAutoCommit(false);
			String sql = "SELECT REQUESTER_ID FROM RR WHERE REIMBURSEMENT_ID=?";
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setInt(1, id);
			ResultSet rs = ps.executeQuery();
			while(rs.next()) {
				bid = rs.getInt("REQUESTER_ID");
			}
		} catch (IOException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return bid;
	}

}
