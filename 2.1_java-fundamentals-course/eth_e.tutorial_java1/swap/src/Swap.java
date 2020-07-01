import java.util.Scanner;
public class Swap {
	public static void main(String[] args) {
		// Strings austauschen (swap)
		String a;
		String b;
		String s;
		Scanner eina = new Scanner(System.in);
		Scanner einb = new Scanner(System.in);
		System.out.println("Geben Sie einen Namen ein!");
		a = eina.next();
		System.out.println("Geben Sie einen zweiten Namen ein!");
		b = einb.next();
		System.out.println("Die Namen sind: " +a +" und " +b);
		s = a;
		a = b;
		b = s;
		System.out.println("Getauschte Namen: " +a +" und " +b);
	}
}
