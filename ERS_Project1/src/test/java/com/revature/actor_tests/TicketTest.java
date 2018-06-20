package com.revature.actor_tests;

import static org.junit.Assert.*;

import org.junit.Test;

import com.revature.actors.GateKeeper;
import com.revature.actors.Ticket;

public class TicketTest {

	@Test
	public void testTicketFail1() {
		boolean ticket = Ticket.checkComplete(1, "", "");
		assert(!ticket && GateKeeper.getWarning() == "All fields must be completed.");
	}
	
	@Test
	public void testTicketFail2() {
		boolean ticket = Ticket.checkComplete(1, "thirty", "hello");
		assert(!ticket && GateKeeper.getWarning() == "That wasn't a valid money amount.");
	}
	
	@Test
	public void testTicketFail3() {
		boolean ticket = Ticket.checkComplete(1, "-1", "hello");
		assert(!ticket && GateKeeper.getWarning() == "Can't request negative money.");
	}
	
	

}
