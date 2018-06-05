import static org.junit.Assert.assertTrue;
import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;
import java.util.List;
import org.junit.jupiter.api.Test;
import com.revature.dao.UserDaoImpl;
import com.revature.pojos.User;

class TestJdbc
{
	@Test
	void getAllUsers()
	{
		UserDaoImpl imp = new UserDaoImpl();
		List<User> users = new ArrayList<>();
		users = imp.getUsers();
		assertTrue(users.size() >0);
	}	
	
	@Test
	void getUserById()
	{
		UserDaoImpl imp = new UserDaoImpl();
		User newUser = imp.getUserById("2");
	//	System.out.println(newUser.toString());
		assertEquals("password2", newUser.getPassword());
	}

	
	@Test
	void updateUserById()
	{
		UserDaoImpl imp = new UserDaoImpl();
		@SuppressWarnings("unused")
		List<User> users = imp.getUsers();
		User newUser = new User("4", "Bondjames", "009", 999.0);
		imp.updateUser(newUser);
		assertEquals( "009", imp.getUserById("4").getPassword());
	}
	
	@Test
	void creatUser()
	{
		UserDaoImpl imp = new UserDaoImpl();
		User newUser = new User("50", "james5", "005", 1200.0);
		imp.createUser(newUser);
	
		assertEquals("005", imp.getUserById("50").getPassword());
	}
	
	
	@Test
	void deleteUserById()
	{
		UserDaoImpl imp = new UserDaoImpl();
		List<User> users = imp.getUsers();
		int originalSize= users.size();
		imp.deleteUserById("50");
		assertTrue(imp.getUsers().size()<originalSize);
	}

}
