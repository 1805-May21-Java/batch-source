package com.revature;

import static org.junit.Assert.*;

import org.junit.BeforeClass;
import org.junit.Test;

import com.revature.menus.AccountMenu;

public class ValidateInputTest {

	static AccountMenu menu;
	
	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		menu = new AccountMenu();
	}
	
	@Test
	public void testNegativeNumber() {
		assertEquals(menu.validateInput(-5.0), false);
	}
	
	@Test
	public void testSmallNumber() {
		assertEquals(menu.validateInput(0.005), false);
	}

	@Test
	public void testMultipleDecimals() {
		assertEquals(menu.validateInput(5.555), false);
	}
	
	@Test
	public void testNormalNumber() {
		assertEquals(menu.validateInput(55.55), true);
	}
	
}
