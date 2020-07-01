package u3.bufferwriter;


import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class DateiSchreibenOhneBuffer {

	public static void main(String[] args) {

		String path = "src/u3/bufferwriter/datei.txt";

		try (FileWriter writer = new FileWriter(new File(path))) {
			long start = System.currentTimeMillis();

			for (int i = 0; i < 10_000_000; i++) {
				writer.write("a");
			}
			writer.write(System.getProperty("line.separator") + " Ende");

			long stop = System.currentTimeMillis();
			System.out.println("Zeit ohne Buffer: " + (stop - start) + " millisekunden");
		} catch (IOException e) {
			e.printStackTrace();
		} 
	}
}