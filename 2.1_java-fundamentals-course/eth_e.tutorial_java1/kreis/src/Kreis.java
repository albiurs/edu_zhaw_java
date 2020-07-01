import java.util.Scanner;
public class Kreis {
	public static void main(String[] args) {
		// Berechnung Kreis
		final double pi; // final = Konstante
		double u;
		double a;
		float r;
		pi = 3.14159265359;
		System.out.println("Geben Sie den Radius ein!");
		Scanner eingabe = new Scanner(System.in);
		r = eingabe.nextFloat();
		u = 2*r*pi;
		u = Math.round(u*100)/100.0;
		a = r*r*pi;
		a = Math.round(a*100)/100.0;
		System.out.println("Radius: " +r);
		System.out.println("Der Umfang ist: " +u);
		System.out.println("Die Fläche ist: " +a);
	}
}
