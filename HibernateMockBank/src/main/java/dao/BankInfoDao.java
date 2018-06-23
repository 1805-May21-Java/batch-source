package dao;

import java.util.List;

import pojos.OBankInfo;


public interface BankInfoDao {
	public List<OBankInfo> bankInfo();
	public OBankInfo getOBankInfoByUserPass(int id);
	public int createBankAccount(OBankInfo bankInfo);
	public int updateBankAccount(OBankInfo bankInfo);
	public int deleteBankAccount(int id);
	public void increaseChecking(int uid, double value);
	public void decreaseChecking(int uid, double value);
	public void increaseSaving(int uid, double value);
	public void decreaseSaving(int uid, double value);
	public boolean checkEqualUser(String user);
	public boolean checkEqualEmail(String email);
}
