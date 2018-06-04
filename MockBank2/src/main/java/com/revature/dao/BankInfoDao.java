package com.revature.dao;

import java.util.List;

import com.revature.pojos.OBankInfo;

public interface BankInfoDao {
	public List<OBankInfo> bankInfo();
	public OBankInfo getOBankInfoByUserPass(String user, String pass);
	public int createBankAccount(OBankInfo bankInfo);
	public int updateBankAccount(OBankInfo bankInfo);
	public int deleteBankAccount(String user, String pass);
	public void increaseChecking(int uid, double value);
	public void decreaseChecking(int uid, double value);
	public void increaseSaving(int uid, double value);
	public void decreaseSaving(int uid, double value);
	
}
