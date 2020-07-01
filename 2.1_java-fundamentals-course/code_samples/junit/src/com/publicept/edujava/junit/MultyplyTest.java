package com.publicept.edujava.junit;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class MultyplyTest {

	@Test
	void testMultiply() {
		Multyply mp = new Multyply();
		int result = mp.multyply(3, 4);
		assertEquals(12, result);
	}

}
