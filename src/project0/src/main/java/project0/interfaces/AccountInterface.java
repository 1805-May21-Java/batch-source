package project0.interfaces;

import java.sql.Connection;
import java.sql.SQLException;

import project0.data.Account;

public interface AccountInterface {
	long createAccount(Connection connection) throws SQLException;
	double updateBalance(Connection connection, long accountId, double value) throws SQLException;
	double getBalance(Connection connection, long accountId) throws SQLException;
	Account getAccountById(Connection connection, long accountId) throws SQLException;
}
