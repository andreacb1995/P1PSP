import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

public class FilesProperties {

	
	 public static BufferedReader getBufferedReader(String fileName) {
		BufferedReader br = null;
		FileReader lector;
	    try {
			lector = new FileReader(fileName);
			br = new BufferedReader(lector);
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	    return br;
		
		
	}
	public static PrintWriter getPrintWriter(String fileName){
		PrintWriter writer= null;
		try {	
			writer= new PrintWriter(fileName);
			
		}
		
		catch (IOException e) {
			System.out.println("IOException detected.");
			e.printStackTrace();
		}
		return writer;
		
	}
	
	
	
	

	
}