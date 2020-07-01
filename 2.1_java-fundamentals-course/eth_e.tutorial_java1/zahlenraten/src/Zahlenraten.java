import java.util.Scanner;

public class Zahlenraten {
	public static void main(String[] args) {
		/*
		 * Gesucht ist eine Zahl zwischen 1 und 100.
		 * raten Sie!
		 * 4
		 * zu klein
		 * raten Sie
		 * 94
		 * zu gross
		 * raten Sie
		 * 52
		 * Erraten! 3 mal geraten.
		 */

		short zahl, rate;
		boolean zustand = false;
		Scanner eingabe = new Scanner(System.in);

		System.out.print("Gib eine Zahl zwischen 0 und 100 ein, die erraten werden soll: ");
		zahl = eingabe.nextShort();

		if (zahl<=100 && zahl>=0) {
			do {
				System.out.print("Errate die Zahl zwischen 0 und 100! ");
				rate = eingabe.nextShort();
				if (rate>=100 || rate<=0) {
					System.out.println("Zahl ausserhalb des Suchbereichs!");
				} else if (rate<zahl) {
					System.out.println("zu klein!");
				} else if (rate>zahl) {
					System.out.println("zu gross!");
				} else if (rate==zahl) {
					System.out.println("korrekt!");
					zustand = true;
				}
			} while (zustand==false);

		} else {
			System.out.println("Die Zahl ist ausserhalb des gültigen Bereiches!");
		}
	}
}
