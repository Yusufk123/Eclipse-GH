
import static org.junit.Assert.assertEquals;

import java.util.Map;

/** Test case 2 for Word Occurrences Application. */
public class Test2<MessageUtil> {

	/** Test case 2 for Word Occurrences Application. */
	@org.junit.Test
	public void test() {
		Map<String, Integer> output = Main.sortByValue(Main.wordCount);
		assertEquals(Main.wordCount, output);
	}

}
