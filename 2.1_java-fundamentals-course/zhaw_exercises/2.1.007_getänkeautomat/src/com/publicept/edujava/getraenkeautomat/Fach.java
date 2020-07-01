package com.publicept.edujava.getraenkeautomat;

import java.util.ArrayList;

/**
 * Fach
 *
 * @author Urs
 * @version 0.1
 */
public class Fach {
    private int preis;
    private ArrayList<Getraenk> getraenke;
    private final int MAX_GETRAENKE;

    public Fach(int preis) {
        this.preis = preis;
        getraenke = new ArrayList<>();
        MAX_GETRAENKE = 10;
    }

    public int getPreis() {
        return preis;
    }

    /**
     * Prueft, ob die Variable "getraenke" leer ist.
     * @return true, wenn die Variable "getraenke" leer ist, sonst false
     */
    public boolean istFachLeer() {
        return getraenke.isEmpty();
    }

    /**
     * Prueft, ob die Variable "getraenke" voll ist.
     * @return true, wenn die Variable "getraenke" voll ist, sonst false
     */
    public boolean istFachVoll() {
            return getraenke.size() >= MAX_GETRAENKE;
    }

    /**
     * Fuegt der Variable "getraenke" ein Getraenk hinzu,
     * sofern noch Platz im Fach ist (MAX_GETRAENKE).
     * Wenn das Fach bereits voll ist, wird eine
     * entsprechende Meldung auf der Konsole ausgegeben. * @param getraenk ein Getraenk
     */
    public void addGetraenk(Getraenk getraenk) {
        if(!istFachVoll()) {
            getraenke.add(getraenk);
        }
        else {
            System.out.println("Das Fach ist bereits voll!");
        }
    }

    /**
     * Entfernt das erste Getraenk in der Liste und 
     * gibt es zurueck. Wenn kein Getraenk mehr in 
     * der Liste ist, wird null
     * zurueckgegeben und eine Meldung auf der
     * Konsole ausgegeben, dass das Fach leer ist. 
     * @return das naechste Getraenk oder null, wenn
     * das Fach leer ist.
     */
    public Getraenk getGetraenk() {
        if(istFachVoll()) {
            return getraenke.remove(0);
        }
        else {
            System.out.println("Fach ist leer.");
            return null;
        }
    }
    
    public void printFachInfo() {
        System.out.println("Preis: " +getPreis());
        for(Getraenk getraenk : getraenke) {
            System.out.println("Name: " +getraenk.getName());
        }
    }
}
