package com.revature.dao;

import java.util.List;
import java.util.Map;

import com.revature.pojos.Checking;

public interface CheckingDao
{
	public List<Checking> getChecking();
	public List<Checking> getCheckingByUserId(int id);
	public int createChecking(Checking check);
	public void updateChecking(Checking check);
	public void deleteChecking(Checking check);
}
