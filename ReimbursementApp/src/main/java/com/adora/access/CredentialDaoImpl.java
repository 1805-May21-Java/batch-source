package com.adora.access;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.adora.pojos.Credential;
import com.adora.utils.ConnectionUtil;

public class CredentialDaoImpl implements CredentialDao {

	public int createCredentials(Credential credential) {
		// TODO Auto-generated method stub
		return 0;
	}

	public Credential checkCredentials(Credential credential) {
		Credential validCredential = new Credential();
		
		try(Connection connection = ConnectionUtil.getConnection()) {
			String sql = "SELECT * FROM credential WHERE user_name = ? AND user_pass  = ?";
			PreparedStatement ps = connection.prepareStatement(sql);
			ps.setString(1, credential.getUsername());
			ps.setString(2, credential.getPassword());
			ResultSet rs = ps.executeQuery();

			while(rs.next()) {
				validCredential.setUsername(rs.getString("user_name"));
				validCredential.setPassword(rs.getString("user_pass"));
				validCredential.setEmployee_id(rs.getInt("employee_id"));
				System.out.println(validCredential.getEmployee_id());
			}
		} catch (SQLException | IOException e) {
			e.printStackTrace();
		}
		return validCredential;
	}

	@Override
	public Credential getCredentials(int employeeId) {
		Credential credential = new Credential();
		try(Connection connection = ConnectionUtil.getConnection()) {
			String sql = "SELECT * FROM credential WHERE employee_id = ?";
			PreparedStatement ps = connection.prepareStatement(sql);
			ps.setInt(1, employeeId);
			ResultSet rs = ps.executeQuery();
			
			while(rs.next()) {
				credential.setEmployee_id(rs.getInt("employee_id"));
				credential.setUsername(rs.getString("user_name"));
				credential.setPassword(rs.getString("user_pass"));
			}
		} catch (SQLException | IOException e) {
			e.printStackTrace();
		}
		return credential;
	}

	

}
