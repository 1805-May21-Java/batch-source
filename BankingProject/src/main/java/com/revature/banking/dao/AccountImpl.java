package com.revature.banking.dao;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.revature.banking.pojos.BankAccount;
import com.revature.banking.util.ConnectionUtil;

public class AccountImpl implements AccountDao{
	
	protected int user_id;
	protected String user_name;
	protected String pass;
	protected ArrayList<BankAccount> bankAccounts;
	
	@Override
	public ArrayList<BankAccount> accessBankAccounts(int user_id) {
		ArrayList<BankAccount> bankAccounts=new ArrayList<BankAccount>();
		ResultSet result=null;
		try {
			Connection connect = ConnectionUtil.getConnection();
			PreparedStatement state=connect.prepareStatement("SELECT * FROM BANK_ACCOUNTS WHERE USER_ID=?");
			state.setInt(1, user_id);
			result=state.executeQuery();
			
			while(result.next()) {
				bankAccounts.add(new BankAccount(result.getInt("user_id"), result.getInt("acc_num")
						, result.getString("acc_type"), result.getDouble("balance")));
			}
			
			
		} catch (SQLException | IOException e) {
			e.printStackTrace();
		}
		
		return bankAccounts;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		AccountImpl other = (AccountImpl) obj;
		if (bankAccounts == null) {
			if (other.bankAccounts != null)
				return false;
		} else if (!bankAccounts.equals(other.bankAccounts))
			return false;
		if (pass == null) {
			if (other.pass != null)
				return false;
		} else if (!pass.equals(other.pass))
			return false;
		if (user_id != other.user_id)
			return false;
		if (user_name == null) {
			if (other.user_name != null)
				return false;
		} else if (!user_name.equals(other.user_name))
			return false;
		return true;
	}
	
	
	
}
