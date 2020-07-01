package com.publicept.edujava.fahrzeuge;


/**
 * Klasse Motorschiff.
 * 
 * @author (Urs Albisser) 
 * @version (0.1)
 */
public class Motorschiff {
    // Deklaration Instanzvariablen 
    private Motor motor;
    private String color; // Farbe des Autos
    private int licensePlate; // Die Autonummer des Fahrzeugs

    /**
     * Konstruktor für Objekte der Klasse Motorschiff
     */
    public Motorschiff(String setColor) {
        // Instanzvariablen initialisieren
        color = setColor;
        licensePlate = 0;
    }

    /**
     * Motorschiff Umspritzen
     */
    public void repaint(String setColor) {
        color = setColor;
    }

    /**
     * Farbe des Autos abfragen
     */
    public String getColor() {
        return color;
    }

    /**
     * Motor einbauen
     */
    public void addMotor(int hubraum) {
        if (hubraum > 0) {
            motor = new Motor(hubraum);
        } else {
            System.out.println("Falsche Eingabe: Der Hubraum muss grösser sein wie null!");
        }
    }

    /**
     * Motor ausbauen
     */
    public void removeMotor() {
        motor = null;
    }

    /**
     * Motor einbauen
     */
    public int getHubraum() {
        return motor.getHubraum();
    }

    /**
     * Rückgabe Motor ja/nein
     * @return
     */
    public boolean isMotor() {
        if(motor != null) {
            return true;
        }
        return false;
    }

    /**
     * Zündkerze in Klasse Motor einbauen
     */
    public void mountZuendkerze() {
        if (motor != null) {
            motor.setZuendkerze(true);
        }
    }
    
    /**
     * Rückgabe Zündkerze ja/nein
     * @return
     */
    public boolean isZuendkerze() {
            return motor.zuendkerze();
    }

    /**
     * Atonummer setzen
     */
    public void setLicensePlate (int addLicenseNumber) {
        licensePlate = addLicenseNumber;
    }

    /**
     * Autonummer abfragen
     */
    public int getLicensePlate () {
        return licensePlate;
    }

    /**
     * Kontrolle, ob das Motorschiff fahrtauglich ist.
     * Ausgabe der entsprechenden Meldungen.
     */
    public boolean kannFahren() {
        if ((motor != null && motor.zuendkerze == true)  && licensePlate > 0) {
            System.out.println("Die Farbe des Autos ist: " +color);
            System.out.println("Autonummer: " +licensePlate);
            System.out.println("Hubraum: " +motor.getHubraum());
            return true;
        } else {
            System.out.println("Das Motorschiff kann nicht fahren. Gründe: ");
            if (motor == null) {
                System.out.println("Das Motorschiff fährt natürlich nur mit motor ;-P !");
            }
            if (motor != null && motor.zuendkerze == false) {
                System.out.println("Der Motor hat keine Zündkerze! P.S. Die Zündkerze ist nicht diejenige aus Wachs mit Docht!");
            }
            if (getLicensePlate() <= 0) {
                System.out.println("Gehen Sie zum Strassenverkehrsamt und schnappen Sie sich da ne gültige Nummer!");
            }
            return false;
        }
    }
}
