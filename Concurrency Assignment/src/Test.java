import static org.junit.Assert.assertEquals;

import java.util.stream.IntStream;

public class Test {
	int a[] = Main.randomArray(200000000);
	int answer = IntStream.of(a).sum();

	@org.junit.Test
	public void testbaseline() {
		int sum = IntStream.of(a).sum();
		assertEquals(sum, answer);
	}

	@org.junit.Test
	public void testSingleThread() {
		int sumS = Main.sumSingle(a);
		assertEquals(sumS, answer);
	}

	@org.junit.Test
	public void testMultiThread() {
		int sumM = Main.sumMulti(a);
		assertEquals(sumM, answer);
	}

}
