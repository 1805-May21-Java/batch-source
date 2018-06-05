package com.Revature.Dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.Revature.pojos.BankAccount;
import com.Revature.pojos.UserProfile;
import com.Revature.util.ConnectionUtil;

public class ProfileAccountDaoImpl implements ProfileAccountDao {

	@Override
	public List<Integer> getAllAccountNumbers(String username) throws Exception {
		ArrayList<Integer> arr = new ArrayList<Integer>();
		Exception err = null;

		try (Connection con = ConnectionUtil.getConnection()) {
			// Queries database for all account numbers from the link table
			String sql = "SELECT ACC_NUMBER FROM PROFILE_ACCOUNT WHERE USERNAME = ?";
			PreparedStatement stmt = con.prepareStatement(sql);
			stmt.setString(1, username);

			ResultSet rs = stmt.executeQuery();

			while (rs.next()) {
				arr.add(rs.getInt("ACC_NUMBER"));
			}
		} catch (Exception e) {
			err = e;
		}

		if (err != null) {
			throw err;
		}

		return arr;
	}

	@Override
	public List<String> getAllUsernames(int id) throws Exception {
		ArrayList<String> arr = new ArrayList<String>();
		Exception err = null;

		try (Connection con = ConnectionUtil.getConnection()) {
			// Queries database for usernames from given account
			String sql = "SELECT USERNAME FROM PROFILE_ACCOUNT WHERE ACC_NUMBER = ?";
			PreparedStatement stmt = con.prepareStatement(sql);
			stmt.setInt(1, id);

			ResultSet rs = stmt.executeQuery();

			while (rs.next()) {
				arr.add(rs.getString("USERNAME"));
			}
		} catch (Exception e) {
			err = e;
		}

		if (err != null) {
			throw err;
		}

		return arr;
	}

	@Override
	public List<BankAccount> getAllAccounts(String username) throws Exception {
		List<Integer> arr = getAllAccountNumbers(username); // Gets list of all account numbers
		List<BankAccount> accounts = new ArrayList<BankAccount>(); // Defines new list of bank accounts
		BankAccountDaoImpl bank = new BankAccountDaoImpl();
		for (Integer i : arr) { // Iterate through and get all bank accounts from db
			accounts.add(bank.getBankAccount(i));
		}
		return accounts;
	}

	@Override
	public List<UserProfile> getAllUserProfiles(int id) throws Exception {
		List<String> arr = getAllUsernames(id); // Gets list of usernames
		List<UserProfile> users = new ArrayList<UserProfile>(); // Defines list of user profiles
		Exception err = null;

		try (Connection con = ConnectionUtil.getConnection()) {
			String sql = "SELECT * FROM USER_PROFILE WHERE USERNAME = ?";
			PreparedStatement stmt = null;
			for (String str : arr) { // Gets all user profiles from db
				stmt = con.prepareStatement(sql);
				stmt.setString(1, str);
				
				ResultSet rs = stmt.executeQuery();
				
				if ( rs.next()) {
					users.add( new UserProfile(rs.getString("USERNAME") , rs.getString("PWD")));
				}
			}
		} catch (Exception e) {
			err = e;
		}
		
		if ( err != null ) {
			throw err;
		}
		return users;
	}

}
