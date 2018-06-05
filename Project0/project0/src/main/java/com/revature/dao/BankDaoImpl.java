package com.revature.dao;
import java.io.IOException;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import com.revature.pojos.Account;
import com.revature.pojos.User;
import com.revature.util.ConnectionUtil;

public class BankDaoImpl implements BankDao {
	@Override
	public ArrayList<User> getUsers() {
		ArrayList<User> users = new ArrayList<>();
		String sql = "SELECT * FROM BANK_USER";
		try {
			Connection con = ConnectionUtil.getConnection();
			Statement s = con.createStatement();
			ResultSet rs = s.executeQuery(sql);
			
			while(rs.next()) {
				String username = rs.getString("USERNAME");
				String password = rs.getString("USER_PASSWORD");
				users.add(new User(username, password));
			}
			
		} catch (IOException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return users;
	}

	@Override
	public ArrayList<Account> getAccounts() {
		ArrayList<Account> accounts = new ArrayList<>();
		String sql = "SELECT * FROM BANK_ACCOUNT";
		try {
			Connection con = ConnectionUtil.getConnection();
			Statement s = con.createStatement();
			ResultSet rs = s.executeQuery(sql);
			
			while(rs.next()) {
				int accountId = rs.getInt("ACCOUNT_ID");
				double balance = rs.getDouble("BALANCE");
				String username = rs.getString("USERNAME");
				accounts.add(new Account(balance, username, accountId));
			}
			
		} catch (IOException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return accounts;
	}
}
