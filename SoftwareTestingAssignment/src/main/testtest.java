import static org.junit.Assert.assertEquals;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class testtest {
	
	static Scanner inputStream;
static  ArrayList<String[]>  testarrr =new ArrayList<String[]>();
	
	
  public static void main(String[] args) {
	 // ArrayList<String[]>  tempsRead = setupData();
	 // System.out.println(tempsRead.size());
	  System.out.println(testarrr.toString());

		for(int i=0;i<testarrr.size();i++) {
			String[] inputStr = testarrr.get(i);

			double weightVal=Double.valueOf(inputStr[0]);
			double distanceVal=Double.valueOf(inputStr[1]);
			double expected=Double.valueOf(inputStr[2]);
			Document D = new Document("", weightVal);
			System.out.println(inputStr[0]+ "       "+inputStr[1]+ "       "+inputStr[2]);

		}
  }
  
  
  
  public static void  setupData() {
	  ArrayList<String[]>  linesRead = new ArrayList<String[]>();
		String fileName = "Data/DocTestData.txt";
		try {
			inputStream = new Scanner(new File(fileName));
		} catch (FileNotFoundException e) {
			System.out.println("Error opening the file " + fileName);
			System.exit(0);
		}
		while (inputStream.hasNextLine()) {
			String singleLine = inputStream.nextLine();
			String[] tokens = singleLine.split(",");
			linesRead.add(tokens);
		}


		testarrr = linesRead;
	}
  
  
}
