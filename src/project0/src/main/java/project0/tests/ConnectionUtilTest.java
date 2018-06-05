package project0.tests;

import static org.junit.Assert.*;

import java.io.IOException;
import java.sql.SQLException;

import org.junit.Test;

import project0.util.ConnectionUtil;

public class ConnectionUtilTest {

	@Test
	public void test() throws SQLException, IOException {
		ConnectionUtil connect = new ConnectionUtil();

		System.out.println(connect.getConnection().isClosed());
		assertFalse(connect.getConnection().isClosed());
//		System.out.println(connect.return1());
	}

}
