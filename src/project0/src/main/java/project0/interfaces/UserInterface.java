package project0.src.main.java.project0.interfaces;

import java.sql.Connection;
import java.sql.SQLException;

import project0.src.main.java.project0.data.Account;
import project0.src.main.java.project0.data.AccountDao;
import project0.src.main.java.project0.data.User;

public interface UserInterface {
	long createUser(Connection connection, String username, String password, Account account) throws SQLException;
	boolean checkUser(Connection connection, String username) throws SQLException;
	User getUserById(Connection connection, long userId) throws SQLException;
	User getUserByName(Connection connection, String username) throws SQLException;
	long createUser(Connection connection, String username, String password, AccountDao account) throws SQLException;
}
