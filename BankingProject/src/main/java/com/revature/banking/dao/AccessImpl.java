package com.revature.banking.dao;

import java.io.IOException;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.revature.banking.pojos.Account;
import com.revature.banking.util.ConnectionUtil;

public class AccessImpl implements AccessDao{
	
	protected Connection connect;
	
	public Account signUp(String user, String pass) {
		Account newAccount=null;
		ResultSet result=null;
		try {
			connect=ConnectionUtil.getConnection();
			PreparedStatement state= connect.prepareStatement("SELECT USER_NAME FROM ACCOUNTS WHERE USER_NAME=?");
			state.setString(1, user);
			result=state.executeQuery();
			
			if(!result.next()) {
				state=connect.prepareStatement("INSERT INTO ACCOUNTS(USER_NAME, PASS) VALUES(?,?)");
				state.setString(1, user);
				state.setString(2, pass);
				state.executeUpdate();
				
				state=connect.prepareStatement("SELECT USER_ID FROM ACCOUNTS WHERE USER_NAME=? AND PASS=?");
				state.setString(1, user);
				state.setString(2, pass);
				result=state.executeQuery();
				result.next();
				
				newAccount = new Account(result.getInt(1), user, pass);
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		return newAccount;
	}
	
	public Account logIn(String user, String pass) {
		Account account=null;
		ResultSet result=null;
		
		try {
			connect=ConnectionUtil.getConnection();	
			PreparedStatement state=connect.prepareStatement("SELECT USER_ID FROM ACCOUNTS WHERE USER_NAME=? AND PASS=?");
			state.setString(1, user);
			state.setString(2, pass);
			result=state.executeQuery();
			
			if(result.next()) {
				account= new Account(result.getInt(1), user, pass);
				//connect.close();
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		return account;
	}
	
	
	
}
