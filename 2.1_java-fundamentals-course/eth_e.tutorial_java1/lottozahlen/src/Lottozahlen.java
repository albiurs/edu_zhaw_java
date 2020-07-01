public class Lottozahlen {

	public static void main(String[] args) {
		// Array f¸r 6 Lottozahlen
		int[] lottozahlen = new int[6];

		// Ziehung der Lottozahlen
		for (int i = 0; i < lottozahlen.length; i++) {
			lottozahlen[i] = (int) (Math.random() * 49) + 1;

			// doppelte Ziehung verhindern
			for (int j = 0; j < i; j++) {
				if (lottozahlen[j] == lottozahlen[i]) {
					i--;
				}
			}
		}

		// Ausgabe der Zahlen am Bildschirm
		for (int i = 0; i < lottozahlen.length; i++) {
			System.out.println(lottozahlen[i]);
		}

	}

}
