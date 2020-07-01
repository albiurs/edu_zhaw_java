package com.publicept.Junit4;

import org.junit.Before;
import org.junit.Test;

import static junit.framework.TestCase.assertEquals;
import static junit.framework.TestCase.fail;

public class EuroTest {

	private Euro two;

	@Before
	public void setUp() throws Exception {
		two = new Euro(2.0);
	}

	@Test
	public void testAdding() throws Exception {
		two.add(two);
		assertEquals(new Euro(4.0).getAmount(), two.getAmount());
	}

	@Test (expected = IllegalArgumentException.class)
	public void testInvalid() throws Exception {
			two.add(new Euro(-2.0));
	}
}


