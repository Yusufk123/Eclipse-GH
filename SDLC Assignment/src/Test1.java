
import static org.junit.Assert.assertEquals;

import java.util.ArrayList;

public class Test1<MessageUtil> {

	@org.junit.Test
	public void test() {
		ArrayList<String> output = Main.words;
		assertEquals(Main.words, output);
	}

}
