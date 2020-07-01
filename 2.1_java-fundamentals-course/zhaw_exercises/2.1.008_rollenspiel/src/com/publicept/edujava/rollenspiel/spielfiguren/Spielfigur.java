package com.publicept.edujava.rollenspiel.spielfiguren;

import com.publicept.edujava.rollenspiel.waffen.*;
import com.publicept.edujava.rollenspiel.gegenstaende.*;
import java.util.Random;
import java.util.List;
import java.util.ArrayList;

/**
 * Write a description of class Spielfiguren here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class Spielfigur
{
    // instance variables - replace the example below with your own
    private String name;
    private double lebenspunkte;
    private int tragkraft;
    private Waffe waffe;
    private List<Gegenstand> gegenstaende;

    /**
     * Constructor for objects of class Spielfiguren
     */
    public Spielfigur(String name)
    {
        // initialise instance variables
        this.name = name;
        this.waffe = new Keule();
        this.gegenstaende = new ArrayList<>();
    }

    /**
     * Gibt den Kampfwert der aktuellen Waffe zurueck.
     * Der Kampfwert der Waffe wird mit einer Random-Nr. zwischen * 0.9 und 1.1 multipliziert.
     *
     * @return der Kampfwert
     */
    public double getKampfwert() {
        double ran = new Random().nextDouble();
        double faktor = (ran /5) + 0.9;
        int waffenkampfwert = waffe.getKampfwert();
        return waffenkampfwert * faktor;
    }
    
    public double getLebenspunkte() {
        return lebenspunkte;
    }
    
    public double setLebenspunkte(double lebenspunkte) {
        this.lebenspunkte = lebenspunkte;
        return lebenspunkte;
    }

    public void waffeAufheben(Waffe waffe) {
        this.waffe = waffe;
    }

    /**
     * Nimmt ein Gegenstand auf, jedoch nur, wenn noch genuegend Tragkraft vorhanden ist. 
     * Wird ein Gegenstand aufgenommen, wird die Tragkraft entsprechend reduziert und
     * <code>true</code> zurueckgegeben. Ist der Gegenstand zu schwer fuer die
     * verbleibende Tragkraft, so wird <code>false</code> zurueckgegeben.
     *
     * @param gegenstand der Gegenstand, der aufgenommen werden soll.
     * @return <code>true</code> wenn der Gegenstand aufgenommen wurde,
     * sonst <code>false</code>.
     */
    public boolean nehmeGegenstand(Gegenstand gegenstand) {
        if(tragkraft > gegenstand.getGewicht()) {
            gegenstaende.add(gegenstand);
            tragkraft -= gegenstand.getGewicht();
            return true;
        }
        return false;
    }

    /**
     * Laesst diese Spielfigur gegen eine andere Spielfigur kaempfen.
     *
     * Gekaempft wird in Runden. Es wird solange gekaempft, bis eine oder beide
     * Spielfiguren keine Lebenspunkte mehr haben. Steht nach 20 Runden noch kein Sieger 
     * fest, wird der Kampf abgebrochen.
     *
     * Bei jeder Runde wird der Kampfwert der einen Spielfigur den Lebenspunkten
     * des Gegners abgezogen und umgekehrt.
     *
     * Diejenige Spielfigur mit den meisten verbliebenen Lebenspunkten gewinnt.
     *
     * @param gegner die andere Spielfigur
     * @return <code>true</code>, falls der Kampf gewonnen wird, sonst <code>false</code>. 
     */
    public boolean kaempfeGegen(Spielfigur gegner) {
        int runden = 20;
        
        while(getLebenspunkte() > 0 && gegner.getLebenspunkte() > 0 && runden >0) {
            setLebenspunkte(getLebenspunkte() - gegner.getKampfwert());
            gegner.setLebenspunkte(gegner.getLebenspunkte() - getKampfwert());
            runden --;
        }
        
        return getLebenspunkte() > gegner.getLebenspunkte();
    }
}
