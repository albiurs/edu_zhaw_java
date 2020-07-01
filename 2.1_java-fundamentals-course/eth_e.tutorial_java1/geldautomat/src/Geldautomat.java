import java.util.Scanner;

public class Geldautomat {
	public static void main(String[] args) {
		/*
		 * Ausgabe Geldautomat
		 */
		
		/*
		 * WILLKOMMEN BEI DER BANK IHRES VERTRAUENS
		 * ****************************************
		 * Wie viel möchten Sie abheben? 571
		 * Eingegebener Geldbetrag: 571 Fr.
		 * 100er 5
		 * 50er 1
		 * 20er 1
		 * 10er 0
		 * Rest: 1
		 */

		// Deklaration
		int betrag;
		final int maxbetrag;
		int ausbetrag;
		int hunderter;
		int fünfziger;
		int zwanziger;
		int zehner;
		int rest;

		Scanner eingabe = new Scanner(System.in);

		// Initialisierung
		System.out.print("Welchen Betrag möchten Sie abheben? ");
		betrag = eingabe.nextInt();
		maxbetrag = 600;

		// Operation
		if (betrag > 600) {
			ausbetrag = 600;
		}
		else {
			ausbetrag = betrag;
		}
		hunderter = ausbetrag/100;
		rest = ausbetrag%100;
		fünfziger = rest/50;
		rest = rest%50;
		zwanziger = rest/20;
		rest = rest%20;
		zehner = rest/10;
		rest = rest%10;
		if (rest>0) {
			ausbetrag = betrag-rest;
		}


		// Ausgabe
		System.out.println();
		System.out.println("Eigegebener Betrag: Fr. " +betrag);
		System.out.println();
		if (rest>0) {
			System.out.println("Es können nur Noten ausgegeben werden.");
		}
		if (betrag > 600) {
			System.out.print("Limite pro Bezug: Fr. 600. ");
		}
		System.out.println("Sie erhalten: Fr. " +ausbetrag);
		System.out.println("100er: " +hunderter);
		System.out.println("50er: " +fünfziger);
		System.out.println("20er: " +zwanziger);
		System.out.println("10er: " +zehner);
		System.out.println("Rest: " +rest);
	}
}
