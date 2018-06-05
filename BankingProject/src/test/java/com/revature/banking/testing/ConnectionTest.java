package com.revature.banking.testing;

import static org.junit.Assert.*;

import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;

import org.junit.Test;

import com.revature.banking.util.ConnectionUtil;

public class ConnectionTest {

	@Test
	public void successfullConnection() throws SQLException, IOException {
		ConnectionUtil.getConnection();
	}

}
