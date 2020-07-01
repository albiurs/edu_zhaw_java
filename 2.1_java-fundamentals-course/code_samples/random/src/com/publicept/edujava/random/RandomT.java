package com.publicept.edujava.random;

import java.util.ArrayList;
import java.util.Random;

/**
 * Zufallstester: Test der Random Klasse an verschiedenen Beispielen.
 *
 * @author Urs Albisser
 * @version 0.1 (4.6.2019)
 */
public class RandomT
{
    // instance variables
    private int zufallszahl;
    private Random random;
    private ArrayList<String> antworten;

    /**
     * Constructor for objects of class ZufallszahlenTester
     */
    public RandomT()
    {
        // initialise instance variables
        zufallszahl = 0;
        random = new Random();
        antworten = new ArrayList<>();
    }
    
    /**
     * erzeugt eine Zahl von 2.147*10^-9 bis 2.147*10^9
     */
    public int zufallszahlAusgeben() {
        int zahl = random.nextInt();
        return zahl;
    }
    
    /**
     * erzeugt einen zufälligen Wert in gewähltem Bereich 
     * @return  Rückgabe zufälliger Wert von 0 bis bereich -1
     */
    public int zufallszahlInBereichAusgeben(int bereich) {
        int zahl = random.nextInt(bereich);
        return zahl;
    }
    
    /**
     * Erzeugung einer freien Anzahl Zufallszahlen und anschliessende Ausgabe in der Konsole.
     * @param   anzahl auszugebende Zahlen
     */
    public void zufallszahlenAusgeben(int anzahl) {
        int i = anzahl;
        while(i > 0) {
            int zahl = zufallszahlAusgeben();
            System.out.println(zahl);
            i--;
        }
    }
    
    /**
     * Ausgabe von beliebig vielen zufälligen Antworten auf der Konsole
     */
    public void printZufallsAntworten() {
        antworten.add("ja");
        antworten.add("nein");
        antworten.add("vielleicht");
        antworten.add("keine Ahnung");
        
        int zufallszahl;
        zufallszahl = zufallszahlInBereichAusgeben(antworten.size());
        
        System.out.println(antworten.get(zufallszahl));
    }
}
