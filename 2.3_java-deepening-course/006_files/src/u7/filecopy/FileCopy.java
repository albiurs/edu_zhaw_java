package u7.filecopy;

import java.io.InputStream;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;


public class FileCopy {


	public void copy(String src, String dest) throws FileNotFoundException, IOException {
		try (InputStream in = new FileInputStream(src);
			 OutputStream out = new FileOutputStream(dest)) {
			byte[] buf = new byte[8192];
			int n;
			while ((n = in.read(buf)) >= 0)
				out.write(buf, 0, n);
		}
	} 

	public static void main (String[] args) {

		final String src = "src/u7/filecopy/personen.txt";
		final String dest = "src/u7/filecopy/personen kopie.txt";
		
		try {
			new FileCopy().copy(src, dest);
			System.out.println("Datei \"" + src + "\" wurde kopiert");
			System.out.println("Bitte Package aktualisieren um Datei in Eclipse anzuzeigen");

		} catch (FileNotFoundException e) {
			System.out.println("Datei \"" + src + "\" nicht gefunden!");
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}
