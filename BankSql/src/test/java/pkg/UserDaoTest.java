package pkg;

import static org.junit.Assert.*;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;

import org.junit.AfterClass;
import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;

import com.Revature.Dao.BankAccountDaoImpl;
import com.Revature.Dao.UserProfileDaoImpl;
import com.Revature.pojos.BankAccount;
import com.Revature.pojos.UserProfile;
import com.Revature.util.ConnectionUtil;

public class UserDaoTest {

	@Before
	public void scubber() {
		assert (DBScrub.scrub());
	}

	@Test(expected = Exception.class)
	public void checkDuplicateUsername() throws Exception {
		/*
		 * Attempts to add the same user twice in the db
		 */
		UserProfileDaoImpl userDao = new UserProfileDaoImpl();
		UserProfile user = new UserProfile("THOMAS", "PASS");
		int rval = userDao.createUserProfile(user);
		assert (rval == 1);
		userDao.createUserProfile(user);
	}

	@Test
	public void createNewAccount() throws Exception {
		UserProfileDaoImpl userDao = new UserProfileDaoImpl();
		UserProfile user = new UserProfile("THOMAS", "PASS");
		int rval = userDao.createUserProfile(user);
		assert (rval == 1);

		Connection con = ConnectionUtil.getConnection();

		Statement stmt = con.createStatement();

		ResultSet rs = stmt.executeQuery("SELECT * FROM USER_PROFILE WHERE USERNAME = 'THOMAS' AND PWD = 'PASS'");
		assert (rs.next());

		// Creates a new user and queries for it after
	}

	@Test
	public void deleteNonExistantUser() throws Exception {
		UserProfileDaoImpl userDao = new UserProfileDaoImpl();
		int rval = userDao.deleteUserProfile("THOMAS");
		assert (rval == 0); // Returns 0 lines changed

		Connection con = ConnectionUtil.getConnection();
		Statement stmt = con.createStatement();
		ResultSet rs = stmt.executeQuery("SELECT * FROM USER_PROFILE");
		assert (!rs.next());

		// Attempts to delete a user that does not exist
	}

	@Test
	public void deleteUser() throws Exception {
		UserProfileDaoImpl userDao = new UserProfileDaoImpl();
		UserProfile user = new UserProfile("THOMAS", "PASS");
		int rval = userDao.createUserProfile(user);
		assert (rval == 1);

		/*
		 * Creates user and verifies that the user was added
		 */

		Connection con = ConnectionUtil.getConnection();

		Statement stmt = con.createStatement();

		ResultSet rs = stmt.executeQuery("SELECT * FROM USER_PROFILE WHERE USERNAME = 'THOMAS' AND PWD = 'PASS'");
		assert (rs.next());

		rval = userDao.deleteUserProfile(user.getUsername());
		assert (rval == 1);
		// Deletes user

		con = ConnectionUtil.getConnection();

		stmt = con.createStatement();

		rs = stmt.executeQuery("SELECT * FROM USER_PROFILE");
		assert (!rs.next()); // Verifies that the user does not exist
	}

	@Test
	public void deleteUserWithBankAccount() throws Exception {
		UserProfileDaoImpl userDao = new UserProfileDaoImpl();
		BankAccountDaoImpl bankDao = new BankAccountDaoImpl();

		// Creates a user
		UserProfile user = new UserProfile("THOMAS", "PASS");
		int rval = userDao.createUserProfile(user);
		assert (rval == 1);

		Connection con = ConnectionUtil.getConnection();

		Statement stmt = con.createStatement();

		ResultSet rs = stmt.executeQuery("SELECT * FROM USER_PROFILE WHERE USERNAME = 'THOMAS' AND PWD = 'PASS'");
		assert (rs.next());

		int accountNumber = bankDao.getNextAccountNumber();
		assert (accountNumber != -1);

		// Creates a bank account associated with the user
		BankAccount bank = new BankAccount(accountNumber, 0f);
		rval = bankDao.createBankAccount(user, bank);
		assert (rval == 2);

		con = ConnectionUtil.getConnection();

		stmt = con.createStatement();

		rs = stmt.executeQuery("SELECT * FROM BANK_ACCOUNT WHERE ACC_NUMBER = '" + bank.getAccountNumber() + "'");
		assert (rs.next());

		// Deletes the user
		rval = userDao.deleteUserProfile(user.getUsername());
		assert (rval >= 1);

		con = ConnectionUtil.getConnection();

		stmt = con.createStatement();

		rs = stmt.executeQuery("SELECT * FROM USER_PROFILE");

		assert (!rs.next());

		rs = stmt.executeQuery("SELECT * FROM BANK_ACCOUNT");

		assert (!rs.next());
		// Verifies that the bank account and the user do not exist anymore
	}

	@Test
	public void deleteUserWIthMultipleAccountsAndOne() throws Exception {
		UserProfileDaoImpl userDao = new UserProfileDaoImpl();
		BankAccountDaoImpl bankDao = new BankAccountDaoImpl();

		// Creates a single user
		UserProfile user = new UserProfile("THOMAS", "PASS");
		int rval = userDao.createUserProfile(user);
		assert (rval == 1);

		BankAccount bank = null;

		// Adds bank accounts linked to the user
		for (int i = 0; i < 5; i++) {
			int accountNumber = bankDao.getNextAccountNumber();
			assert (accountNumber != -1);

			bank = new BankAccount(accountNumber, 0f);
			rval = bankDao.createBankAccount(user, bank);
			assert (rval == 2);
		}

		Connection con = ConnectionUtil.getConnection();

		Statement stmt = con.createStatement();

		ResultSet rs = stmt.executeQuery("SELECT COUNT(ACC_NUMBER) FROM PROFILE_ACCOUNT WHERE USERNAME = 'THOMAS'");

		assert (rs.next());

		assert (rs.getInt(1) == 5); // Verifies that there are five accounts linked to the the user

		UserProfile user2 = new UserProfile("TIM", "PASS");
		rval = userDao.createUserProfile(user2); // Creates another user that will be linked to one bank account

		assert (rval == 1);

		con = ConnectionUtil.getConnection();

		stmt = con.createStatement();

		rs = stmt.executeQuery("SELECT COUNT(USERNAME) FROM USER_PROFILE");

		assert (rs.next());

		assert (rs.getInt(1) == 2);

		bankDao.addProfileToBankAccount(user2, bank); // the most recent addition
		// Link Tim to bank account as joint user

		con = ConnectionUtil.getConnection();

		stmt = con.createStatement();

		rs = stmt.executeQuery(
				"SELECT COUNT(ACC_NUMBER) FROM PROFILE_ACCOUNT WHERE ACC_NUMBER = '" + bank.getAccountNumber() + "'");
		// Verifies that there are two links to the same bank account

		assert (rs.next());

		assert (rs.getInt(1) == 2); // Verify that there are two links to the same account
		// They must have different users b/c username,acc_number is a key

		userDao.deleteUserProfile(user.getUsername()); // Deletes Thomas as a user

		con = ConnectionUtil.getConnection();

		stmt = con.createStatement();

		rs = stmt.executeQuery(
				"SELECT COUNT(ACC_NUMBER) FROM PROFILE_ACCOUNT WHERE ACC_NUMBER = '" + bank.getAccountNumber() + "'");

		assert (rs.next());

		assert (rs.getInt(1) == 1); // Only one link left to the account

	}

	@Test
	public void deleteUserWIthMultipleAccounts() throws Exception {
		UserProfileDaoImpl userDao = new UserProfileDaoImpl();
		BankAccountDaoImpl bankDao = new BankAccountDaoImpl();

		UserProfile user = new UserProfile("THOMAS", "PASS"); // Define a user
		int rval = userDao.createUserProfile(user); // Create a user
		assert (rval == 1);

		for (int i = 0; i < 5; i++) { // Create five bank accounts and link them to the user
			int accountNumber = bankDao.getNextAccountNumber();
			assert (accountNumber != -1);

			BankAccount bank = new BankAccount(accountNumber, 0f);
			rval = bankDao.createBankAccount(user, bank);
			assert (rval == 2);
		}

		Connection con = ConnectionUtil.getConnection();

		Statement stmt = con.createStatement();

		ResultSet rs = stmt.executeQuery("SELECT COUNT(ACC_NUMBER) FROM BANK_ACCOUNT");

		assert (rs.next());

		assert (rs.getInt(1) == 5);

		rval = userDao.deleteUserProfile(user.getUsername()); // Delete user
		assert (rval >= 1);

		con = ConnectionUtil.getConnection();

		stmt = con.createStatement();

		rs = stmt.executeQuery("SELECT COUNT(ACC_NUMBER) FROM BANK_ACCOUNT");

		assert (rs.next());

		assert (rs.getInt(1) == 0); // All accounts are gone from db
	}

	@Test
	public void changePasswordOnNonExistantUser() throws Exception {
		UserProfileDaoImpl userDao = new UserProfileDaoImpl();
		UserProfile user = new UserProfile("THOMAS", "PASS");
		int rval = userDao.updateUserProfile(user);
		assert (rval == 0); // Verifies no rows are changed by this attempt
	}

	@Test
	public void changePassword() throws Exception {
		UserProfileDaoImpl userDao = new UserProfileDaoImpl();
		UserProfile user = new UserProfile("THOMAS", "PASS");
		int rval = userDao.createUserProfile(user);

		assert (rval == 1); // One line changed

		Connection con = ConnectionUtil.getConnection();

		Statement stmt = con.createStatement();

		ResultSet rs = stmt.executeQuery("SELECT PWD FROM USER_PROFILE WHERE USERNAME = 'THOMAS'");

		assert (rs.next());

		assert (rs.getString(1).equals("PASS")); // Password is pass

		user.setPassword("NEWPASS");
		rval = userDao.updateUserProfile(user);
		assert (rval == 1);

		con = ConnectionUtil.getConnection();

		stmt = con.createStatement();

		rs = stmt.executeQuery("SELECT PWD FROM USER_PROFILE WHERE USERNAME = 'THOMAS'");

		assert (rs.next());

		assert (rs.getString(1).equals("NEWPASS")); // Password has been changed
	}

	@Ignore
	@Test
	public void getNonExistantUser() throws Exception {
		UserProfileDaoImpl userDao = new UserProfileDaoImpl();
		UserProfile user = userDao.getUserProfile("THOMAS", "PASS");
		assert (user == null); // Returns a null user
	}

	@Test
	public void getUser() throws Exception {
		UserProfileDaoImpl userDao = new UserProfileDaoImpl();
		UserProfile user = new UserProfile("THOMAS", "PASS");
		int rval = userDao.createUserProfile(user);
		assert (rval == 1);

		user = userDao.getUserProfile(user.getUsername(), user.getPassword());
		assert (user != null);

		Connection con = ConnectionUtil.getConnection();

		Statement stmt = con.createStatement();

		ResultSet rs = stmt.executeQuery("SELECT * FROM USER_PROFILE WHERE USERNAME = 'THOMAS' AND PWD = 'PASS'");

		assert (rs.next());

		assert (rs.getString("USERNAME").equals("THOMAS") && rs.getString("PWD").equals("PASS")); // Verifies that the
																									// user was
																									// successfully
																									// added
	}

	@AfterClass
	public static void cleanUp() {
		assert (DBScrub.scrub());
	}

}
