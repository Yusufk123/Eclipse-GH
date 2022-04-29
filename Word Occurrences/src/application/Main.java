package application;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URL;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ListView;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;

/** Main class for Word Occurrences Application. */
public class Main extends Application implements EventHandler<ActionEvent> {

	Stage window;
	Button startB, exitB;
	ListView<String> listView = new ListView<String>();

	@Override
	public void start(Stage primaryStage) {
		try {
			window = primaryStage;
			window.setTitle("Word Occurrences");

			window.setOnCloseRequest(e -> closeProgram());

			startB = new Button("Run Word Occurrences Program");
			startB.setOnAction(this);

			exitB = new Button("Exit Word Occurrences Program");
			exitB.setOnAction(this);

			StackPane layout = new StackPane();

			layout.getChildren().add(startB);

			Scene start = new Scene(layout, 1280, 720);
			window.setScene(start);
			window.show();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Main for Word Occurrences Application.
	 * 
	 * @param args main
	 */
	public static void main(String[] args) {
		launch(args);
	}

	@Override
	public void handle(ActionEvent arg0) {
		if (arg0.getSource() == startB) {
			SDLC();
		} else if (arg0.getSource() == exitB) {
			closeProgram();
		}
	}

	private void closeProgram() {
		System.out.println("Program Closed");
		window.close();

	}

	private void SDLC() {
		String line;
		/** ArrayList of words for Word Occurrences Application. */
		ArrayList<String> words = new ArrayList<String>();
		{

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

			/** Map of integers for Word Occurrences Application. */
			Map<String, Integer> wordCount = new HashMap<String, Integer>();

			for (int i = 0; i < words.size(); i++) {
				int n = 1;
				if (wordCount.get(words.get(i)) != null) {
					n = wordCount.get(words.get(i)) + 1;
				}
				wordCount.remove(words.get(i));
				wordCount.put(words.get(i), n);
			}
			/**
			 * Sorts the words buy number of times found.
			 * 
			 * @param wordCount The Number of times a word was found
			 * @return temp - Returns Sorted list
			 */
			Map<String, Integer> wCSorted = sortByValue(wordCount);

			// Output
			for (Map.Entry<String, Integer> op : wCSorted.entrySet()) {
				listView.getItems().add(op.getKey() + ": " + op.getValue());
			}

			StackPane layout2 = new StackPane(listView);
			layout2.getChildren().add(exitB);
			Scene list = new Scene(layout2, 1280, 720);
			window.setScene(list);
			window.show();
		}
	}

	// Sort
	Map<String, Integer> sortByValue(Map<String, Integer> wordCount) {

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
