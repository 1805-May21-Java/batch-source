package com.revature.dao;

import static org.junit.Assert.*;


import java.util.ArrayList;

import org.junit.Test;

import com.revature.pojos.Reimbursement;
import com.revature.util.ERSContract;

public class DaoReimbursementImplTest {
	static DaoReimbursementImpl dImplR = new DaoReimbursementImpl();
	@Test
	public void saveReimbursement() {
		int id = dImplR.insertNewReimbursement(new Reimbursement("Bob",5.,1,"hi",1));
		assertEquals(dImplR.getReimbursementById(id).getName(), "Bob");
		dImplR.deleteReimbursementById(id);
	}
	@Test
	public void getReimbursementExistingId() {
		//known reimbursement
		Reimbursement reimbursement = dImplR.getReimbursementById(1);
		assertEquals("Plastic forks",reimbursement.getName());
	}

	@Test
	public void getReimbursementNonexistantReimbursement() {
		Reimbursement reimbursement = dImplR.getReimbursementById(-5);
		assertNull(reimbursement);
	}
	@Test
	public void getPendingReimbursements() {
		//There's at least 1 pending reimbursement, so this should return true
		ArrayList<Reimbursement> reimbursementList= dImplR.getPendingReimbursements();
		assertEquals(ERSContract.PENDING, reimbursementList.get(0).getStatus());
	}
	@Test
	public void updateOldReimbursement() {
		 Reimbursement reimbursement= dImplR.getReimbursementById(1);
		 reimbursement.setName("NewName");
		 dImplR.updateOldReimbursement(reimbursement);
		assertEquals(dImplR.getReimbursementById(1).getName(), "NewName");
		//give back old name
		reimbursement.setName("Plastic forks");
		dImplR.updateOldReimbursement(reimbursement);
	}
	@Test
	public void deleteByExistingId() {
		Reimbursement reimbursement = new Reimbursement("Dummy",10.5,ERSContract.APPROVED,"hi",1);
		int id = dImplR.insertNewReimbursement(reimbursement);
		assertEquals(1, dImplR.deleteReimbursementById(id));
	}
	@Test
	public void deleteByNonExistingId() {
		assertEquals(0,dImplR.deleteReimbursementById(-5));
	}
	

}
