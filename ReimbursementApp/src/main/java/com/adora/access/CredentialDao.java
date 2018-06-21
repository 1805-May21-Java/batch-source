package com.adora.access;

import com.adora.pojos.Credential;

public interface CredentialDao {
	//create new credentials
	public int createCredentials(Credential credential);
	//check credentials
	public Credential checkCredentials(Credential credential);
	
	public Credential getCredentials(int employeeId);
	
	//change credential (password)
	public int updateCredentials(Credential credential);
}	
