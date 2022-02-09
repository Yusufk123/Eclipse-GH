import java.io.File;
import java.io.FileReader;
import java.io.IOException;

public class Main {

	public static void main(String[] args) {
		try {
			File txt = new File("1065.txt");
			FileReader fr = new FileReader(txt);
			int i;
			while (( i = fr.read()) != -1 ) {				
	            System.out.print((char)i);

			}
			fr.close();
		} catch (IOException e) {
		      System.out.println("File Not Found.");
		      e.printStackTrace();
		    } 
	}
}
