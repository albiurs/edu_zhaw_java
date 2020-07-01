import java.util.Scanner;

public class Wohnblock {
	public static void main(String[] args) {
		int wohnungen, stockwerke;

		Scanner eingabe = new Scanner(System.in);

		System.out.println("Wieviele Wohnungen pro Stockwerk?");
		wohnungen = eingabe.nextInt();

		System.out.println("Wieviele Stockwerke?");
		stockwerke = eingabe.nextInt();

		for (int y=0; y<stockwerke; y++) {
			for (int x=0; x<wohnungen; x++) {
				System.out.print("[" +y +"," +x +"] ");
			}
			System.out.println();
		}
	}
}
