package com.revature.dao;

import java.io.InputStream;
import java.io.OutputStream;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.revature.pojos.Reimbursement;
import com.revature.pojos.ReimbursementStatus;
import com.revature.pojos.ReimbursementType;
import com.revature.pojos.Role;
import com.revature.pojos.User;
import com.revature.util.ConnectionUtil;

public class FullDAOImpl implements FullDAO {

	@Override
	public User verify(String username, String password) {
		PreparedStatement ps = null; //initialize ps to null for now
		try(Connection con = ConnectionUtil.getConnection()){
			String sql = "SELECT * FROM ERS_USER WHERE USERNAME = ? AND PWORD = ?";
			ps = con.prepareStatement(sql);
			ps.setString(1, username);
			ps.setString(2, password);
			ResultSet rs = ps.executeQuery();
			if(rs.next()) {
				int id = rs.getInt("USER_ID");
				String fname = rs.getString("FNAME");
				String lname = rs.getString("LNAME");
				String email = rs.getString("EMAIL");
				Role r = Role.valueOf(rs.getInt("UR_ID"));
				return new User(id,username,fname,lname,email,r);
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public User getUserByName(String username) {
		//gets a user by the username ONLY, no password. Also doesn't add the user
		PreparedStatement ps = null;
		try(Connection con = ConnectionUtil.getConnection()){
			String sql = "SELECT * FROM ERS_USER WHERE USERNAME = ?";
			ps = con.prepareStatement(sql);
			ps.setString(1, username);
			ResultSet rs = ps.executeQuery();
			if(rs.next()) {
				int id = rs.getInt("USER_ID");
				String fname = rs.getString("FNAME");
				String lname = rs.getString("LNAME");
				String email = rs.getString("EMAIL");
				Role r = Role.valueOf(rs.getInt("UR_ID"));
				return new User(id,username,fname,lname,email,r);
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public boolean updateUser(User u) {
		PreparedStatement ps = null;
		try(Connection con = ConnectionUtil.getConnection()){
			con.setAutoCommit(false);
			String sql = "UPDATE ERS_USER SET USERNAME = ?, FNAME = ?, LNAME = ?, EMAIL = ? WHERE USER_ID = ?";
			ps = con.prepareStatement(sql);
			ps.setString(1, u.getUsername());
			ps.setString(2, u.getFname());
			ps.setString(3, u.getLname());
			ps.setString(4, u.getEmail());
			ps.setInt(5, u.getId());
			int affectedRows = ps.executeUpdate(); //rows will be affected
			con.commit();
			con.setAutoCommit(true);
			if(affectedRows > 0)
				return true;
			else
				return false;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return false;
	}

	@Override
	public boolean rejectRequest(int requester_id, int resolver_id) {
		PreparedStatement ps = null;
		try(Connection con = ConnectionUtil.getConnection()){
			con.setAutoCommit(false);
			String sql = "UPDATE REIMBURSEMENT SET RESOLVED = CURRENT_TIMESTAMP, RESOLVER_ID = ?, REI_STATUS = 2 WHERE REI_ID = ?";
			ps = con.prepareStatement(sql);
			ps.setInt(1, resolver_id);
			ps.setInt(2, requester_id);
			int rowCount = ps.executeUpdate();
			con.commit();
			con.setAutoCommit(true);
			if (rowCount > 0)
				return true;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return false;
	}

	@Override
	public boolean approveRequest(int requester_id, int resolver_id) {
		PreparedStatement ps = null;
		try(Connection con = ConnectionUtil.getConnection()){
			con.setAutoCommit(false);
			String sql = "UPDATE REIMBURSEMENT SET RESOLVED = CURRENT_TIMESTAMP, RESOLVER_ID = ?, REI_STATUS = 3 WHERE REI_ID = ?";
			ps = con.prepareStatement(sql);
			ps.setInt(1, resolver_id);
			ps.setInt(2, requester_id);
			int rowCount = ps.executeUpdate();
			con.commit();
			con.setAutoCommit(true);
			if (rowCount > 0)
				return true;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return false;
	}

	@Override
	public List<Reimbursement> getPendings(int emp_id) {
		PreparedStatement ps = null;
		try(Connection con = ConnectionUtil.getConnection()){
			String sql = "SELECT REI_ID, AMOUNT, DESCRIPT, RECEIPT, SUBMITTED, USER_ID, USERNAME, REI_TYPE, REI_STATUS " + 
					"FROM REIMBURSEMENT "+
					"INNER JOIN ERS_USER ON REQUESTER_ID = USER_ID" +
					"WHERE USER_ID = ? AND REI_STATUS = 1";
			ps = con.prepareStatement(sql);
			ps.setInt(1, emp_id);
			ResultSet rs = ps.executeQuery();
			List<Reimbursement> reimList = new ArrayList<Reimbursement>();
			while(rs.next()) {
				int rei_id = rs.getInt("REI_ID");
				double amount = rs.getDouble("AMOUNT");
				String descript = rs.getString("DESCRIPT");
				boolean receipt = rs.getBlob("RECEIPT") != null;
				Date submitted = rs.getDate("SUBMITTED");
				Date resolved = null; //remember these are pending requests
				int requester_id = rs.getInt("USER_ID");
				String requester_name = rs.getString("USERNAME");
				int resolver_id = -1; //-1 for no value here
				String resolver_name = null; // and again null
				ReimbursementType rt = ReimbursementType.valueOf(rs.getInt("REI_TYPE"));
				ReimbursementStatus rstat = ReimbursementStatus.valueOf(rs.getInt("REI_STATUS"));
				reimList.add(new Reimbursement(rei_id, amount, descript, receipt, submitted, resolved, requester_id, requester_name, resolver_id, resolver_name, rt, rstat));
			}
			return reimList;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public List<Reimbursement> getResolveds(int emp_id) {
		PreparedStatement ps = null;
		try(Connection con = ConnectionUtil.getConnection()){
			String sql = "SELECT REI_ID, AMOUNT, DESCRIPT, RECEIPT, SUBMITTED, RESOLVED, " +
					"U1.USER_ID, U1.USERNAME, U2.USER_ID AS MANAGER_ID, U2.USERNAME AS MANAGER_NAME, REI_TYPE, REI_STATUS " +
					"FROM REIMBURSEMENT " +
					"INNER JOIN ERS_USER U1 ON REQUESTER_ID = U1.USER_ID " +
					"INNER JOIN ERS_USER U2 ON RESOLVER_ID = U2.USER_ID" +
					"WHERE U1.USER_ID = ? AND (REI_STATUS = 2 OR REI_STATUS = 3)";		
			ps = con.prepareStatement(sql);
			ps.setInt(1, emp_id);
			ResultSet rs = ps.executeQuery();
			List<Reimbursement> reimList = new ArrayList<Reimbursement>();
			while(rs.next()) {
				int rei_id = rs.getInt("REI_ID");
				double amount = rs.getDouble("AMOUNT");
				String descript = rs.getString("DESCRIPT");
				boolean receipt = rs.getBlob("RECEIPT") != null;
				Date submitted = rs.getDate("SUBMITTED");
				Date resolved = rs.getDate("RESOLVED");
				int requester_id = rs.getInt("USER_ID");
				String requester_name = rs.getString("USERNAME");
				int resolver_id = rs.getInt("MANAGER_ID");
				String resolver_name = rs.getString("MANAGER_NAME");
		 		ReimbursementType rt = ReimbursementType.valueOf(rs.getInt("REI_TYPE"));
				ReimbursementStatus rstat = ReimbursementStatus.valueOf(rs.getInt("REI_STATUS"));
				reimList.add(new Reimbursement(rei_id, amount, descript, receipt, submitted, resolved, requester_id, requester_name, resolver_id, resolver_name, rt, rstat));
			}
			return reimList;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public List<Reimbursement> getPendings() {
		PreparedStatement ps = null;
		try(Connection con = ConnectionUtil.getConnection()){
			String sql = "SELECT REI_ID, AMOUNT, DESCRIPT, RECEIPT, SUBMITTED, USER_ID, USERNAME, REI_TYPE, REI_STATUS " + 
					"FROM REIMBURSEMENT "+
					"INNER JOIN ERS_USER ON REQUESTER_ID = USER_ID" +
					"WHERE REI_STATUS = 1";
			ps = con.prepareStatement(sql);
			ResultSet rs = ps.executeQuery();
			List<Reimbursement> reimList = new ArrayList<Reimbursement>();
			while(rs.next()) {
				int rei_id = rs.getInt("REI_ID");
				double amount = rs.getDouble("AMOUNT");
				String descript = rs.getString("DESCRIPT");
				boolean receipt = rs.getBlob("RECEIPT") != null;
				Date submitted = rs.getDate("SUBMITTED");
				Date resolved = null; //remember these are pending requests
				int requester_id = rs.getInt("USER_ID");
				String requester_name = rs.getString("USERNAME");
				int resolver_id = -1; //-1 for no value here
				String resolver_name = null; // and again null
				ReimbursementType rt = ReimbursementType.valueOf(rs.getInt("REI_TYPE"));
				ReimbursementStatus rstat = ReimbursementStatus.valueOf(rs.getInt("REI_STATUS"));
				reimList.add(new Reimbursement(rei_id, amount, descript, receipt, submitted, resolved, requester_id, requester_name, resolver_id, resolver_name, rt, rstat));
			}
			return reimList;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public List<Reimbursement> getResolveds() {
		PreparedStatement ps = null;
		try(Connection con = ConnectionUtil.getConnection()){
			String sql = "SELECT REI_ID, AMOUNT, DESCRIPT, RECEIPT, SUBMITTED, RESOLVED, " +
					"U1.USER_ID, U1.USERNAME, U2.USER_ID AS MANAGER_ID, U2.USERNAME AS MANAGER_NAME, REI_TYPE, REI_STATUS " +
					"FROM REIMBURSEMENT " +
					"INNER JOIN ERS_USER U1 ON REQUESTER_ID = U1.USER_ID " +
					"INNER JOIN ERS_USER U2 ON RESOLVER_ID = U2.USER_ID" +
					"WHERE REI_STATUS = 2 OR REI_STATUS = 3";		
			ps = con.prepareStatement(sql);
			ResultSet rs = ps.executeQuery();
			List<Reimbursement> reimList = new ArrayList<Reimbursement>();
			while(rs.next()) {
				int rei_id = rs.getInt("REI_ID");
				double amount = rs.getDouble("AMOUNT");
				String descript = rs.getString("DESCRIPT");
				boolean receipt = rs.getBlob("RECEIPT") != null;
				Date submitted = rs.getDate("SUBMITTED");
				Date resolved = rs.getDate("RESOLVED");
				int requester_id = rs.getInt("USER_ID");
				String requester_name = rs.getString("USERNAME");
				int resolver_id = rs.getInt("MANAGER_ID");
				String resolver_name = rs.getString("MANAGER_NAME");
		 		ReimbursementType rt = ReimbursementType.valueOf(rs.getInt("REI_TYPE"));
				ReimbursementStatus rstat = ReimbursementStatus.valueOf(rs.getInt("REI_STATUS"));
				reimList.add(new Reimbursement(rei_id, amount, descript, receipt, submitted, resolved, requester_id, requester_name, resolver_id, resolver_name, rt, rstat));
			}
			return reimList;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public List<User> listEmployees() {
		PreparedStatement ps = null;
		ArrayList<User> userArrList = new ArrayList<User>();
		try(Connection con = ConnectionUtil.getConnection()){
			String sql = "SELECT * FROM ERS_USER WHERE UR_ID=1";
			ps = con.prepareStatement(sql);
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				int id = rs.getInt("USER_ID");
				String username = rs.getString("USERNAME");
				String fname = rs.getString("FNAME");
				String lname = rs.getString("LNAME");
				String email = rs.getString("EMAIL");
				User u = new User(id, username, fname, lname, email, Role.EMPLOYEE);
				userArrList.add(u);
			}
			return userArrList;
		} catch(Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public boolean createUser(String username, String password, String fname, String lname, String email, Role r) {
		PreparedStatement ps = null;
		try(Connection con = ConnectionUtil.getConnection()){
			con.setAutoCommit(false);
			String sql = "INSERT INTO ERS_USER (USERNAME, PWORD, FNAME, LNAME, EMAIL, UR_ID) VALUES (?,?,?,?,?,?)";
			ps = con.prepareStatement(sql);
			ps.setString(1, username);
			ps.setString(2, password);
			ps.setString(3, fname);
			ps.setString(4, lname);
			ps.setString(5, email);
			ps.setInt(6, r.getId());
			int rowCount = ps.executeUpdate();
			con.commit();
			con.setAutoCommit(true);
			if(rowCount > 0)
				return true;
		} catch(Exception e) {
			e.printStackTrace();
		}
		return false;
	}

	@Override
	public boolean createRequest(double amount, String descript, InputStream receipt, int user_id,
			ReimbursementType type) {
		PreparedStatement ps = null;
		try(Connection con = ConnectionUtil.getConnection()){
			con.setAutoCommit(false);
			String sql = "INSERT INTO REIMBURSEMENT (AMOUNT, DESCRIPT, RECEIPT, SUBMITTED, REQUESTER_ID, REI_TYPE, REI_STATUS) " +
			"VALUES (?,?,?,CURRENT_TIMESTAMP,?,?,1)";
			ps = con.prepareStatement(sql);
			ps.setDouble(1, amount);
			ps.setString(2, descript);
			ps.setBlob(3, receipt);
			ps.setInt(4, user_id);
			ps.setInt(5, type.getId());
			int rowCount = ps.executeUpdate();
			con.commit();
			con.setAutoCommit(true);
			if(rowCount > 0)
				return true;
		} catch(Exception e) {
			e.printStackTrace();
		}
		return false;
	}

	@Override
	public void getReceipt(int receipt_id, OutputStream out) {
		PreparedStatement ps = null;
		try(Connection con = ConnectionUtil.getConnection()){
			String sql = "SELECT RECEIPT FROM REIMBURSEMENT WHERE REI_ID = ?";
			ps = con.prepareStatement(sql);
			ps.setInt(1, receipt_id);
			ResultSet rs = ps.executeQuery();
			if(rs.next()) {
				InputStream receipt = rs.getBinaryStream("RECEIPT");
				if(receipt != null) {
					byte[] buf = new byte[1024]; //first time using a byte array
					while (receipt.read(buf) > 0) {
						out.write(buf);
					}
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@Override
	public void getReceipt(int user_id, int receipt_id, OutputStream out) {
		PreparedStatement ps = null;
		try(Connection con = ConnectionUtil.getConnection()){
			String sql = "SELECT RECEIPT FROM REIMBURSEMENT WHERE REI_ID = ? AND REQUESTER_ID = ?";
			ps = con.prepareStatement(sql);
			ps.setInt(1, receipt_id);
			ps.setInt(2, user_id);
			ResultSet rs = ps.executeQuery();
			if(rs.next()) {
				InputStream receipt = rs.getBinaryStream("RECEIPT");
				if(receipt != null) {
					byte[] buf = new byte[1024]; //first time using a byte array
					while (receipt.read(buf) > 0) {
						out.write(buf);
					}
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
