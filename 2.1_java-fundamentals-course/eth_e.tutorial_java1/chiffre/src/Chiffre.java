//package modul_1;

import java.util.Scanner; // Klasse Scanner importieren

public class Chiffre {

	/*
	 * Chiffrieren von Zeichen
	 */

	/* Ziel:
	 * Geben Sie ein Zeichen ein!
	 * M
	 * Geben Sie einen Schlüssel ein!
	 * 6
	 * Sie haben M und 6 eingegeben
	 * Das verschlüsselte Zeichen ist: G
	 */

	public static void main(String[] args) {
		// Deklaration 
		String text; // Variable Speicherung Text nach Eingabe Typ String
		Scanner textein = new Scanner(System.in); // Variable Texteingabe Typ Scanner
		int chif; // Variable Schlüssel vom Typ integer
		Scanner chifein = new Scanner(System.in); // Variable Schlüsseleingabe Typ Scanner
		char buchst; // Variable Extraktion Buchstabe aus 'text' Typ character
		int buchst_ascii; // Variable Ordnungszahl 'buchst' (American Standard Code for Information Interchange (ASCII))
		int buchst_ascii_chif; // Variable Ordnungszahl 'buchst' verschlüsselt
		char buchst_chif; // Variable Buchstabe verschlüsselt

		// Initialisierung
		System.out.println("Geben Sie einen Buchstaben ein:");
		text = textein.next(); // Eingabe String ohne Umrechnung 'next()'
		System.out.println("Geben Sie einen Schlüssel ein:");
		chif = chifein.nextInt(); // Eingabe Eingabewert (String) -> Umrechnung Integer 'nextInt()'

		// Operation
		buchst = text.charAt(0); // 1. Buchstabe (0) aus String extrahieren 
		buchst_ascii = (int) buchst; // Zahlenwert von Buchstabe definieren
		buchst_ascii_chif = buchst_ascii-chif; // Zahlenwert verschlüssenln
		buchst_chif = (char) buchst_ascii_chif; // Schlüsselwert in Buchstaben konvertieren
		
		// Ausgabe
		System.out.println("Sie haben \"" +text +"\" und \"" +chif +"\" eingegeben.");
		System.out.println("Das verschlüsselte Zeichen ist: " +buchst_chif);
	}
}
