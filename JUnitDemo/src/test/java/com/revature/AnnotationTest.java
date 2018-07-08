package com.revature;

import static org.junit.Assert.*;

import org.junit.*;

public class AnnotationTest {

	@BeforeClass
	public static void runBeforeClass() {
		System.out.println("called runBeforeClass()");
	}
	
	@AfterClass
	public static void runAfterClass() {
		System.out.println("called afterClass()");
	}

	@Before
	public void runBefore() {
		System.out.println("called runBefore()");
	}
	
	@After
	public void runAfter() {
		System.out.println("called runAfter()");
	}
	
	@Test
	public void test1() {
		System.out.println("ran test1");
	}
	
	@Test
	public void test2() {
		System.out.println("ran test2");
	}
	
	@Test
	public void test3() {
		System.out.println("ran test3");
	}
}
