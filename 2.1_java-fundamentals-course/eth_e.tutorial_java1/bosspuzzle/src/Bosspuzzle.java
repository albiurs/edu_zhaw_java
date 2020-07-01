import java.util.Scanner;

public class Bosspuzzle {
	public static void main(String[] args) {
		char [][] felder = new char [3][3];
		Scanner eingabe = new Scanner(System.in);

		felder [0][0] = '3';
		felder [0][1] = '4';
		felder [0][2] = ' ';
		felder [1][0] = '7';
		felder [1][1] = '8';
		felder [1][2] = '5';
		felder [2][0] = '2';
		felder [2][1] = '1';
		felder [2][2] = '6';

		int zug_zeile = 0;
		int zug_spalte = 0;
		int leer_zeile = 0;
		int leer_spalte = 2;


		while (zug_zeile != 8) {

			System.out.println("  S 1 2 3");
			System.out.println("Z   -----");
			for (int i=0; i<3; i++) {
				System.out.print(i+1 +" | ");
				for (int j=0; j<3; j++) {
					System.out.print(felder[i][j] +" ");
				}
				System.out.println();
			}

			System.out.println("Welches Feld willst du verschieben? ");
			System.out.print("Zeile (9=Abbruch): ");
			zug_zeile = eingabe.nextInt();
			zug_zeile = zug_zeile-1;

			if (zug_zeile != 8) {
				System.out.print("Spalte: ");
				zug_spalte = eingabe.nextInt();
				zug_spalte = zug_spalte-1;

				felder[leer_zeile][leer_spalte] = felder[zug_zeile][zug_spalte];
				felder[zug_zeile][zug_spalte] = ' ';
			}

			leer_zeile = zug_zeile;
			leer_spalte = zug_spalte;

		}
	}
}
