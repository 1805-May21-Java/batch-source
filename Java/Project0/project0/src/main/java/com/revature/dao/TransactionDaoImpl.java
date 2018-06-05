package com.revature.dao;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.ArrayList;
import com.revature.pojos.Transaction;
import com.revature.util.ConnectionUtil;

public class TransactionDaoImpl implements TransactionDao {

	@Override
	public int createTransaction(String type, double amount, String username) {
		int transactionCreated = 0;
		try {
			Connection con = ConnectionUtil.getConnection();
			String sql = "INSERT INTO BANK_TRANSACTION (TRANSACTION_TYPE, AMOUNT, USERNAME) VALUES(?,?,?)";
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setString(1, type);
			ps.setDouble(2, amount);
			ps.setString(3, username);
			transactionCreated = ps.executeUpdate();
			con.close();
		} catch (IOException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return transactionCreated;
	}

	@Override
	public ArrayList<Transaction> getTransactions(String username) {
		ArrayList<Transaction> transactions = new ArrayList<>();
		try {
			Connection con = ConnectionUtil.getConnection();
			String sql = "SELECT * FROM BANK_TRANSACTION WHERE USERNAME=? ORDER BY INSERTED_AT DESC";
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setString(1, username);
			ResultSet rs = ps.executeQuery();
			
			while(rs.next()) { 
				String type = rs.getString("TRANSACTION_TYPE");
				double amount = rs.getDouble("AMOUNT");
				Timestamp  timestamp = rs.getTimestamp("INSERTED_AT");
				transactions.add(new Transaction(type, amount, username, timestamp));
			}
			
			con.close();
			
		} catch (IOException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return transactions;
	}
	
}
