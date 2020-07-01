import java.util.Scanner;

public class Spiel {
	public static void main(String[] args) {
		int anzahl;
		int summe = 0;
		Scanner eingabe = new Scanner(System.in);

		System.out.println("Wieviele Karten wollen Sie?");
		anzahl = eingabe.nextInt();

		int [] karten = new int [anzahl];

		for (int i=0; i<karten.length; i++) {
			System.out.println("Eingabe " +(i+1) +"-ter Wert:");
			karten[i] = eingabe.nextInt();
		}

		System.out.println("Sie haben diese Werte eingegeben: ");
		for (int i=0; i<karten.length; i++) {
			System.out.println(karten[i]);
		}

		for (int i=0; i<karten.length; i++) {
			summe = summe+karten[i];
		}
		System.out.println("Summe: " +summe);
	}
}
