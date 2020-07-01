package telefonbuch;

public class Main {

	public static void main(String[] args) {
		Telefonbuch telefonBuch = new Telefonbuch();
		telefonBuch.addEntry("Urs Albisser", "078 123 45 67");
		try {
			telefonBuch.addEntry("Fexlix", "Muster");
			telefonBuch.printTelBuch();
		}
		catch (NotValidEntryException e) {

		}
	}
}
