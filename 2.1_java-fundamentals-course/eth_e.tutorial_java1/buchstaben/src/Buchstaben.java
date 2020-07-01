
public class Buchstaben {
	public static void main(String[] args) {
		/*
		 * In dieser und der folgenden Lektion werden Sie ein Programm schreiben, 
		 * welches eine Reihe von Zeichen (Leerschläge und X-en) so in einem 
		 * 2-dimensionalen Array speichert, dass dessen Bildschirmausgabe wie folgt 
		 * Buchstaben (z.B. A oder Z) zeichnet:
		 *
		 *   X
		 *  X X
		 * Xxxxx
		 * x   x
		 * x   x
		 *
		 * xxxxx
		 *    x
		 *   x
		 *  x
		 * xxxxx
		 */

		char [][] aaa = new char [5][5];
		char [][] zzz = new char [5][5];

		aaa [0][0] = ' ';
		aaa [0][1] = ' ';
		aaa [0][2] = 'X';
		aaa [0][3] = ' ';
		aaa [0][4] = ' ';
		aaa [1][0] = ' ';
		aaa [1][1] = 'X';
		aaa [1][2] = ' ';
		aaa [1][3] = 'X';
		aaa [1][4] = ' ';
		aaa [2][0] = 'X';
		aaa [2][1] = 'X';
		aaa [2][2] = 'X';
		aaa [2][3] = 'X';
		aaa [2][4] = 'X';
		aaa [3][0] = 'X';
		aaa [3][1] = ' ';
		aaa [3][2] = ' ';
		aaa [3][3] = ' ';
		aaa [3][4] = 'X';
		aaa [4][0] = 'X';
		aaa [4][1] = ' ';
		aaa [4][2] = ' ';
		aaa [4][3] = ' ';
		aaa [4][4] = 'X';
		
		zzz [0][0] = 'X';
		zzz [0][1] = 'X';
		zzz [0][2] = 'X';
		zzz [0][3] = 'X';
		zzz [0][4] = 'X';
		zzz [1][0] = ' ';
		zzz [1][1] = ' ';
		zzz [1][2] = ' ';
		zzz [1][3] = 'X';
		zzz [1][4] = ' ';
		zzz [2][0] = ' ';
		zzz [2][1] = ' ';
		zzz [2][2] = 'X';
		zzz [2][3] = ' ';
		zzz [2][4] = ' ';
		zzz [3][0] = ' ';
		zzz [3][1] = 'X';
		zzz [3][2] = ' ';
		zzz [3][3] = ' ';
		zzz [3][4] = ' ';
		zzz [4][0] = 'X';
		zzz [4][1] = 'X';
		zzz [4][2] = 'X';
		zzz [4][3] = 'X';
		zzz [4][4] = 'X';

		System.out.println();

		for (int i=0; i<5; i++) {
			for (int j=0; j<5; j++) {
				System.out.print(aaa[i][j]);
			}
			System.out.println();
		}

		System.out.println();

		for (int i=0; i<5; i++) {
			for (int j=0; j<5; j++) {
				System.out.print(zzz[i][j]);
			}
			System.out.println();
		}

		System.out.println();

	}
}
