package com.publicept.edujava.junit;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class BothMethodsTest {
	
	private static BothMethods bm;
	
	/**
	 * Main constructor of test class.
	 */
	public BothMethodsTest() {
		
	}
	
	/**
	 * Sets up the test fixture for all tests.
	 * 
	 * Called before all test cases.
	 */
	@BeforeAll
	public static void setUpAll() {
		bm = new BothMethods();
	}
	
	/**
	 * Sets up the "each"-test fixture.
	 * 
	 * Called before every test case method.
	 */
	@BeforeEach
	public void setUpEach() {
		
	}
	
	/**
	 * Tears down the test fixture of all tests.
	 * 
	 * Called after all test cases.
	 */
	@AfterAll
	public static void tearDownAll() {
		
	}
	
	/**
	 * Tears down the "each"-test fixture.
	 * 
	 * Called after every test case.
	 */
	@AfterEach
	public void tearDownEach() {
		
	}

	@Test
	void testConcatenate() {
		String result = bm.concatenate("one", "two");
		assertEquals("onetwo", result);
	}
	
	@Test
	void testMultiply() {
		int result = bm.multyply(3, 4);
		assertEquals(12, result);
	}

}
