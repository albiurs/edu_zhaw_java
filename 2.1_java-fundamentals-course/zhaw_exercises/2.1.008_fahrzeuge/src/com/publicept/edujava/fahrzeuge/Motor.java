package com.publicept.edujava.fahrzeuge;


/**
 * Klasse Motor.
 * 
 * @author (Urs Albisser) 
 * @version (0.1)
 */
public class Motor {
	
	/**
	 * Deklaration Instanzvariablen
	 */
	private int hubraum; // Grösse des Hubraums
	public boolean zuendkerze; // Zündkerze vorhanden? true/false


	/**
	 * Konstruktor für Objekte der Klasse Motor
	 */
	public Motor(int setHubraum) {
		// Instanzvariablen initialisieren
		hubraum = setHubraum;
		zuendkerze = false;
	}


	/**
	 * Setzen einer Zündkerze
	 */
	public void setZuendkerze(boolean zuendkerzeSet) {
		zuendkerze = zuendkerzeSet;
	}

	
	/**
	 * Abfragen der Hubraumgrösse
	 */
	public int getHubraum() {
		return hubraum;
	}


	/**
	 * Abfragen ob Zündkerze vorhanden
	 */
	public boolean zuendkerze() {
		return zuendkerze;
	}

}
