package proj;

import static org.junit.Assert.*;

import org.junit.Test;

public class evalsTest {

	@Test
	public void test1() throws Exception {
		int[] expected = {1, 4, 9};
		assertArrayEquals(expected, evals.evaluate(new int[] {1, 2, 3}, 2));
	}
	
	@Test
	public void test2() throws Exception {
		int[] expected = {1, 4, 9};
		assertArrayEquals(expected, evals.evaluate(new int[] {1, -2, 3}, 2));
	}

	@Test
	public void test3() throws Exception {
		int[] expected = {1, 4, 9};
		assertArrayEquals(expected, evals.evaluate(new int[] {1, 0, 3}, 2));
	}
}
