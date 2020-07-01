import java.util.Scanner;

public class pin_if_for {

	public static void main(String[] args) {
		/*
		 * Prüfung PIN
		 * korrekt = "offen!"
		 * falsch = "falscher PIN"
		 */

		// Deklaration
		int a, b, c;
		Scanner scanner = new Scanner(System.in);

		for (int i=0; i<3; i++) {
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
			}
			else {
				System.out.println("Falscher Pin");
			}
		}
	}
}
