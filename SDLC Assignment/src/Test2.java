
import static org.junit.Assert.assertEquals;

import java.util.Map;

public class Test2<MessageUtil> {

	@org.junit.Test
	public void test() {
		Map<String, Integer> output = Main.sortByValue(Main.wordCount);
		assertEquals(Main.wordCount, output);
	}

}
