package com.publicept.edujava.fahrzeuge;

import java.util.ArrayList;
import java.util.List;

/**
 * Verkehrsmittel.
 *
 * @author Urs Albisser
 * @version 0.1
 */
public class Verkehrsmittel
{
    // instance variables - replace the example below with your own
    private List<Auto> autos;
    private List<Velo> velos;
    private List<Motorschiff> motorschiffe;

    /**
     * Constructor for objects of class Verkehrsmittel
     */
    public Verkehrsmittel()
    {
        // initialise instance variables
        autos = new ArrayList<>();
        velos = new ArrayList<>();
        motorschiffe = new ArrayList<>();
    }
    
    /**
     * Constructor for objects of class Verkehrsmittel
     */
    public Verkehrsmittel(String fahrzeugTyp, String farbe)
    {
        // initialise instance variables
        autos = new ArrayList<>();
        velos = new ArrayList<>();
        motorschiffe = new ArrayList<>();
        addFahrzeug(fahrzeugTyp, farbe);
    }
    
    /**
     * Erzeuge Fahrzeug
     * @param fahrzeugTyp (String)
     * @param farbe (String)
     */
    public void addFahrzeug(String fahrzeugTyp, String farbe) {
        if(fahrzeugTyp.equals("Auto") || fahrzeugTyp.equals("auto")) {
            autos.add(new Auto(farbe));
        }
        else if(fahrzeugTyp.equals("Velo") || fahrzeugTyp.equals("velo")) {
            velos.add(new Velo(farbe));
        }
        else if(fahrzeugTyp.equals("Motorschiff") || fahrzeugTyp.equals("motorschiff")) {
            motorschiffe.add(new Motorschiff(farbe));
        }
        else {
            //do nothing
        }
    }
    
    /**
     * Entferne Fahrzeug
     * @param fahrzeugTyp String
     * @param index Index in der ArrayList
     */
    public void removeFahrzeug(String fahrzeugTyp, int index) {
        if(fahrzeugTyp.equals("Auto") || fahrzeugTyp.equals("auto")) {
            autos.remove(index);
        }
        else if(fahrzeugTyp.equals("Velo") || fahrzeugTyp.equals("velo")) {
            velos.remove(index);
        }
        else if(fahrzeugTyp.equals("Motorschiff") || fahrzeugTyp.equals("motorschiff")) {
            motorschiffe.remove(index);
        }
        else {
            //do nothing
        }
    }
    
    /**
     * Rückgabe, ob ein Auto-Objekt in der ArrayList vorhanden ist.
     */
    public boolean isAuto() {
        return autos.size() != 0;
    }
    
    /**
     * Rückgabe, ob ein Auto-Objekt in der ArrayList vorhanden ist.
     */
    public boolean isVelo() {
        return velos.size() != 0;
    }
}
