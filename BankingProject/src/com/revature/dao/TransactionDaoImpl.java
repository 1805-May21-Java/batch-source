package com.revature.dao;

import java.io.IOException;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.revature.bank.Account;
import com.revature.bank.Transaction;

import oracle.jdbc.OracleTypes;

public class TransactionDaoImpl implements TransactionDao {

	@Override
	public List<Transaction> getAllTransactions(Account account) {
		List<Transaction> transactions = new ArrayList<>();
		try {
			Connection con = ConnectionUtil.getConnection();
			String sql = "{call GETTRANSACTIONS(?,?)}";
			CallableStatement cs = con.prepareCall(sql);
			cs.setString(1, account.getUsername());
			ResultSet rSet;
			cs.registerOutParameter(2, OracleTypes.CURSOR);
			cs.execute();
			rSet = (ResultSet) cs.getObject(2);
			while(rSet.next()) {
				transactions.add(new Transaction(rSet.getString("acct_username"),rSet.getInt("transaction_id"),
						rSet.getString("action"),rSet.getFloat("amount"),rSet.getString("date_of_transaction")));
			}
			con.close();

			
		} catch (IOException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return transactions;
	}

}
