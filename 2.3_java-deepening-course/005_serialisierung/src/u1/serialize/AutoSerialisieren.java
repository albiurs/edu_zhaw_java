package u1.serialize;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.io.OutputStream;

public class AutoSerialisieren {

	public static void main(String[] args) {

		Auto a1 = new Auto("Rot", new Motor(1200));
		a1.setNummer("ZH 123");


		try {
			OutputStream fos = new FileOutputStream("src/u1/serialize/auto.ser");
			ObjectOutputStream oos = new ObjectOutputStream(fos);

			oos.writeObject(a1);
			oos.close();
			
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}
}
