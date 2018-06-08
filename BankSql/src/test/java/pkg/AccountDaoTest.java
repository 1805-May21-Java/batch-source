package pkg;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;

import org.junit.AfterClass;
import org.junit.Before;
import org.junit.Test;

import com.Revature.Dao.BankAccountDaoImpl;
import com.Revature.Dao.UserProfileDaoImpl;
import com.Revature.pojos.BankAccount;
import com.Revature.pojos.UserProfile;
import com.Revature.util.ConnectionUtil;

public class AccountDaoTest {
	@Before
	public void scrubber() {
		assert (DBScrub.scrub());
	}

	@Test(expected = Exception.class)
	public void checkDuplicateAccountNumbers() throws Exception {
		UserProfileDaoImpl userDao = new UserProfileDaoImpl();
		String username = "THOMAS";
		String password = "PASS";
		UserProfile user = new UserProfile(username, password); //Create a user to link accounts to 
		int rval = userDao.createUserProfile(user);
		assert (rval == 1);

		BankAccountDaoImpl bankDao = new BankAccountDaoImpl();
		int accountNumber = bankDao.getNextAccountNumber();
		assert (accountNumber != -1);
		BankAccount account = new BankAccount(accountNumber, 0f);

		rval = bankDao.createBankAccount(user, account);
		assert (rval == 2);
		rval = bankDao.createBankAccount(user, account); //Attempt to create the same account and link twice
	}
	
	@Test(expected = Exception.class) 
	public void addSameProfileToAccount() throws Exception {
		UserProfileDaoImpl userDao = new UserProfileDaoImpl();
		UserProfile user = new UserProfile("THOAMS","PASS");
		userDao.createUserProfile(user);
		
		BankAccountDaoImpl bankDao = new BankAccountDaoImpl();
		
		bankDao.createBankAccount(user, new BankAccount(0,0f));
		bankDao.addProfileToBankAccount(user, new BankAccount(0,0f));
		
	}

	@Test
	public void createAccount() throws Exception {
		UserProfileDaoImpl userDao = new UserProfileDaoImpl();
		UserProfile user = new UserProfile("THOMAS", "PASS");
		int rval = userDao.createUserProfile(user);
		assert (rval == 1);

		BankAccountDaoImpl bankDao = new BankAccountDaoImpl();
		int accountNumber = bankDao.getNextAccountNumber();

		assert (accountNumber != -1);

		BankAccount bank = new BankAccount(accountNumber, 0f);
		rval = bankDao.createBankAccount(user, bank); //Creates the bank account linked to THOMAS
		assert (rval == 2);

		Connection con = ConnectionUtil.getConnection();

		Statement stmt = con.createStatement();

		ResultSet rs = stmt.executeQuery("SELECT ACC_NUMBER FROM PROFILE_ACCOUNT WHERE USERNAME = 'THOMAS'");

		assert(rs.next()); //Verifies that the account number is the same and the link is OK
		
		assert(rs.getInt("ACC_NUMBER") == accountNumber);
		
	}

	@Test(expected = Exception.class)
	public void createAccountWithNonExistantProfile() throws Exception {
		UserProfile user = new UserProfile("THOMAS", "PASS");
		BankAccountDaoImpl bankDao = new BankAccountDaoImpl();
		int accountNumber = bankDao.getNextAccountNumber();
		assert (accountNumber != -1);

		BankAccount bank = new BankAccount(accountNumber, 0f);
		bankDao.createBankAccount(user, bank); //Exception thrown before the link should fail to be initialized
		//The foreign key does not reference a PK
	}

	@Test
	public void addProfileToAccount() throws Exception {
		UserProfile user1 = new UserProfile("THOMAS", "PASS");
		UserProfile user2 = new UserProfile("DANA", "PASS");
		UserProfileDaoImpl userDao = new UserProfileDaoImpl();

		int rval = userDao.createUserProfile(user1);
		assert (rval == 1);
		rval = userDao.createUserProfile(user2);
		assert (rval == 1);
		//Creates both users

		BankAccountDaoImpl bankDao = new BankAccountDaoImpl();
		int accountNumber = bankDao.getNextAccountNumber();
		assert (accountNumber != -1);
		BankAccount bank = new BankAccount(accountNumber, 0f);

		rval = bankDao.createBankAccount(user1, bank); //Creates the initial link to THOMAS
		assert (rval == 2);
		rval = bankDao.addProfileToBankAccount(user2, bank); //Adds DANA as a joint profile
		assert (rval == 1);
		
		Connection con = ConnectionUtil.getConnection();

		Statement stmt = con.createStatement();

		ResultSet rs = stmt.executeQuery("SELECT COUNT(ACC_NUMBER) FROM PROFILE_ACCOUNT WHERE ACC_NUMBER = '" + accountNumber + "'");
		
		assert(rs.next());
		
		assert(rs.getInt(1) == 2); //Verifies that there are two links to the account

	}

	@Test(expected = Exception.class)
	public void addProfileToNonExistantAccount() throws Exception {
		UserProfile user1 = new UserProfile("THOMAS", "PASS");
		UserProfileDaoImpl userDao = new UserProfileDaoImpl();

		int rval = userDao.createUserProfile(user1);
		assert (rval == 1);

		BankAccountDaoImpl bankDao = new BankAccountDaoImpl();
		int accountNumber = bankDao.getNextAccountNumber();
		assert (accountNumber != -1);
		BankAccount bank = new BankAccount(accountNumber, 0f);

		rval = bankDao.addProfileToBankAccount(user1, bank);
		
		//Foreign key reference is not a valid PK
	}

	@AfterClass
	public static void cleanUp() {
		assert (DBScrub.scrub());
	}

}
