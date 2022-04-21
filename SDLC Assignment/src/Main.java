import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URL;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

/** Main class for Word Occurrences Application. */
public class Main {
	/** ArrayList of words for Word Occurrences Application. */
	public static ArrayList<String> words = new ArrayList<String>();
	/** Map of integers for Word Occurrences Application. */
	public static Map<String, Integer> wordCount = new HashMap<String, Integer>();

	/**
	 * Main for Word Occurrences Application.
	 * 
	 * @param args main
	 */
	public static void main(String[] args) {
		String line;

		// Page Reader
		try {
			URL txt = new URL("https://www.gutenberg.org/files/1065/1065-h/1065-h.htm");
			BufferedReader br = new BufferedReader(new InputStreamReader(txt.openStream()));

			while ((line = br.readLine()) != null) {

				String string[] = line.toLowerCase().split("([-,.\\s]+)");
				// I don't think any of the replaceAlls work
				line.replaceAll("\\<.*?\\>", "");
				line.replaceAll("</div>", "");
				line.replaceAll("/>", "");
				line.replaceAll("<div", "");
				line.replaceAll("gutenberg&#8482;", "");
				line.replaceAll("style='display:block;", "");
				line.replaceAll("\"\\\\<[^>]*>\",\"\"", "");
				for (String s : string) {
					words.add(s);
				}
			}
			br.close();
		} catch (IOException e) {
			System.out.println("Page Not Found.");
			e.printStackTrace();
		}

		// Analyzer
		for (int i = 0; i < words.size(); i++) {
			int n = 1;
			if (wordCount.get(words.get(i)) != null) {
				n = wordCount.get(words.get(i)) + 1;
			}
			wordCount.remove(words.get(i));
			wordCount.put(words.get(i), n);
		}

		// Sort
		Map<String, Integer> wCSorted = sortByValue(wordCount);

		// Output
		// for (Map.Entry<String, Integer> op : wCSorted.entrySet()) {
		// System.out.println(op.getKey() + ": " + op.getValue());
		// }

		// MySQL Integration
		try {
			Class.forName("java.sql.Driver");
		} catch (ClassNotFoundException e1) {
			System.out.println("MySQL Driver Error");
			e1.printStackTrace();
		}

		String url = "jdbc:mysql://localhost:3306/"; // database specific url.
		String user = "root";
		String password = "salsal";

		try {
			Connection connection = DriverManager.getConnection(url, user, password);
			Statement statement = connection.createStatement();
			String sql = "";

			// int rowsAffected = statement.executeUpdate(sql);

			sql = "select * from `word occurrences`.word";
			ResultSet result = statement.executeQuery(sql);
			while (result.next()) {
				String word = result.getString("word");
				int freq = result.getInt("Frequency");
				System.out.println(word + ": " + freq);
			}

		} catch (SQLException e) {
			System.out.println("MySQL Connection Error");
			e.printStackTrace();
		}

	}

	/**
	 * Sorts the words buy number of times found.
	 * 
	 * @param wordCount The Number of times a word was found
	 * @return temp - Returns Sorted list
	 */
	public static Map<String, Integer> sortByValue(Map<String, Integer> wordCount) {

		List<Map.Entry<String, Integer>> list = new LinkedList<Map.Entry<String, Integer>>(wordCount.entrySet());

		Collections.sort(list, new Comparator<Map.Entry<String, Integer>>() {
			public int compare(Map.Entry<String, Integer> i1, Map.Entry<String, Integer> i2) {
				return (i2.getValue()).compareTo(i1.getValue());
			}
		});

		Map<String, Integer> temp = new LinkedHashMap<String, Integer>();

		for (Map.Entry<String, Integer> a : list) {
			temp.put(a.getKey(), a.getValue());
		}
		return temp;
	}
}
