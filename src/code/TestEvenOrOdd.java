package code;

import static org.junit.Assert.*;

import org.junit.Test;

public class TestEvenOrOdd {

	@Test
	public void testEvenOrOdd() {
		EvenOrOdd eoo = new EvenOrOdd();
		assertEquals(eoo.even_or_odd(6), "Even");
		assertEquals(eoo.even_or_odd(7), "Odd");
		assertEquals(eoo.even_or_odd1(6), "Even");
		assertEquals(eoo.even_or_odd1(7), "Odd");
	}

}
