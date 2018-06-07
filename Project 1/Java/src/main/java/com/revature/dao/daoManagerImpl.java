package com.revature.dao;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.revature.pojos.Manager;
import com.revature.util.ConnectionUtil;
import com.revature.util.ERSContract;

public class daoManagerImpl implements daoManager {

	public Manager getManagerById(int managerId) {
		try(Connection connection = ConnectionUtil.getConnection()){
			String sql = String.format("SELECT * FROM %s WHERE %s = ?",
					ERSContract.MANAGER_TABLE_NAME,ERSContract.MANAGER_ID);
			PreparedStatement preparedStatement = connection.prepareStatement(sql);
			System.out.println(sql+managerId);
			preparedStatement.setInt(1, managerId);
			ResultSet resultSet = preparedStatement.executeQuery();
			while(resultSet.next()) {
				System.out.println(resultSet.getString(ERSContract.MANAGER_NAME));
				return new Manager(
						resultSet.getString(ERSContract.MANAGER_NAME),
						resultSet.getString(ERSContract.MANAGER_EMAIL),
						resultSet.getString(ERSContract.MANAGER_PASSWORD));
			}
		} catch (SQLException | IOException e) {
			e.printStackTrace();
		}
		return null;
	}
	
	public int insertNewManager(Manager manager) {
		return 0;
	}

	public boolean updateOldManager(Manager manager) {
		return false;
	}

	public Manager managerLogin(String email, String password) {
		return null;
	}

	public boolean deleteManagerById(int id) {
		return true;
	}

	public boolean deletAllEmployees(int id) {
		return false;
	}

}
