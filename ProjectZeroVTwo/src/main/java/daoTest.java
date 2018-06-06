import static org.junit.Assert.*;

import java.io.IOException;
import java.sql.*;
import java.util.*;
import org.junit.Test;

import com.revature.dao.*;
import com.revature.pojos.*;
import com.revature.util.*;

public class daoTest
{
	UserDaoImpl udi = new UserDaoImpl();
	MultiAccountDaoImpl madi = new MultiAccountDaoImpl();

	@Test
	public void testConnection()
	{
		try
		{
			Connection con = ConnectionUtil.getConnection();
		}
		catch (IOException e)
		{
			fail("IO Exception thrown");
		}
		catch (SQLException e)
		{
			fail("SQL Exception thrown");
		}
	}

	@Test
	public void testUsersExistEmpty()
	{
		assert udi.usersExist() == false;
	}
	
	@Test
	public void testUsersExistTrue()
	{
		udi.createUser("Jentoft");
		assert udi.usersExist() == true;
	}
	
	
	@Test
	public void testGetAccountsByUser()
	{
		int accountNumber = udi.getAccountsByUser("Jentoft").size();
		
		madi.createAccount("Savings", "Jentoft");
		
		assert udi.getAccountsByUser("Jentoft").size() == accountNumber+1;
	}
	
	
	@Test
	public void nameExistsTest()
	{
		assert udi.nameExists("Jentoft") == true;
		assert udi.nameExists("Something") == false;
	}
	
	@Test
	public void validNameTest()
	{
		assert !udi.isValidName(" ");
		assert !udi.isValidName("Jentoft");
		assert udi.isValidName("Something");
	}
	
	@Test
	public void hasPasswordTest()
	{
		assert !udi.hasPassword("Jentoft");
		assert udi.logIn("Jentoft") != null;
		
		udi.changePassword("sj", "Jentoft");
		
		assert udi.hasPassword("Jentoft");
		assert udi.logIn("Jentoft") == null;
		assert udi.logIn("Jentoft", "sj") != null;
	}
	
	@Test
	public void hasAccountsTest()
	{
		assert udi.hasAccounts("Jentoft");
		
		udi.createUser("Tony");
		assert !udi.hasAccounts("Tony");
	}
	
	@Test
	public void accountByTypeTest()
	{
		assert madi.accountTypeExists("Checking", "Jentoft");
		assert !madi.accountTypeExists("Something", "Jentoft");
		
		assert madi.getAccountByType("Checking", "Jentoft") != null;
		assert madi.getAccountByType("Something", "Jentoft") == null;
	}
	
	@Test
	public void balanceManipulationTest()
	{
		double balance = madi.getAccountBalance("Checking", "Jentoft");
		
		madi.changeBalance("Checking", "Jentoft", 100);
		assert madi.getAccountBalance("Checking", "Jentoft") == balance+100;
	}
	
	@Test
	public void acctsExistTest()
	{
		assert madi.acctsExits("Jentoft");
		assert !madi.acctsExits("Tony");
	}
	
	@Test
	public void validTypeTest()
	{
		assert madi.isValidType("Checking", "Tony");
		assert !madi.isValidType("Checking", "Jentoft");
		assert madi.isValidType("Something", "Jentoft");
		assert !madi.isValidType("    ", "Tony");
	}
}