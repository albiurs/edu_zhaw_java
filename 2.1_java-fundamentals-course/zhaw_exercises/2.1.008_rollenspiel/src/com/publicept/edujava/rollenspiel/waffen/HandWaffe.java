package com.publicept.edujava.rollenspiel.waffen;


/**
 * Write a description of class HandWaffe here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class HandWaffe extends Waffe
{
    // instance variables - replace the example below with your own
    private int verteidigungswert;

    /**
     * Constructor for objects of class HandWaffe
     */
    public HandWaffe()
    {
        // initialise instance variables
        
    }
    
    /**
     * Gibt den Kampfwert zuruek.
     * @return den Kampfwert.
     */
    public int getKampfwert() {
        return super.getKampfwert() + (verteidigungswert / 2);
    }
}
