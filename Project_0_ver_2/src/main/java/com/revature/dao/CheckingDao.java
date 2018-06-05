package com.revature.dao;
import java.util.Map;
import com.revature.pojos.Checking;

//It's an interface
public interface CheckingDao
{
	public Map<Integer,Checking> getChecking();
	public Checking getCheckingById(int id);
	public int createChecking(Checking check);
	public int updateChecking(Checking check);
	public int deleteChecking(Checking check);
}
