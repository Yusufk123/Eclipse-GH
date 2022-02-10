import java.io.*;
import java.util.*;

public class Main {

	public static void main(String[] args) {
		String line;  
        ArrayList<String> words = new ArrayList<String>();
        //ArrayList<Integer> timesUsed = new ArrayList<Integer>();
        
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
		Map<String, Integer> wordCount= new HashMap<String, Integer>();
		
		for (int i = 0; i < words.size(); i++) {
			int n = 1;
			if(wordCount.get(words.get(i)) != null){
				n = wordCount.get(words.get(i))+1;
			}
			wordCount.remove(words.get(i));
			wordCount.put(words.get(i), n);
		}
		//Sort
		Map<String, Integer> wCSorted = sortByValue(wordCount);
		
		//Output
		for (Map.Entry<String, Integer> op : wCSorted.entrySet()) {
            System.out.println(op.getKey() + ": " + op.getValue());
        }
	}
	//Sort
	private static Map<String, Integer> sortByValue(Map<String, Integer> wordCount) {
		
        List<Map.Entry<String, Integer> > list = new LinkedList<Map.Entry<String, Integer> >(wordCount.entrySet());
        
        Collections.sort(list, new Comparator<Map.Entry<String, Integer> >() {
            public int compare(Map.Entry<String, Integer> i1, Map.Entry<String, Integer> i2){
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
