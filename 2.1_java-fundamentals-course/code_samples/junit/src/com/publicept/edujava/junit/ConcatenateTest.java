package com.publicept.edujava.junit;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class ConcatenateTest {

	@Test
	void testConcatenate() {
		Concatenate conca = new Concatenate();
		String result = conca.concatenate("one", "two");
		assertEquals("onetwo", result);
	}

}
