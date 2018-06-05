package pkg;

import static org.junit.Assert.*;

import java.util.List;

import org.junit.AfterClass;
import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;

import com.Revature.Dao.BankAccountDaoImpl;
import com.Revature.Dao.ProfileAccountDaoImpl;
import com.Revature.Dao.UserProfileDaoImpl;
import com.Revature.pojos.BankAccount;
import com.Revature.pojos.UserProfile;

public class ProfileAccountDaoTest {

	@Before
	public void scrubber() {
		assert (DBScrub.scrub());
	}

	@Test
	public void testGetAccNumbers() throws Exception {
		UserProfileDaoImpl userDao = new UserProfileDaoImpl();
		UserProfile user = new UserProfile("THOMAS", "PASS");
		int rval = userDao.createUserProfile(user); // Creates a user

		assert (rval == 1); // One line changed

		BankAccountDaoImpl bankDao = new BankAccountDaoImpl();
		BankAccount bank = new BankAccount(bankDao.getNextAccountNumber(), 0f);
		bankDao.createBankAccount(user, bank); // Link new bank account to user

		ProfileAccountDaoImpl linkDao = new ProfileAccountDaoImpl();

		List<Integer> list = linkDao.getAllAccountNumbers("THOMAS"); // Get all account numbers from THOMAS

		assert (list.get(0) == bank.getAccountNumber()); // Verify that the account number is the previous bank

		for (int i = 0; i < 3; i++) {
			bankDao.createBankAccount(user, new BankAccount(bankDao.getNextAccountNumber(), 0f)); // Add three more
																									// banks
		}

		list = linkDao.getAllAccountNumbers("THOMAS");

		for (int i = 0; i < 4; i++) { // DB is scrubbed before each test
			// Sequence is reset meaning account numbers should be 0-3
			assert (list.contains(i));
		}
	}

	@Test
	public void attemptAccountNumbersForNonExistant() throws Exception {
		ProfileAccountDaoImpl linkDao = new ProfileAccountDaoImpl();

		List<Integer> list = linkDao.getAllAccountNumbers("THOMAS"); // Attempts a get with a non existent user

		assert (list.size() == 0); // List size is zero
	}

	@Test
	public void getUsernames() throws Exception {
		UserProfileDaoImpl userDao = new UserProfileDaoImpl();
		UserProfile user1 = new UserProfile("THOMAS", "PASS");
		UserProfile user2 = new UserProfile("DANA", "PASS");

		userDao.createUserProfile(user1); // Creates both users
		userDao.createUserProfile(user2);

		BankAccountDaoImpl bankDao = new BankAccountDaoImpl();
		BankAccount acc = new BankAccount(bankDao.getNextAccountNumber(), 0f);
		bankDao.createBankAccount(user1, acc);
		bankDao.addProfileToBankAccount(user2, acc); // Defines a link to the first user and a bank account
		// Adding the second user as a joint user to the same account

		ProfileAccountDaoImpl linkDao = new ProfileAccountDaoImpl();

		List<String> list = linkDao.getAllUsernames(acc.getAccountNumber());

		assert (list.contains("THOMAS"));

		assert (list.contains("DANA")); // Verifies that both users are linked to the bank account
	}

	@Test
	public void attemptGetUsernamesNonExistant() throws Exception {
		ProfileAccountDaoImpl linkDao = new ProfileAccountDaoImpl();

		List<String> list = linkDao.getAllUsernames(0); // Attempts to get all users linked to a non existent account

		assert (list.size() == 0); // Size is 0
	}

	@Test
	public void getAccounts() throws Exception {
		UserProfileDaoImpl userDao = new UserProfileDaoImpl();
		UserProfile user = new UserProfile("THOMAS", "PASS"); // Creates a user
		userDao.createUserProfile(user);

		BankAccountDaoImpl bankDao = new BankAccountDaoImpl();

		for (int i = 0; i < 4; i++) {
			BankAccount bank = new BankAccount(i, 0f);
			bankDao.createBankAccount(user, bank); // Links 4 accounts
		}

		ProfileAccountDaoImpl linkDao = new ProfileAccountDaoImpl();

		List<BankAccount> list = linkDao.getAllAccounts("THOMAS");

		for (int i = 0; i < 4; i++) { // Verifies that the accounts are all linked to THOMAS
			BankAccount temp = new BankAccount(i, 0f);
			assert (list.contains(temp));
		}
	}

	@Test
	public void getUsers() throws Exception {
		UserProfileDaoImpl userDao = new UserProfileDaoImpl();

		UserProfile user1 = new UserProfile("0:", "PASS");
		userDao.createUserProfile(user1);

		BankAccountDaoImpl bankDao = new BankAccountDaoImpl();
		bankDao.createBankAccount(user1, new BankAccount(0, 0f));

		for (int i = 1; i < 4; i++) { // Create 4 users with <number>: as username
			UserProfile user = new UserProfile(i + ":", "PASS");
			userDao.createUserProfile(user);

			bankDao.addProfileToBankAccount(user, new BankAccount(0, 0f));
		}
		
		List<UserProfile> list = new ProfileAccountDaoImpl().getAllUserProfiles(0);
		
		for ( int i = 0; i < 4; i++ ) {
			UserProfile user = new UserProfile(i+":" , "PASS"); //Verify that all users are in the db
			assert(list.contains(user));
		}
	}

	@AfterClass
	public static void cleanUp() {
		assert (DBScrub.scrub());
	}

}
