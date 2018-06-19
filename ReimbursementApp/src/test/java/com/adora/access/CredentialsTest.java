package com.adora.access;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import com.adora.pojos.Credential;

class CredentialsTest {

	@Test
	void testCredentials() {
		Credential credential = new Credential("rkonig", "superpass");
		CredentialDaoImpl cdi = new CredentialDaoImpl();
		Credential validCredential = cdi.checkCredentials(credential);
		
		assertEquals(1002, validCredential.getEmployee_id());
		
	}

}
