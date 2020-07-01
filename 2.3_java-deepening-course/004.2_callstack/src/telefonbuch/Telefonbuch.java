package telefonbuch;

import java.security.cert.CertificateNotYetValidException;
import java.util.Map;
import java.util.TreeMap;

public class Telefonbuch {

	private Map<String, String> telBuch;

	public Telefonbuch() {
		this.telBuch = new TreeMap<String, String>();
	}

	public void addEntry(String name, String number) throws CertificateNotYetValidException {

		if (name == null || number == null || name.isEmpty() || number.isEmpty()) {
			throw new CertificateNotYetValidException("Ein Parameter ist null oder leer");
		}

		this.telBuch.put(name, number);
	}

	public void printTelBuch() {

		/**
		 * for-each-loop ueber set mit key und value
		 */
		for (String key : telBuch.keySet()) {
			System.out.println(key + " " + telBuch.get(key));
		}



	}
}
