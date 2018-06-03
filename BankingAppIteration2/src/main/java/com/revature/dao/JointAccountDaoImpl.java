package com.revature.dao;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import com.revature.util.ConnectionUtil;

public class JointAccountDaoImpl implements JointAccountDao{

	public int joinAccountToNewUser(long accountNumber, int newUser) {
		int joinedUser = 0;
		try {
			Connection conn = ConnectionUtil.getConnection();
			String sql = "INSERT INTO BANKUSER_BANKACCOUNT VALUES (?, ?)";
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setInt(1, newUser);
			ps.setLong(2, accountNumber);
			joinedUser = ps.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return joinedUser;
	}
	
}
