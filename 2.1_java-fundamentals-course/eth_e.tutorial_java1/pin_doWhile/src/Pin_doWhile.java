import java.util.Scanner;

public class Pin_doWhile {

	public static void main(String[] args) {
		/*
		 * Prüfung PIN
		 * korrekt = "offen!"
		 * falsch = "falscher PIN"
		 */

		// Deklaration
		int a, b, c;
		boolean zustand=false;
		int versuche=3;
		Scanner scanner = new Scanner(System.in);

		do  {
			// Initialisierung
			System.out.println("Bitte geben sie den 3 stelligen Pin ein!");
			System.out.print("1. Ziffer: ");
			a = scanner.nextInt();
			System.out.print("2. Ziffer: ");
			b = scanner.nextInt();
			System.out.print("3. Ziffer: ");
			c = scanner.nextInt();
			System.out.println("Sie haben eingegeben: "+a+b+c);

			// Operation
			if((a==0) && (b==0) && (c==7)) {
				System.out.println("offen!");
				zustand=true;
			}
			else {
				System.out.println("Falscher Pin. Sie haben noch " +(versuche-1) +" Verusche!");
				versuche=versuche-1;
			}
		} while (zustand!=true && versuche>0);
	}
}
