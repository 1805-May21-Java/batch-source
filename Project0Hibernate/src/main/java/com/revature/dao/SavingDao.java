package com.revature.dao;

import java.util.Map;

import com.revature.pojos.Saving;

public interface SavingDao
{
	public Map<Integer,Saving> getSaving();
	public Saving getSavingById(int id);
	public int createSaving(Saving save);
	public int updateSaving(Saving save);
	public int deleteSaving(Saving save);
}
