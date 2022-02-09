import java.io.*;
import java.util.*;

public class Main {

	public static void main(String[] args) {
		String line;  
        ArrayList<String> words = new ArrayList<String>();
        
        //File Reader
		try {
			FileReader txt = new FileReader("1065.txt");
			BufferedReader br = new BufferedReader(txt);
			
			while ((line = br.readLine()) != null) {				
	            //System.out.print(line);
	            String string[] = line.toLowerCase().split("([-,.\\s]+)");           
	            for(String s : string){    
	                words.add(s);    
	            }
			}
			txt.close();
			br.close();
		} catch (IOException e) {
		      System.out.println("File Not Found.");
		      e.printStackTrace();
		    }
		
		//Analyzer
		
	}
}
