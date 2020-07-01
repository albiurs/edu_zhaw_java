import java.util.Scanner;

public class Bremsweg {
	public static void main(String[] args) {
		/*
		 * Berechnung Bremsweg
		 */

		/*
		 * Anhalteweg = Reaktionsweg + Bremsweg
		 * Reaktionsweg = 3 · (Geschwindigkeit/10)
		 * Bremsweg = (Geschwindigkeit/10) * (Geschwindigkeit/10)
		 */

		//Deklaration
		float v;
		Scanner vein = new Scanner(System.in);
		double reaktweg;
		double bremsweg;
		double anhaltweg;

		//Initialisierung
		System.out.println("Geben Sie eine Geschwindigkeit in km/h ein: ");
		v = vein.nextFloat();

		//Operation
		reaktweg = 3*(v/10);
		reaktweg = Math.round(reaktweg*100)/100.0;
		bremsweg = (v/10)*(v/10);
		bremsweg = Math.round(bremsweg*100)/100.0;
		anhaltweg = reaktweg+bremsweg;
		anhaltweg = Math.round(anhaltweg*100)/100.0;

		//Ausgabe
		System.out.println("Die gewählte Geschwindigkeit ist: " +v +"km/h");
		System.out.println("Der Reaktionsweg ist: " +reaktweg +"m");
		System.out.println("Der Bremsweg ist: " +bremsweg +"m");
		System.out.println("Der Anhalteweg ist: " +anhaltweg +"m");
	}
}
