package project0.src.main.java.project0.data;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import project0.src.main.java.project0.interfaces.UserInterface;


public class UserDao implements UserInterface {
	
	private String insertUser = "INSERT INTO Usertable (userId, userName, password, accountId) values (seq_pk_userId.nextval, ?, ?, ?)";
	private String checkUser = "SELECT * FROM userTable where username = ?";
	private String getUserById = "SELECT * FROM userTable where userId = ?";
	private String getUserbyName = "SELECT * FROM userTable where username = ?";

	@Override
	public boolean checkUser(Connection connection, String username) throws SQLException {
		if(username.length()>50){
			return true;
		} else {
			PreparedStatement ps = connection.prepareStatement(checkUser, new String[] {"USERNAME"});
			ps.setString(1, username);
			ResultSet rs = ps.executeQuery();
			if(rs != null && rs.next()) {
				return true;
			} else return false;
		}
	}

	@Override
	public User getUserById(Connection connection, long userId) throws SQLException {
		User returnUser = null;
		PreparedStatement ps = connection.prepareStatement(getUserById);
		ps.setLong(1, userId);
		ResultSet rs = ps.executeQuery();
		while(rs.next()){
			returnUser = new User(rs.getString("username"), rs.getString("password"), rs.getLong("userId"), rs.getLong("accountId"));
		}
		return returnUser;
	}

	@Override
	public User getUserByName(Connection connection, String username) throws SQLException {
		User returnUser = null;
		PreparedStatement ps = connection.prepareStatement(getUserbyName);
		ps.setString(1, username);
		ResultSet rs = ps.executeQuery();
		while(rs.next()){
			returnUser = new User(rs.getString("username"), rs.getString("password"), rs.getLong("userId"), rs.getLong("accountId"));
		}
		return returnUser;
	}
	
	public ArrayList<User> getUserList(Connection connection) throws SQLException{
		ArrayList<User> userList = new ArrayList();
		String statement = "Select * from Usertable";
		Statement s = connection.createStatement();
		ResultSet rs = s.executeQuery(statement);
		while(rs.next()){
			userList.add(new User(rs.getString("username"), rs.getString("password"), rs.getLong("userId"), rs.getLong("accountId")));
		}
		return userList;
		
	}

	@Override
	public long createUser(Connection connection, String username, String password, AccountDao account) throws SQLException {
		PreparedStatement ps = connection.prepareStatement(insertUser, new String[] {"userID"});
		ps.setString(1, username);
		ps.setString(2, password);
		ps.setLong(3, account.createAccount(connection));
		ps.executeUpdate();
		ps.getGeneratedKeys().next();
		return ps.getGeneratedKeys().getLong(1);
	}

	@Override
	public long createUser(Connection connection, String username, String password, Account account)
			throws SQLException {
		PreparedStatement ps = connection.prepareStatement(insertUser, new String[] {"userID"});
		ps.setString(1, username);
		ps.setString(2, password);
//		ps.setLong(3, account.createAccount(connection));
		ps.executeUpdate();
		ps.getGeneratedKeys().next();
		return ps.getGeneratedKeys().getLong(1);
	}

}
