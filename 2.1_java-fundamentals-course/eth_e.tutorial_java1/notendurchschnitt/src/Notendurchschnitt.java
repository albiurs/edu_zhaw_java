import java.util.Scanner;

public class Notendurchschnitt {
	public static void main(String[] args) {
		/* 
		 * Bitte geben Sie ihre Noten ein (0 für Eingabe beenden):
		 * 1. Note: 3
		 * 2. Note: 4.5
		 * 3. Note: 5
		 * 4. Note: 6
		 * 5. Note: 0
		 * Sie haben 4 Noten eingegeben. Schnitt = 4.625
		 */

		float note;
		float summe=0;
		int zaehler=0;
		float durchschnitt;
		Scanner eingabe = new Scanner(System.in);


		do {
			System.out.print("Geben Sie beliebig viele Noten ein und bestätigen Sie mit <Enter> (0 = Abschluss) :");
			note = eingabe.nextFloat();
			if (note!=0) {
				summe = summe+note;
				zaehler++;
				durchschnitt = summe/zaehler;
				System.out.println("Sie haben diese Note eingegeben: " +note);
				System.out.println("Summe: " +summe);
				System.out.println("Anzahl eingegebene Werte: " +zaehler);
				System.out.println("Aktueller Durchschnitt: " +durchschnitt);
			} else {
				System.out.println("Berechnung beendet!");
			}
		} while (note!=0);
	}
}

