package com.revature.dao;

import java.io.IOException;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList; 
import java.util.List;

import com.revature.pojos.OBankInfo;
import com.revature.util.ConnectionUtils;

public class BankInfoDaoImpl implements BankInfoDao{

	@Override
	//list all of the data from the table, and make them into an arraylist using statements
	//not really used, kept for statement requirements
	public List<OBankInfo> bankInfo() {
		List<OBankInfo> banklist = new ArrayList<OBankInfo>();
		try {
			Connection con = ConnectionUtils.getConnection();
			String sql = "SELECT * From BANKINFO";
			Statement s = con.createStatement();
			//set the result set equals to the execute
			ResultSet rs = s.executeQuery(sql);
			while(rs.next()) {
				//while result have next value, get the rlated info from sql database
				int userid = rs.getInt("USERID");
				String username = rs.getString("USERNAME");
				String email = rs.getString("EMAIL");
				String password = rs.getString("PASSWORD");
				double caccount = rs.getDouble("C_BANK_AMOUNT");
				double saccount = rs.getDouble("S_BANK_AMOUNT");
				//then input the gotten data into the arraylist
				banklist.add(new OBankInfo(userid, username, email, password, caccount, saccount));
			}
			//con.close();
		} catch (IOException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return banklist;
	}

	@Override
	public OBankInfo getOBankInfoByUserPass(String user, String pass) {
		OBankInfo o = null;
		//start a null OBankInfo class
		try {
			Connection con = ConnectionUtils.getConnection();
			String sql = "SELECT * FROM BANKINFO WHERE (USERNAME =? OR EMAIL=?) AND BANK_PASSWORD =?";
			//after getting connection, set the statement up where input username/email and passowrd to access
			//the bank account of said user
			PreparedStatement ps = con.prepareStatement(sql);
			//setting the input into string asked
			ps.setString(1, user);
			ps.setString(2, user);
			ps.setString(3, pass);
			ResultSet rs = ps.executeQuery();
			
			while(rs.next()) {
				//getting the information out
				int userid = rs.getInt("USERID");
				String username = rs.getString("USERNAME");
				String email = rs.getString("EMAIL");
				String password = rs.getString("BANK_PASSWORD");
				int checkingAccount = rs.getInt("C_BANK_AMOUNT");
				int savingAccount = rs.getInt("S_BANK_AMOUNT");
				o = new OBankInfo (userid,username,email,password,checkingAccount,savingAccount);
				
			}
			//no con.close is because connection can't be reopened for some reason
			//con.close();
			
		} catch (IOException | SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		return o;
	}

	@Override
	public int createBankAccount(OBankInfo bankInfo) {
		//set a int to show how many row/account has been created
		int bankAccountCreated = 0;
		Connection con;
		try {
			//similar set up, use ps to avoid injection, and ? represents input
			con = ConnectionUtils.getConnection();
			String sql = "INSERT INTO BANKINFO (USERNAME, EMAIL, BANK_PASSWORD, C_BANK_AMOUNT, S_BANK_AMOUNT) VALUES (?,?,?,0,0)";
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setString(1, bankInfo.getUsername());
			ps.setString(2, bankInfo.getEmail());
			ps.setString(3, bankInfo.getPassword());
			bankAccountCreated = ps.executeUpdate();
			//con.close();
		} catch (IOException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		//usually returns 1
		return bankAccountCreated;
	}

	@Override
	public int updateBankAccount(OBankInfo bankInfo) {
		int bankAccountUpdated = 0;
		Connection con;
		try {
			//a method that is not used yet, could been added to change username/email, and password
			//similar to createaccount
			con = ConnectionUtils.getConnection();
			String sql = "UPDATE DEPATMENT SET USERNAME = ?, EMAIL = ?, BANK_PASSWORD = ?";
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setString(1, bankInfo.getUsername());
			ps.setString(2, bankInfo.getEmail());
			ps.setString(3, bankInfo.getPassword());
			bankAccountUpdated = ps.executeUpdate();
			con.commit();
			//con.close();
		} catch (IOException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return bankAccountUpdated;
	}

	@Override
	public int deleteBankAccount(String user, String pass) {
		//asks for username and password, and based on the input, delete the row from the table in sql
		//using the prepared statements
		int bankInfoDeleted = 0;
		Connection con;
		try {
			con = ConnectionUtils.getConnection();
			String sql = "DELETE FROM BANKINFO WHERE USERNAME = ? AND BANK_PASSWORD = ?";
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setString(1, user);
			ps.setString(2, pass);
			bankInfoDeleted = ps.executeUpdate();
			
		} catch (IOException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return bankInfoDeleted;
	}

	@Override
	public void increaseChecking(int uid, double value) {
		//functions to increase checking/saving
		//with procedure already written in the sql part of the project, all this 4 function does is
		//to call them procedure using callable statements and input the correct value with it
		try {
			Connection con = ConnectionUtils.getConnection();
			String sql = "{call INCREASE_CHECKING(?,?)}";
			CallableStatement cs = con.prepareCall(sql);
			cs.setInt(1, uid);
			cs.setDouble(2, value);
			cs.execute();
			//con.close();
			
		} catch (IOException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	}

	@Override
	public void decreaseChecking(int uid, double value) {
		try {
			Connection con = ConnectionUtils.getConnection();
			String sql = "{call DECREASE_CHECKING(?,?)}";
			CallableStatement cs = con.prepareCall(sql);
			cs.setInt(1, uid);
			cs.setDouble(2, value);
			cs.execute();
			//con.close();
			
		} catch (IOException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	}

	@Override
	public void increaseSaving(int uid, double value) {
		try {
			Connection con = ConnectionUtils.getConnection();
			String sql = "{call INCREASE_SAVING(?,?)}";
			CallableStatement cs = con.prepareCall(sql);
			cs.setInt(1, uid);
			cs.setDouble(2, value);
			cs.execute();
			//con.close();
			
		} catch (IOException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	}

	@Override
	public void decreaseSaving(int uid, double value) {
		try {
			Connection con = ConnectionUtils.getConnection();
			String sql = "{call DECREASE_SAVING(?,?)}";
			CallableStatement cs = con.prepareCall(sql);
			cs.setInt(1, uid);
			cs.setDouble(2, value);
			cs.execute();
			//con.close();
			
		} catch (IOException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	//close the connection after exiting the program
	public void closeConnection() {
		try {
			Connection con = ConnectionUtils.getConnection();
			con.close();
		} catch (IOException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
}
