package com.revature.actor_tests;

import static org.junit.Assert.*;

import org.junit.Test;

import com.revature.actors.GateKeeper;
import com.revature.pojos.Employee;

public class GateKeeperTests {

	@Test
	public void testValidLogin() {
		boolean login = GateKeeper.validLogin("ADMIN@EXAMPLE.COM", "pwd");
		assert(login);
	}
	
	@Test
	public void testInvalidLogin1() {
		boolean login = GateKeeper.validLogin("", "");
		assert(!login && GateKeeper.getWarning() == "All fields must be completed");
	}
	
	@Test
	public void testInvalidLogin2() {
		boolean login = GateKeeper.validLogin("shkjsbhvs", "sdcb");
		assert(!login && GateKeeper.getWarning() == "Invalid email");
	}
	
	@Test
	public void testInvalidLogin3() {
		boolean login = GateKeeper.validLogin("ADMIN@EXAMPLE.COM", "password");
		assert(!login && GateKeeper.getWarning() == "Email and password didn't match any of our clients.");
	}
	
	@Test
	public void testFailRegistration1() {
		boolean register = GateKeeper.attemptRegistration("", "", "", "", "", "");
		assert(!register && GateKeeper.getWarning() == "All fields must be completed.");
	}
	
	@Test 
	public void testFailRegistration2() {
		boolean register = GateKeeper.attemptRegistration("AD", "MIN", "NEWEMAIL@EMAIL>COM", "1", "123", "321");
		assert(!register && GateKeeper.getWarning() == "Confirmation password didn't match.");
	}
	
	@Test
	public void testFailRegistration3() {
		boolean register = GateKeeper.attemptRegistration("ksjevbls", "bzr", "saehs", "segse", "serg", "serg");
		assert(!register && GateKeeper.getWarning() == "Invalid email");
	}
	
	@Test
	public void testFailRegistration4() {
		boolean register = GateKeeper.attemptRegistration("AD", "MIN", "ADMIN@EXAMPLE.COM", "1", "1", "1");
		assert(!register && GateKeeper.getWarning() == "That email is already being used for an account");
	}
	
	@Test
	public void testFailRegistration5() {
		boolean register = GateKeeper.attemptRegistration("MIN", "AD", "MINAD@EXAMPLE.COM", "-1", "1", "1");
		assert(!register && GateKeeper.getWarning() == "Invalid Registration Code");
	}
	
	@Test
	public void testUpdateFail1() {
		Employee emp = new Employee();
		emp.setFirstName("");
		emp.setLastName("");
		emp.setEmail("");
		boolean update = GateKeeper.attemptUpdateInfo(emp);
		
		assert(!update && GateKeeper.getWarning() == "No field can be left blank");
	}
	
	@Test
	public void testUpdateFail2() {
		Employee emp = new Employee();
		emp.setFirstName("A");
		emp.setLastName("B");
		emp.setEmail("C");
		boolean update = GateKeeper.attemptUpdateInfo(emp);
		assert(!update && GateKeeper.getWarning() == "Invalid email address");
		
	}
	
	@Test
	public void testPasswordFail1() {
		boolean pass = GateKeeper.attemptPasswordChange(1, "", "", "");
		assert(!pass && GateKeeper.getWarning() == "All fields must be completed");
	}
	
	@Test
	public void testPasswordFail2() {
		boolean pass = GateKeeper.attemptPasswordChange(1, "password", "pwd", "pwd");
		assert(!pass && GateKeeper.getWarning() == "Current password incorrectly entered");
	}
	
	@Test
	public void testPasswordFail3() {
		boolean pass = GateKeeper.attemptPasswordChange(1, "pwd", "apple", "juice");
		assert(!pass && GateKeeper.getWarning() == "New password and confirmation didn't match");
	}

}
