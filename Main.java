import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

public class Main {

	public static void main(String[] args) throws IOException, InterruptedException {
		String ficheroEntrada;
		ficheroEntrada = args[0];
		String[] vocales = { "a", "e", "i", "o", "u" };
		String classpath = ".";

		/* Se lanzan los procesos */
		for (int i = 0; i < vocales.length; i++) {
			String fichErrores = "Errores_" + vocales[i] + ".txt";
			ProcessBuilder pb;
			pb = new ProcessBuilder("java", "-cp", classpath, "FilesManagedment", ficheroEntrada, vocales[i],
					"resultado_" + vocales[i] + ".txt");
			// Si hay algún error, almacenarlo en un fichero
			pb.redirectError(new File(fichErrores));
			pb.start();
			// Fin del for
		}
		/* Esperamos un poco */
		Thread.sleep(3000);

		String[] ficheros = { "resultado_a.txt", "resultado_e.txt", "resultado_i.txt", "resultado_o.txt",
				"resultado_u.txt" };

		File resultados = new File("Resultados.txt");
		resultados.createNewFile();

		ArrayList<String> l = new ArrayList<String>();
		PrintWriter pw = FilesProperties.getPrintWriter("Resultados.txt");

		for (String nombreFichero : ficheros) {
			BufferedReader bfr = FilesProperties.getBufferedReader(nombreFichero);
			// Leemos líneas del fichero...
			String linea = bfr.readLine();
			while (linea != null) {
				// Y las añadimos al array
				System.out.println(linea);
				String sSubCadena = linea.substring(3);
				l.add(sSubCadena);

				pw.println(linea);
				linea = bfr.readLine();
			}
		}
		// Calculamos las sumas de cantidades
		long suma = 0;
		for (String numero : l) {
			Integer n = Integer.parseInt(numero);
			suma = suma + n;
		}

		pw.println("Total de vocales: " + suma);
		pw.close();

		System.out.println("Total de vocales: " + suma);
	}
}