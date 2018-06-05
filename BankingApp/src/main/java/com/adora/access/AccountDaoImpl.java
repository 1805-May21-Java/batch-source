package com.adora.access;

import java.io.IOException;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.adora.object.Account;
import com.adora.object.User;
import com.adora.util.ConnectionUtil;

public class AccountDaoImpl implements AccountDao {

	@Override
	public int addNewAccount(User user, Account account) {
		int accountCreated = 0;
	
		try(Connection conn = ConnectionUtil.getConnection()) {
			String sql = "{call add_new_account(?,?,?)}";
			CallableStatement cs = conn.prepareCall(sql); 
			// register IN parameters
			cs.setInt(1, user.getUserId());
			cs.setString(2, account.getAccountType());
			cs.setDouble(3, account.getAccountBalance());
			
			accountCreated = cs.executeUpdate();
			
		} catch (SQLException | IOException e) {
			e.printStackTrace();
		}
		
		return accountCreated;
	}

	@Override
	public List<Account> getUserAccounts(User user) {
		List<Account> accountList = new ArrayList<Account>();
		try(Connection conn = ConnectionUtil.getConnection()) {
			String sql = "SELECT ba.account_id, account_type, account_balance "
					+ "FROM bankUserAccount bua "
					+ "JOIN bankAccount ba "
					+ "ON  bua.account_id = ba.account_id "
					+ "WHERE bua.user_id = ?";
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setInt(1, user.getUserId());
			
			ResultSet result = ps.executeQuery();
			
			while(result.next()) {
				accountList.add(new Account(result.getInt("account_id"), result.getString("account_type"), result.getDouble("account_balance")));
			}
			
			
		} catch (IOException | SQLException e) {
			e.printStackTrace();
		}
		
		return accountList;
	}

	@Override
	public int updateAccount(Account account) {
		int accountUpdated = 0;
		
		try (Connection conn = ConnectionUtil.getConnection()){
			String sql = "UPDATE bankAccount SET account_balance = ? WHERE account_id = ?";
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setDouble(1, account.getAccountBalance());
			ps.setInt(2, account.getAccountId());
			accountUpdated = ps.executeUpdate();
			
		} catch (IOException | SQLException e) {
			e.printStackTrace();
		}
		
		
		return accountUpdated;
	}

}
