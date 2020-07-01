import java.util.Scanner;

public class Bowling {
	public static void main(String[] args) {

		Scanner eingabe = new Scanner(System.in);

		int anz_spieler;
		int anz_runden;
		int score;
		int sieger_score = 0;

		System.out.print("Anzahl Spieler: "); // Eingabe Spieler
		anz_spieler = eingabe.nextInt();
		
		System.out.print("Anzahl Runden: "); // Eingabe Runden
		anz_runden = eingabe.nextInt();

		int[][] resultate = new int [anz_spieler][anz_runden];
		int[] summe = new int [anz_spieler];

		System.out.println("Anzahl eingegebene Spieler: " +anz_spieler);
		System.out.println("Anzahl eingegebene Runden: " +anz_runden);

		// Eingabe Scores
		for (int i=0; i<anz_runden; i++) { //runde = i
			System.out.println("Runde: " +(i+1));
			for (int j=0; j<anz_spieler; j++) { //Spieler = j
				System.out.print("Score Spieler " +(j+1) +": ");
				score = eingabe.nextInt();
				resultate[j][i] = score;
				if (score>=0 && score<=10) { //gültige Eingabe
					summe[j] = summe[j]+score;
				}
				else { 
					System.out.println("Eingabe ungültig!"); //ungülgite Eingabe
					score = 0;
					resultate[j][i] = 0;
					j=j-1;
				}
			}
		}

		System.out.println("________________");
		System.out.println("         Spieler");
		System.out.println("         _______");
		System.out.print("         ");
		for (int j=0; j<anz_spieler; j++) {
				System.out.print((j+1) +" "); // Asugabe Spielernummern
			}
		System.out.println();
		System.out.println("________________");
		
		for (int i=0; i<anz_runden; i++) { // Zusammenfassung Runden
			System.out.print((i+1) +". Runde ");
			for (int j=0; j<anz_spieler; j++) {
				System.out.print(resultate[j][i] +" ");
			}
			System.out.println();
		}

		System.out.println("________________");
		System.out.print("Summe    ");
		for (int j=0; j<anz_spieler; j++) { // Berechnung Summe
			System.out.print(summe[j] +" ");
		}
		System.out.println();
		System.out.println("________________");

		for (int j=0; j<anz_spieler; j++) { // Sieger-Score
			if (summe[j] >= sieger_score) {
				sieger_score = summe[j];
			}	
		}
		for (int j=0; j<anz_spieler; j++) { // Sieger
			if (summe[j] == sieger_score) {
				System.out.println("Sieger ist Spieler: " +(j+1) +" mit dem Score: " +summe[j]);
			}	
		}

	}
}
