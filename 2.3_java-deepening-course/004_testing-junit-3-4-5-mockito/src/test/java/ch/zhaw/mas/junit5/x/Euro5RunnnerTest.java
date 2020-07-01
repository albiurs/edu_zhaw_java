package ch.zhaw.mas.junit5.x;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;

import static org.junit.Assert.assertEquals;

public class Euro5RunnnerTest {
	private Euro two;

	@BeforeEach
	public  void setUp() throws Exception {
		two = new Euro(2.0);
	}

	@Test
	public void testAdding() throws Exception {
		two.add(two);
		assertEquals(new Euro(4.0).getAmount(), two.getAmount(), 0.01); 
	}

	@Test
	public void testInvalid() throws Exception {
		Assertions.assertThrows(IllegalArgumentException.class, () -> {
			two.add(new Euro(-2.0));
		});

	}
}
