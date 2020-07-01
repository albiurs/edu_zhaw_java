package com.publicept.edujava.getraenkeautomat;


/**
 * Write a description of class Automat here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class Automat
{
    // instance variables - replace the example below with your own
    private Fach fach1;

    /**
     * Constructor for objects of class Automat
     */
    public Automat()
    {
        // initialise instance variables
        fach1 = new Fach(5);
    }

    public Getraenk kaufeGetraenkFach1() {
        return fach1.getGetraenk();
    }

    /**
     * Fuellt das Fach 1 mit Getraenken.
     * @param nameGetraenk der Name des Getraenks
     */
    public void fuelleFach1(String nameGetraenk) {
        while(!fach1.istFachVoll()) {
            fach1.addGetraenk(new Getraenk(nameGetraenk));  
        }
    }
}
