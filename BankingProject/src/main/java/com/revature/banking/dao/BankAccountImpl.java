package com.revature.banking.dao;

import java.io.IOException;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import com.revature.banking.util.ConnectionUtil;

public class BankAccountImpl implements BankAccountDao{
	protected int user_id;
	protected int acc_num;
	protected String acc_type;
	protected double balance;
	
	public boolean withdraw(double amount) {
		if(amount>=0 && amount<=balance) {
			balance-=amount;
			try {
				PreparedStatement state=ConnectionUtil.getConnection().prepareStatement("UPDATE BANK_ACCOUNTS SET BALANCE=? WHERE ACC_NUM=?");
				state.setDouble(1, balance);
				state.setInt(2, acc_num);
				state.executeUpdate();
				
			} catch (SQLException | IOException e) {
				e.printStackTrace();
			}
			return true;
		}
		else
			return false;
	}
	
	public boolean depsoit(double amount) {
		if(amount>=0) {
			balance+=amount;
			try {
				PreparedStatement state=ConnectionUtil.getConnection().prepareStatement("UPDATE BANK_ACCOUNTS SET BALANCE=? WHERE ACC_NUM=?");
				state.setDouble(1, balance);
				state.setInt(2, acc_num);
				state.executeUpdate();
			
			} catch (SQLException | IOException e) {
				e.printStackTrace();
			}
			return true;
		}
		else
			return false;
	}
	
	
}
