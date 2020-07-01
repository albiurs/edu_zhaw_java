package com.publicept.edujava.rollenspiel.gegenstaende;


/**
 * Write a description of class Gegenstand here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class Gegenstand
{
    // instance variables - replace the example below with your own
    private String name;
    private int gewicht;

    /**
     * Constructor for objects of class Gegenstand
     */
    public Gegenstand(String name, int gewicht)
    {
        // initialise instance variables
        this.name = name;
        this.gewicht = gewicht;
    }
    
    public String getName() {
        return name;
    }
    
    public int getGewicht() {
        return gewicht;
    }
}
