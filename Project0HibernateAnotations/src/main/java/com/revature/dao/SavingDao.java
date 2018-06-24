package com.revature.dao;

import java.util.List;
import java.util.Map;

import com.revature.pojos.Saving;

public interface SavingDao
{
	public List<Saving> getSaving();
	public List<Saving> getSavingsByUserId(int id);
	public int createSaving(Saving save);
	public void updateSaving(Saving save);
	public void deleteSaving(Saving save);
}
