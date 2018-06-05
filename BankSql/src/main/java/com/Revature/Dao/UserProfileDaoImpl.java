package com.Revature.Dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.List;

import com.Revature.pojos.BankAccount;
import com.Revature.pojos.UserProfile;
import com.Revature.util.ConnectionUtil;

public class UserProfileDaoImpl implements UserProfileDao {

	// Creates a new user profile
	@Override
	public int createUserProfile(UserProfile up) throws Exception {
		int rval = 0;
		Exception err = null;

		try (Connection con = ConnectionUtil.getConnection()) {
			String sql = "INSERT INTO USER_PROFILE VALUES(?,?)";
			PreparedStatement stmt = con.prepareStatement(sql);
			stmt.setString(1, up.getUsername());
			stmt.setString(2, up.getPassword());

			rval = stmt.executeUpdate();
		} catch (Exception e) { // Don't handle exceptions here
			err = e;
		}

		// Makes sure that connection closes before exceptions are thrown
		if (err != null) {
			throw err;
		}

		return rval;
	}

	// Returns a user profile with matching username
	@Override
	public UserProfile getUserProfile(String username, String password) throws Exception {
		UserProfile up = null;
		Exception err = null;

		try (Connection con = ConnectionUtil.getConnection()) {
			String sql = "SELECT * FROM USER_PROFILE WHERE USERNAME = ? AND PWD = ?";
			PreparedStatement stmt = con.prepareStatement(sql);
			stmt.setString(1, username);
			stmt.setString(2, password);

			ResultSet rs = stmt.executeQuery();

			if (rs.next()) {
				up = new UserProfile(rs.getString("USERNAME"), rs.getString("PWD"));
			}
		} catch (Exception e) {
			err = e;
		}

		if (err != null) {
			throw err;
		}

		return up;
	}

	// Updates user profile, changes password
	@Override
	public int updateUserProfile(UserProfile up) throws Exception {
		int rval = 0;
		Exception err = null;

		try (Connection con = ConnectionUtil.getConnection()) {
			String sql = "UPDATE USER_PROFILE " + "SET PWD = ?" + "WHERE USERNAME = ?";
			PreparedStatement stmt = con.prepareStatement(sql);
			stmt.setString(1, up.getPassword());
			stmt.setString(2, up.getUsername());

			rval = stmt.executeUpdate();
		} catch (Exception e) {
			err = e;
		}

		if (err != null) {
			throw err;
		}

		return rval;
	}

	// Deletes user and checks to see if there are bank accounts that
	// do not have any other co owners
	@Override
	public int deleteUserProfile(String username) throws Exception {
		// Declare all necessary variables
		int rval = 0;
		Exception err = null;

		ProfileAccountDaoImpl prof = new ProfileAccountDaoImpl();
		List<BankAccount> accounts = null;
		String sql = null;
		PreparedStatement stmt = null;

		// Returns list of all accounts owned b username
		accounts = prof.getAllAccounts(username);

		// Checks for other profiles that also own account
		// If there are multiple owners, do not delete bank account
		int i = 0;
		while (i < accounts.size()) {
			BankAccount bank = accounts.get(i);
			if (prof.getAllUsernames(bank.getAccountNumber()).size() > 1) {
				accounts.remove(bank);
			} else {
				i++;
			}
		}

		try (Connection con = ConnectionUtil.getConnection()) {
			con.setAutoCommit(false); // Transactional boundary goes beyond one statement

			// Delete all bank accounts that are only owned by username
			for (BankAccount bank : accounts) {
				sql = "DELETE FROM BANK_ACCOUNT WHERE ACC_NUMBER = ?";
				stmt = con.prepareStatement(sql);
				stmt.setInt(1, bank.getAccountNumber());

				rval += stmt.executeUpdate();
			}

			// Finally delete the user from the database
			sql = "DELETE FROM USER_PROFILE WHERE USERNAME = ?";
			stmt = con.prepareStatement(sql);
			stmt.setString(1, username);

			rval += stmt.executeUpdate();

			// Assuming nothing went wrong, commit all changes
			con.commit();
		} catch (Exception e) {
			err = e;
		}

		if (err != null) {
			throw err;
		}
		return rval;
	}

	@Override
	public boolean checkUsername(String username) throws Exception {
		boolean rval = true; //Assume that the username is taken
		Exception err = null;

		try (Connection con = ConnectionUtil.getConnection()) {
			String sql = "SELECT COUNT(USERNAME) FROM USER_PROFILE WHERE USERNAME = ?";
			PreparedStatement stmt = con.prepareStatement(sql);
			stmt.setString(1, username);

			ResultSet rs = stmt.executeQuery();
			
			rs.next();
			
			if ( rs.getInt(1) == 0 ) { //If the count of usernames is 0
				rval = false; //There is no profile with this name
			}
		} catch (Exception e) {
			err = e;
		}

		if (err != null) {
			throw err;
		}

		return rval;
	}
}
