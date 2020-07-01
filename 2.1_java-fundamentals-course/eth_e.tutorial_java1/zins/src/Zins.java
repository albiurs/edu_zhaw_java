import java.util.Scanner;

public class Zins {
	public static void main(String[] args) {
		/*
		 * Berechnung Zniseszins
		 */

		/*
		 * Eingabe Benutzer:
		 * - Betrag Einlage [Fr.]
		 * - Zins [%]
		 * Im x. Jahr gibt es xx Fr. Zins. Neuer Kontostand: xxx Fr.
		 */

		// Deklaration
		float  zins;
		float  betrag;
		double z1;
		double z2;
		double z3;
		double z4;
		double z5;
		double z6;
		double z7;
		double z8;
		double z9;
		double z10;
		double y1;
		double y2;
		double y3;
		double y4;
		double y5;
		double y6;
		double y7;
		double y8;
		double y9;
		double y10;

		//Initialisierung
		System.out.println("Geben Sie eien Betrag in sFr. ein:");
		Scanner eingabe = new Scanner(System.in);
		betrag = eingabe.nextFloat();
		System.out.println("Genbes sie einen Zins ein:");
		//Scanner eingabe = new Scanner(System.in);
		zins = eingabe.nextFloat();

		//Operation
		z1 = betrag*zins/100;
		y1 = betrag+z1;
		z2 = y1*zins/100;
		y2 = y1+z2;
		z3 = y2*zins/100;
		y3 = y2+z3;
		z4 = y3*zins/100;
		y4 = y3+z4;
		z5 = y4*zins/100;
		y5 = y4+z5;
		z6 = y5*zins/100;
		y6 = y5+z6;
		z7 = y6*zins/100;
		y7 = y6+z7;
		z8 = y7*zins/100;
		y8 = y7+z8;
		z9 = y8*zins/100;
		y9 = y8+z9;
		z10 = y9*zins/100;
		y10 = y9+z10;

		//Ausgabe
		System.out.println("Im 1. Jahr gibt es " +z1 +"Fr. Zins. Neuer Kontostand: " +y1 +"Fr.");
		System.out.println("Im 2. Jahr gibt es " +z2 +"Fr. Zins. Neuer Kontostand: " +y2 +"Fr.");
		System.out.println("Im 3. Jahr gibt es " +z3 +"Fr. Zins. Neuer Kontostand: " +y3 +"Fr.");
		System.out.println("Im 4. Jahr gibt es " +z4 +"Fr. Zins. Neuer Kontostand: " +y4 +"Fr.");
		System.out.println("Im 5. Jahr gibt es " +z5 +"Fr. Zins. Neuer Kontostand: " +y5 +"Fr.");
		System.out.println("Im 6. Jahr gibt es " +z6 +"Fr. Zins. Neuer Kontostand: " +y6 +"Fr.");
		System.out.println("Im 7. Jahr gibt es " +z7 +"Fr. Zins. Neuer Kontostand: " +y7 +"Fr.");
		System.out.println("Im 8. Jahr gibt es " +z8 +"Fr. Zins. Neuer Kontostand: " +y8 +"Fr.");
		System.out.println("Im 9. Jahr gibt es " +z9 +"Fr. Zins. Neuer Kontostand: " +y9 +"Fr.");
		System.out.println("Im 10. Jahr gibt es " +z10 +"Fr. Zins. Neuer Kontostand: " +y10 +"Fr.");
	}
}
