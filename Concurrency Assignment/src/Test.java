import static org.junit.Assert.assertEquals;

import java.util.stream.IntStream;

public class Test {

	@org.junit.Test
	public void testSingleThread() {
		int a[] = { 1, 2, 3, 4, 5, 6, 7, 8, 9, 10 };
		int sum = IntStream.of(a).sum();
		assertEquals(55, sum);
	}

	@org.junit.Test
	public void testMultiThread() {
		int a[] = { 1, 2, 3, 4, 5, 6, 7, 8, 9, 10 };
		int sum = IntStream.of(a).sum();
		assertEquals(55, sum);
	}

}
