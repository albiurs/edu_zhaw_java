package u1.serialize;

import java.io.Serializable;

public class Fahrzeug {//implements Serializable {

	// Variante 1
	public Fahrzeug() {}

	private static final long serialVersionUID = 6780365721263755439L;

	/**
	 * 
	 */
	private String nummer;

	public Fahrzeug(String nummer) {
		this.nummer = nummer;
	}

	public String getNummer() {
		return nummer;
	}

	public void setNummer(String nummer) {
		this.nummer = nummer;
	}

}
