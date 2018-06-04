package com.revature;

import static org.junit.Assert.*;

import org.junit.Test;

import com.revature.util.BankScanner;

public class BankScannerTest {

	@Test
	public void singletonScanner() {
		Object scanner1 = BankScanner.getInstance();
		Object scanner2 = BankScanner.getInstance();
		
		assert(scanner1 == scanner2);
	}

}
