package com.revature.MockBank2;

import com.revature.dao.BankInfoDaoImpl;
import com.revature.pojos.OBankInfo;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
    	BankInterface bankInterface = new BankInterface();
		bankInterface.bankInterface();
    }
}
