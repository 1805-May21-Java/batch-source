package com.Revature.Dao;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import com.Revature.BankExceptions.InsufficientFunds;
import com.Revature.pojos.BankAccount;
import com.Revature.pojos.UserProfile;
import com.Revature.util.ConnectionUtil;

public class BankAccountDaoImpl implements BankAccountDao {

	// Returns the next number in the sequence
	@Override
	public int getNextAccountNumber() throws Exception {
		int rval = -1;
		Exception err = null;

		try (Connection con = ConnectionUtil.getConnection()) {
			//Calls DB procedure that returns the next number in account number sequence
			CallableStatement cstmt=con.prepareCall("{call GET_NEXT_ACC_NUMBER(?)}");
			cstmt.registerOutParameter(1, java.sql.Types.INTEGER);
			
			cstmt.execute();
			
			rval = cstmt.getInt(1); //Gets the first output parameter
		} catch (Exception e) {
			err = e;
		}

		if (err != null) {
			throw err;
		}

		return rval;
	}

	// Creates a new bank account and link
	@Override
	public int createBankAccount(UserProfile user, BankAccount acc) throws Exception {
		int rval = 0;
		Exception err = null;

		try (Connection con = ConnectionUtil.getConnection()) {
			// Set auto commit to false
			// for the transactional boundary
			con.setAutoCommit(false);

			// Insert new bank account
			String sql = "INSERT INTO BANK_ACCOUNT VALUES(?,?)";
			PreparedStatement stmt = con.prepareStatement(sql);
			stmt.setInt(1, acc.getAccountNumber());
			stmt.setFloat(2, acc.getBalance());

			rval = stmt.executeUpdate();

			// Insert new link between profile and account
			sql = "INSERT INTO PROFILE_ACCOUNT VALUES(?,?)";
			stmt = con.prepareStatement(sql);
			stmt.setString(1, user.getUsername());
			stmt.setInt(2, acc.getAccountNumber());

			rval += stmt.executeUpdate();

			con.commit();
		} catch (Exception e) {
			err = e;
		}

		if (err != null) {
			throw err;
		}
		return rval;
	}

	// Returns bank account with id
	@Override
	public BankAccount getBankAccount(int id) throws Exception {
		BankAccount acc = null;
		Exception err = null;

		try (Connection con = ConnectionUtil.getConnection()) {
			String sql = "SELECT * FROM BANK_ACCOUNT WHERE ACC_NUMBER = ?";
			PreparedStatement stmt = con.prepareStatement(sql);
			stmt.setInt(1, id);

			// Query for bank accounts
			ResultSet rs = stmt.executeQuery();

			if (rs.next()) {
				// Creates new bank account
				int accountNumber = rs.getInt("ACC_NUMBER");
				float balance = rs.getInt("BALANCE");

				acc = new BankAccount(accountNumber, balance);
			}
		} catch (Exception e) {
			err = e;
		}

		if (err != null) {
			throw err;
		}

		return acc;
	}

	// Updates account
	@Override
	public int updateBankAccount(BankAccount acc) throws Exception {
		int rval = 0;
		Exception err = null;

		try (Connection con = ConnectionUtil.getConnection()) {
			String sql = "UPDATE BANK_ACCOUNT " + "SET BALANCE = ?" + "WHERE ACC_NUMBER = ?";
			PreparedStatement stmt = con.prepareStatement(sql);
			stmt.setFloat(1, acc.getBalance());
			stmt.setInt(2, acc.getAccountNumber());

			rval = stmt.executeUpdate();
		} catch (Exception e) {
			err = e;
		}

		if (err != null) {
			throw err;
		}

		return rval;
	}

	// Adds a user profile to a bank account by creating a new link between existing
	// database objects
	@Override
	public int addProfileToBankAccount(UserProfile user, BankAccount acc) throws Exception {
		int rval = 0;
		Exception err = null;

		try (Connection con = ConnectionUtil.getConnection()) {
			// Create new link between username and account number
			String sql = "INSERT INTO PROFILE_ACCOUNT VALUES(?,?)";
			PreparedStatement stmt = con.prepareStatement(sql);
			stmt.setString(1, user.getUsername());
			stmt.setInt(2, acc.getAccountNumber());

			rval = stmt.executeUpdate();
		} catch (Exception e) {
			err = e;
		}

		if (err != null) {
			throw err;
		}

		return rval;
	}

	// Deletes a single bank account
	@Override
	public int deleteBankAccount(int id) throws Exception {
		int rval = 0;
		Exception err = null;

		try (Connection con = ConnectionUtil.getConnection()) {
			// Also deletes the link between profile and bank account
			// database side cascade delete
			String sql = "DELETE FROM BANK_ACCOUNT WHERE ACC_NUMBER = ?";
			PreparedStatement stmt = con.prepareStatement(sql);
			stmt.setInt(1, id);

			rval = stmt.executeUpdate();
		} catch (Exception e) {
			err = e;
		}

		if (err != null) {
			throw err;
		}

		return rval;
	}

	@Override
	public int transferMoneyBetweenAccounts(BankAccount src, BankAccount dest, float val) throws Exception {
		int rval = 0;
		Exception err = null;

		if (src.getBalance() < val) { //Throw exception
			throw new InsufficientFunds();
		}

		src.setBalance(src.getBalance() - val);
		dest.setBalance(dest.getBalance() + val); //Exchange the amounts

		try (Connection con = ConnectionUtil.getConnection()) {
			con.setAutoCommit(false); //Set to false
			//If one update call fails don't commit

			String sql = "UPDATE BANK_ACCOUNT SET BALANCE = ? WHERE ACC_NUMBER = ?";
			PreparedStatement stmt = con.prepareStatement(sql);
			stmt.setFloat(1, src.getBalance());
			stmt.setInt(2, src.getAccountNumber());

			rval += stmt.executeUpdate();

			sql = "UPDATE BANK_ACCOUNT SET BALANCE = ? WHERE ACC_NUMBER = ?";
			stmt = con.prepareStatement(sql);
			stmt.setFloat(1, dest.getBalance());
			stmt.setInt(2, dest.getAccountNumber());

			rval += stmt.executeUpdate();

			con.commit();

		} catch (Exception e) {
			err = e;
		}

		if (err != null) {
			throw err;
		}

		return rval; //Return the number of rows updated
	}

	@Override
	public int withdrawFromBank(BankAccount acc, float val) throws Exception {
		if (acc.getBalance() < val) { //Checks funds
			throw new InsufficientFunds();
		}
		
		//Could check again for val < 0
		//Caller checks

		acc.setBalance(acc.getBalance() - val);

		return updateBankAccount(acc);
	}

	@Override
	public int depositToBank(BankAccount acc, float val) throws Exception {
		acc.setBalance(acc.getBalance() + val);
		
		//Caller checks for a val < 0

		return updateBankAccount(acc);
	}
}
