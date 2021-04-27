package capitole.filesUtils;


import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.List;

public class CSVReader {
	

	public CSVReader() {
		
	}
	
	public static List<String> readCSV(String csvName)
	{
		List<String> itemList = new ArrayList<>();
		 try (BufferedReader br =new BufferedReader(new FileReader(csvName));){
  	        
	         String line = br.readLine();
	         while (null!=line) {
	            itemList.add(line);   
	            line = br.readLine();
	         }
	         
	      } catch (Exception e) {
	        e.printStackTrace();
	      } 
		 return itemList;
	}

}
