
import static org.junit.Assert.assertEquals;

import java.util.ArrayList;

/** Test case 1 for Word Occurrences Application. */
public class Test1<MessageUtil> {

	/** Test case 1 for Word Occurrences Application. */
	@org.junit.Test
	public void test() {
		ArrayList<String> output = Main.words;
		assertEquals(Main.words, output);
	}

}
