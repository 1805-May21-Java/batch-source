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

import com.revature.pojos.Transaction;
import com.revature.util.ConnectionUtil;

public class TransactionDaoImpl implements TransactionDao{

	public List<Transaction> getTransactions() {
		List<Transaction> transactionList = new ArrayList<Transaction>();
		try {
			Connection conn = ConnectionUtil.getConnection();
			String sql = "SELECT * FROM BANKTRANSACTION";
			Statement s = conn.createStatement();
			ResultSet rs = s.executeQuery(sql);
			while(rs.next()) {
				int transactionId = rs.getInt("TRANSACTIONID");
				long accountNumber = rs.getLong("ACCTNUMBER");
				Date transactionDate = rs.getDate("TRANSACTIONDATE");
				String description = rs.getString("DESCRIPTION");
				
				transactionList.add(new Transaction(transactionId, accountNumber, transactionDate, description));
			}
			conn.close();
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return transactionList;
	}

	public List<Transaction> getAccountTransactions(int acctNumber) {
		List<Transaction> transactionList = new ArrayList<Transaction>();
		try {
			Connection conn = ConnectionUtil.getConnection();
			String sql = "SELECT * FROM BANKTRANSACTION WHERE ACCTNUMBER = " + acctNumber;
			Statement s = conn.createStatement();
			ResultSet rs = s.executeQuery(sql);
			while (rs.next()) {
				int transactionId = rs.getInt("TRANSACTIONID");
				long accountNumber = rs.getLong("ACCTNUMBER");
				Date transactionDate = rs.getDate("TRANSACTIONDATE");
				String description = rs.getString("DESCRIPTION");
				
				transactionList.add(new Transaction(transactionId, accountNumber, transactionDate, description));
			}
			conn.close();
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return transactionList;
	}

	public List<Transaction> getAccountTransactions(int acctNumber, int max) {
		List<Transaction> transactionList = new ArrayList<Transaction>();
		try {
			Connection conn = ConnectionUtil.getConnection();
			String sql = "SELECT * FROM BANKTRANSACTION WHERE ACCTNUMBER = " + acctNumber;
			Statement s = conn.createStatement();
			ResultSet rs = s.executeQuery(sql);
			while (rs.next()) {
				int transactionId = rs.getInt("TRANSACTIONID");
				long accountNumber = rs.getLong("ACCTNUMBER");
				Date transactionDate = rs.getDate("TRANSACTIONDATE");
				String description = rs.getString("DESCRIPTION");
				
				transactionList.add(new Transaction(transactionId, accountNumber, transactionDate, description));
				if(transactionList.size() > max) {
					//Remove first element
					transactionList.remove(transactionList.get(0));
				}
			}
			conn.close();
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return transactionList;
	}

	public int createTransaction(Transaction action) {
		int transactionCreated = 0;
		try {
			Connection conn = ConnectionUtil.getConnection();
			String sql = "INSERT INTO BANKTRANSACTION (ACCTNUMBER, TRANSACTIONDATE, DESCRIPTION) VALUES (?, LOCALTIMESTAMP, ?)";
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setLong(1, action.getAccountNumber());
			ps.setString(2, action.getDescription());
			transactionCreated = ps.executeUpdate();
			
			conn.close();
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return transactionCreated;
	}

}
