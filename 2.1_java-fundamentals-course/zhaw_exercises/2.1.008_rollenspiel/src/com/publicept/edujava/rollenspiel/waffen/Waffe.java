package com.publicept.edujava.rollenspiel.waffen;

/**
 * Write a description of class Waffe here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class Waffe
{
    // instance variables - replace the example below with your own
    private int angriffswert;

    /**
     * Constructor for objects of class Waffe
     */
    public Waffe()
    {
        // initialise instance variables

    }

    public void setAngriffswert(int angriffswert) {
        this.angriffswert = angriffswert;
    }

    public int getAngriffswert() {
        //public int getKampfwert() {
        return angriffswert;
    }
    
    /**
     * Gibt den Kampfwert zuruek.
     * @return den Kampfwert.
     */
    public int getKampfwert() {
        return getAngriffswert();
    }
}
