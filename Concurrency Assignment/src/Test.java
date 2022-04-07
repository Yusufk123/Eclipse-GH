import static org.junit.Assert.assertEquals;

import java.util.stream.IntStream;

public class Test {
	int a[] = Main.randomArray(20000);

	@org.junit.Test
	public void testSingleThread() {
		int sumT = Main.sumSingle(a);
		int sum = IntStream.of(a).sum();
		assertEquals(sumT, sum);
	}

	@org.junit.Test
	public void testMultiThread() {
		int sumT = Main.sumMulti(a);
		int sum = IntStream.of(a).sum();
		assertEquals(sumT, sum);
	}

}
