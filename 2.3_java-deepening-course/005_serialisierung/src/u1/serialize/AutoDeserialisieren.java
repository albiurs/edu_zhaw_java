package u1.serialize;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.ObjectInputStream;

public class AutoDeserialisieren {

	public static void main(String[] args) {
		Auto auto = null;

			try {
				InputStream fis = new FileInputStream("src/u1/serialize/auto.ser");
				ObjectInputStream ois = new ObjectInputStream(fis);

				auto = (Auto) ois.readObject();
				ois.close();

				System.out.println("Farbe: " + auto.getFarbe());
				System.out.println("Hubraum: " + auto.getMotor().getHubraum());
				System.out.println("Nummer: " + auto.getNummer());
			} catch (ClassNotFoundException | IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}


		if (auto != null) {
			System.out.println("Farbe: " + auto.getFarbe());
			System.out.println("Hubraum: " + auto.getMotor().getHubraum());
			System.out.println("Nummer: " + auto.getNummer());
		}

	}
}
