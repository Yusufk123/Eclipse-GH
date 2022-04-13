
import static org.junit.Assert.assertEquals;

import java.util.Map;

/** Test case 3 for Word Occurrences Application. */
public class Test3<MessageUtil> {

	/** Test case 3 for Word Occurrences Application. */
	@org.junit.Test
	public void test() {
		Map<String, Integer> output = Main.sortByValue(Main.wordCount);
		assertEquals(output, output);
	}

}
