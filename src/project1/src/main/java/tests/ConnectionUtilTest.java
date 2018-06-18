package tests;

import static org.junit.Assert.*;

import java.io.IOException;
import java.sql.SQLException;

import org.junit.Test;

import util.ConnectionUtil;

public class ConnectionUtilTest {

	@Test
	public void test() throws SQLException, IOException {
		ConnectionUtil connection = new ConnectionUtil();
		assertFalse(ConnectionUtil.getConnection().isClosed());
	}

}
