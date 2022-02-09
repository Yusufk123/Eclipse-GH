import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		try {
			File txt = new File("1065-h.htm");
			Scanner fileReader = new Scanner(txt);
			while (fileReader.hasNextLine()) {
				String data = fileReader.nextLine();
				System.out.println(data);
			}
			fileReader.close();
		} catch (FileNotFoundException e) {
		      System.out.println("File Not Found.");
		      e.printStackTrace();
		    }
	}
}
