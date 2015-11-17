package proj;

import static org.junit.Assert.*;

import org.junit.Test;

public class centsTest {

	@Test
	public void test1() {
		assertEquals(4, cents.countWaysToProduceGivenAmountOfMoney(10));
	}
	
	@Test
	public void test2() {
		assertEquals(0, cents.countWaysToProduceGivenAmountOfMoney(0));
	}
	
	@Test
	public void test3() {
		assertEquals(0, cents.countWaysToProduceGivenAmountOfMoney(-1));
	}

}
