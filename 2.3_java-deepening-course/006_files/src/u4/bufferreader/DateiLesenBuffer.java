package u4.bufferreader;


import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class DateiLesenBuffer {

	public static void main(String[] args) {

		String path = "src/u4/bufferreader/personen.txt";
		File file = new File(path);
		
		try (BufferedReader reader = new BufferedReader(new FileReader(file))) {
			String zeile = reader.readLine();
			while (zeile != null) {
				System.out.println(zeile);
				zeile = reader.readLine();
			}
		} catch (FileNotFoundException e) {
			System.out.println(path + " nicht gefunden");
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
