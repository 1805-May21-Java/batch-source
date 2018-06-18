package com.revature.dao;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import com.revature.pojos.Reimbursement;
import com.revature.util.ConnectionUtil;

public class ReimbursementDaoImpl implements ReimbursementDao{
	
	
	
	public List<Reimbursement> getReimbursements() {
		

		List<Reimbursement> reimbursementData = new ArrayList<Reimbursement>();
		//try/catch block is used to catch any possible IOException and SQLException
		try {
			//Connection con is used to create a Statement instance
			//using String sql to retrieve all rows from table EMPLOYEE
			Connection con = ConnectionUtil.getConnection();
			String sql = "SELECT * FROM REIMBURSEMENT";
			//Uses Statement
			Statement s = con.createStatement();
			//ResultSet rs stores result of Statement
			ResultSet rs = s.executeQuery(sql);
			//rs is iterated over and values are retrieved and stored into
			//HashMap employeeData
			while(rs.next()) {
				Integer reimbursementId = rs.getInt("REIMBURSEMENT_ID");
				Double money = rs.getDouble("MONEY");
				Integer employeeId = rs.getInt("EMPLOYEE_ID");
				String status = rs.getString("STATUS");
				Integer reviewerId = rs.getInt("REVIEWER_ID");
				reimbursementData.add(new Reimbursement(reimbursementId,
						money, employeeId, status, reviewerId));
				
			}
			
		} catch (IOException e) {
			
			e.printStackTrace();
		} catch (SQLException e) {
			
			e.printStackTrace();
		}

		return reimbursementData;
	}

	public Reimbursement getReimbursementById(Integer id) {	
		Reimbursement user = null;
		
		try {
			Connection con = ConnectionUtil.getConnection();
			String sql = "SELECT * FROM REIMBURSEMENT WHERE REIMBURSEMENT_ID = ?";
			//PreparedStatement is created using the Connection con
			PreparedStatement ps = con.prepareStatement(sql);
			//PreparedStatment is passed username and then executed.
			ps.setInt(1, id);
			ResultSet rs = ps.executeQuery();
			//Result set is iterated and data retrieved to create a 
			//new Account object.
			while(rs.next()) {
				Integer reimbursementId = rs.getInt("REIMBURSEMENT_ID");
				double money = rs.getDouble("MONEY");
				int employeeId = rs.getInt("EMPLOYEE_ID");
				String status = rs.getString("STATUS");
				int reviewerId = rs.getInt("REVIEWER_ID");
				user = new Reimbursement(reimbursementId, money, employeeId, 
						status, reviewerId);
			}
			
		} catch (IOException e) {
			
			e.printStackTrace();
		} catch (SQLException e) {
			
			e.printStackTrace();
		}
		
		return user;
	}

	public int createReimbursement(Reimbursement form) {
		//This will return the number of rows created in the database.
		//Should return 1 if user account does not exist
		int reimbursementCreated = 0;
				
		try {
			//accountExist is created by calling getAccountByUsername
			//if object remains null, then it does not exist in the table.
			//else a print statement notifying the user of its existance is given.
			//Reimbursement formExist = getReimbursementById(form.getReimbursement_id());
			//if(formExist == null) {
				Connection con = ConnectionUtil.getConnection();
				con.setAutoCommit(false);
				String sql = "INSERT INTO REIMBURSEMENT(MONEY, EMPLOYEE_ID, STATUS) VALUES(?,?,?)";
				//Uses PreparedStatement to insert all values from newAccount
				//via the Getter methods.
				PreparedStatement pStatement = con.prepareStatement(sql);
				pStatement.setDouble(1, form.getMoney());
				pStatement.setInt(2, form.getEmployee_id());
				pStatement.setString(3, form.getStatus());
				//PreparedStatement is then executed
				reimbursementCreated = pStatement.executeUpdate();
				con.commit();
				//}else {
				//	System.out.println("Reimbursement already exist in the database");
				//	}	
			} catch (IOException e) {
					e.printStackTrace();
			} catch (SQLException e) {
					e.printStackTrace();
				}
		//number of rows created is returned.
		return reimbursementCreated;
	}

	public int deleteReimbursementById(Integer id) {
		int reimbursementsDeleted = 0;
		
		try {
			Connection con = ConnectionUtil.getConnection();
			//Auto commit set to false to prevent uncalled commits
			con.setAutoCommit(false);
			String sql = "DELETE FROM REIMBURSEMENT WHERE REIMBURSEMENT_ID = ?";
			//Used PreparedStatement and filled the ? with id.
			PreparedStatement pStatement = con.prepareStatement(sql);
			pStatement.setInt(1, id);
			//PreparedStatement is executed and committed
			reimbursementsDeleted = pStatement.executeUpdate();
			con.commit();
		} catch (IOException e) {
			
			e.printStackTrace();
		} catch (SQLException e) {
			
			e.printStackTrace();
		}
		//returns number of rows deleted from database
		return reimbursementsDeleted;
	}

	public int updateReimbursement(Reimbursement current) {
		int reimbursementsUpdated = 0;
		try {
			Connection con = ConnectionUtil.getConnection();
			//Auto commit is set to false to prevent uncalled commits
			con.setAutoCommit(false);
			String sql = "UPDATE REIMBURSEMENT "
					+ "SET STATUS = ?, "
					+ "REVIEWER_ID = ?"
					+ " WHERE REIMBURSEMENT_ID = ?";
			//Used PreparedStatement and filled it with values from current
			PreparedStatement pStatement = con.prepareStatement(sql);
			pStatement.setString(1, current.getStatus());
			pStatement.setInt(2, current.getReviewer_id());
			pStatement.setInt(3, current.getReimbursement_id());
			//PreparedStatment is executed and commited.
			reimbursementsUpdated = pStatement.executeUpdate();
			con.commit();
		} catch (IOException e) {
			
			e.printStackTrace();
		} catch (SQLException e) {
			
			e.printStackTrace();
		}
		//returns number of rows updated in the database.
		return reimbursementsUpdated;
	}

	public List<Reimbursement> getPendingByEmployeeId(Integer employeeId) {
		
		List<Reimbursement> viewReimbursements = new ArrayList<Reimbursement>();
		//try/catch block is used to catch any possible IOException and SQLException
		try {
			//Connection con is used to create a Statement instance
			//using String sql to retrieve all rows from table EMPLOYEE
			Connection con = ConnectionUtil.getConnection();
			//String sql = "SELECT REIMBURSEMENT_ID, MONEY, EMPLOYEE_ID, STATUS "
			//		+"FROM REIMBURSEMENT WHERE EMPLOYEE_ID = ? "
			//		+ "AND STATUS = 'Pending'";
			String sql = "SELECT REIMBURSEMENT_ID, MONEY, STATUS "
					+ "FROM REIMBURSEMENT WHERE EMPLOYEE_ID = ? "
					+ "AND STATUS = 'Pending'";
			//Uses PreparedStatement
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setInt(1, employeeId);
			//ps.setString(2, status);
			//ResultSet rs stores result of Statement
			//use .executeQuery() for PreparedStatments
			//use .executeQuery(String arg) for Statement
			ResultSet rs = ps.executeQuery();
			//rs is iterated over and values are retrieved and stored into
			//HashMap employeeData
			while(rs.next()) {
				Integer reimbursementId = rs.getInt("REIMBURSEMENT_ID");
				Double money = rs.getDouble("MONEY");
				//Integer employee_Id = rs.getInt("EMPLOYEE_ID");
				String status = rs.getString("STATUS");
				//Integer reviewerId = rs.getInt("REVIEWER_ID");
				//Integer reviewerId = rs.getInt("REVIEWER_ID");
				viewReimbursements.add(new Reimbursement(reimbursementId,
						money, employeeId,status, null));
				
			}
			
			
		} catch (IOException e) {
			
			e.printStackTrace();
		} catch (SQLException e) {
			
			e.printStackTrace();
		}

		return viewReimbursements;
	}

	public List<Reimbursement> getResolvedByEmployeeId(Integer employeeId) {
		
		List<Reimbursement> viewReimbursements = new ArrayList<Reimbursement>();
		//try/catch block is used to catch any possible IOException and SQLException
		try {
			//Connection con is used to create a Statement instance
			//using String sql to retrieve all rows from table EMPLOYEE
			Connection con = ConnectionUtil.getConnection();
			//String sql = "SELECT REIMBURSEMENT_ID, MONEY, EMPLOYEE_ID, STATUS "
			//		+"FROM REIMBURSEMENT WHERE EMPLOYEE_ID = ? "
			//		+ "AND STATUS = 'Pending'";
			String sql = "SELECT REIMBURSEMENT_ID, MONEY, STATUS, REVIEWER_ID "
					+ "FROM REIMBURSEMENT WHERE EMPLOYEE_ID = ? "
					+ "AND STATUS != 'Pending'";
			//Uses PreparedStatement
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setInt(1, employeeId);
			//ps.setString(2, status);
			//ResultSet rs stores result of Statement
			//use .executeQuery() for PreparedStatments
			//use .executeQuery(String arg) for Statement
			ResultSet rs = ps.executeQuery();
			//rs is iterated over and values are retrieved and stored into
			//HashMap employeeData
			while(rs.next()) {
				Integer reimbursementId = rs.getInt("REIMBURSEMENT_ID");
				Double money = rs.getDouble("MONEY");
				//Integer employee_Id = rs.getInt("EMPLOYEE_ID");
				String status = rs.getString("STATUS");
				Integer reviewerId = rs.getInt("REVIEWER_ID");
				//Integer reviewerId = rs.getInt("REVIEWER_ID");
				viewReimbursements.add(new Reimbursement(reimbursementId,
						money, employeeId, status, reviewerId));
				
			}
			
			
		} catch (IOException e) {
			
			e.printStackTrace();
		} catch (SQLException e) {
			
			e.printStackTrace();
		}

		return viewReimbursements;
	}

	@Override
	public List<Reimbursement> getReimbursementByEmployeeId(Integer employeeId) {
		List<Reimbursement> viewReimbursements = new ArrayList<Reimbursement>();
		//try/catch block is used to catch any possible IOException and SQLException
		try {
			//Connection con is used to create a Statement instance
			//using String sql to retrieve all rows from table EMPLOYEE
			Connection con = ConnectionUtil.getConnection();
			//String sql = "SELECT REIMBURSEMENT_ID, MONEY, EMPLOYEE_ID, STATUS "
			//		+"FROM REIMBURSEMENT WHERE EMPLOYEE_ID = ? "
			//		+ "AND STATUS = 'Pending'";
			String sql = "SELECT REIMBURSEMENT_ID, MONEY, STATUS "
					+ "FROM REIMBURSEMENT WHERE EMPLOYEE_ID = ?";
			//Uses PreparedStatement
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setInt(1, employeeId);
			//ps.setString(2, status);
			//ResultSet rs stores result of Statement
			//use .executeQuery() for PreparedStatments
			//use .executeQuery(String arg) for Statement
			ResultSet rs = ps.executeQuery();
			//rs is iterated over and values are retrieved and stored into
			//HashMap employeeData
			while(rs.next()) {
				Integer reimbursementId = rs.getInt("REIMBURSEMENT_ID");
				Double money = rs.getDouble("MONEY");
				//Integer employee_Id = rs.getInt("EMPLOYEE_ID");
				String status = rs.getString("STATUS");
				//Integer reviewerId = rs.getInt("REVIEWER_ID");
				//Integer reviewerId = rs.getInt("REVIEWER_ID");
				viewReimbursements.add(new Reimbursement(reimbursementId,
						money, employeeId,status, null));
				
			}
			
			
		} catch (IOException e) {
			
			e.printStackTrace();
		} catch (SQLException e) {
			
			e.printStackTrace();
		}

		return viewReimbursements;
	}
	
	
	

}
