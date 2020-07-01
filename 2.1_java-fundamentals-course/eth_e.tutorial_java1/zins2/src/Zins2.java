import java.util.Scanner;

public class Zins2 {
	public static void main(String[] args) {
		/*
		 * Berechnung Zniseszins
		 */

		/*
		 * Eingabe Benutzer:
		 * - Betrag Einlage [Fr.]
		 * - Zins [%]
		 * - Anz. Jahre
		 * Im x. Jahr gibt es xx Fr. Zins. Neuer Kontostand: xxx Fr.
		 */

		// Deklaration
		float zins;
		float betrag;
		int jahre;
		int y; // Laufvariable Yahr
		double z; // Laufvariable Zins
		double b; // Laufvariable Betrag
		Scanner eingabe = new Scanner(System.in);

		//Initialisierung
		System.out.println("Geben Sie eien Betrag in sFr. ein: ");
		betrag = eingabe.nextFloat();
		System.out.println("Genben Sie einen Zins ein: ");
		zins = eingabe.nextFloat();
		System.out.println("Wieviele Jahre soll das Geld angelegt werden?: ");
		jahre = eingabe.nextInt();

		//Operation
		b = betrag;
		for (y=0; y<jahre && jahre!=0; y++) {
			z = b*zins/100;
			b = b+z;
		}

		//Ausgabe
		System.out.println("Im Jahr " +y +" ist Ihr Kontostand " +b +"Fr.");
	}
}
