import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

public class FilesManagedment {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		counter(args[0], args[1], args[1], args[2]);
	}

	public static boolean counter(String fileName, String vowel, String vowelCapital, String fileResultName) {
		File file = new File(fileResultName);
		int counter = 0;
		try {
			file.createNewFile();
			BufferedReader br = FilesProperties.getBufferedReader(fileName);
			ArrayList<String> lineas = new ArrayList<String>();

			char caracter = vowel.charAt(0);
			String[] vowels = { "a", "e", "i", "o", "u" };

			String linea = br.readLine();
			while (linea != null) {
				// Y las añadimos al array
				lineas.add(linea);
				linea = br.readLine();
			}

			for (String tolinea : lineas) {
				char vocal = vowel.charAt(0);
				for (int i = 0; i < tolinea.length(); i++) {
					if (tolinea.charAt(i) == vocal) {
						counter++;
					}
				}
			}
			System.out.println(vowel + ": " + counter);
			PrintWriter pw = FilesProperties.getPrintWriter(fileResultName);
			pw.write(vowel + ": " + counter);
			pw.close();

		} catch (IOException e) {
			System.out.println("IOException detected.");
			e.printStackTrace();
			return false;
		}
		return true;
	}
}
