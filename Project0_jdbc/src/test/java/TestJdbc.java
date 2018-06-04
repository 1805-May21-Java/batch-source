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
		assertTrue(users.size() == 4);
//		User user = imp.getUserById("1");
//		System.out.println(user.toString());
//		User newUser = new User("4", "LongBn", "password");
//		imp.updateUser(newUser);
	}
	
	@Test
	void getUserById()
	{
		UserDaoImpl imp = new UserDaoImpl();
		User user = new User();
		User newUser = imp.getUserById("1");
		assertEquals("password", newUser.getPassword());
	}
	
	@Test
	void creatUser()
	{
		UserDaoImpl imp = new UserDaoImpl();
		User newUser = new User("5", "Jamesbond", "007");
		imp.createUser(newUser);
		
		assertEquals("007", imp.getUserById("5").getPassword());
	}
	
	@Test
	void deleteUserById()
	{
		UserDaoImpl imp = new UserDaoImpl();
		List<User> users = imp.getUsers();
		int size = users.size();
		imp.deleteUserById("5");
		users = imp.getUsers();
		assertTrue((size-1)==users.size());
	}
	
	
	
	

}
