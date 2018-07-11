package java_test;



import org.junit.jupiter.api.Test;

import com.revature.dao.EmployeeDao;
import com.revature.dao.EmployeeDaoImpl;

class DaoImplTest {

	@Test
	void isAuthenticated()
	{
		EmployeeDao dao = new EmployeeDaoImpl();
		Boolean isAuthenticated =dao.isAuthenticated("justin", "pwd");
		System.out.println(isAuthenticated);
	}

}
