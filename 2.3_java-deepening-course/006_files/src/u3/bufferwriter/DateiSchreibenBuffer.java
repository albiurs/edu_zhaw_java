package u3.bufferwriter;


import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class DateiSchreibenBuffer {

	public static void main(String[] args) {
		
		String path = "src/u3/bufferwriter/datei.txt";

		try (BufferedWriter buffer = new BufferedWriter(new FileWriter(new File(path)))) {
			long start = System.currentTimeMillis();

			for (int i = 0; i < 10_000_000; i++) {
				buffer.write("a");
			}
			buffer.write(System.getProperty("line.separator") + " Ende");
			long stop = System.currentTimeMillis();
			System.out.println("Zeit: " + (stop - start) + " millisekunden");

		} catch (IOException e) {
			e.printStackTrace();
		} 

	}

}