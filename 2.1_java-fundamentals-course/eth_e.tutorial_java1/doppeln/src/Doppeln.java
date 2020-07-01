import java.util.Scanner;
public class Doppeln {
	public static void main(String[] args) {
		System.out.print("Geben Sie eine Zahl ein: ");
		Scanner eingabe = new Scanner(System.in);
		double zahl; // Deklaration: Speicherplatz für Variable definieren
		zahl = eingabe.nextDouble(); // Initialisieren: Wert zuweisen
		zahl = zahl * 2; // Operation: Variabel neu berechnen und wieder speichern
		/* 
		 * mit ln Zeilenumbruch, ohne ln Ausgabe auf der gleichen Zeile
		 * verbinden mit System.out.println("Ich heisse: " +variable);
		 */ 
		System.out.println("Das Doppelte ist " +zahl); // Ausgabe print/println

	}
}
