package com.publicept.edujava.fliegerei;

import java.util.ArrayList;

/**
 * Klasse Flugzeug zur Erzeugung von Flugzeugobjekten.
 *
 * @author Urs
 * @version 0.1
 */
public class Flugzeug
{
    private int maxAnzahlPassagiere; //ohne Pilot
    private Person pilot;
    private ArrayList<Person> passagiere;

    public Flugzeug(int maxAnzahlPassagiere) {
        this.maxAnzahlPassagiere = maxAnzahlPassagiere;
        passagiere = new ArrayList<>();
    }

    /**
     * Weist dem Flugzeug den Pilot zu. 
     * @param pilot der Pilot
     */
    public void setPilot(Person person) {
        if(person != null && person.isPilot()) {
            pilot = person;
        }
        else {
            pilot = null;
            System.out.println("Pilot konnte nicht zugewiesen werden.");
        }
    }

    /**
     * Passagier zum Flugzeug hinzufügen
     * @param passagier Person, die als Passagier hinzugefügt wird
     */
    public boolean addPassagier(Person passagier) {
        if(passagier == null) {
            return false;
        }
        else if(passagiere.size() >= maxAnzahlPassagiere || passagier == pilot){
            return false;
        }
        else if(passagiere.contains(passagier)){
            return false;
        }
        else {
            passagiere.add(passagier);
            return true;
        }
    }

    /**
     * Entfernt einen Passagier aus dem Flugzeug.
     * @param passagier die Position (index)
     * des Passagiers, der entfernt werden soll.
     * @return true, wenn der Passagier entfernt werden konnte, * sonst false
     */
    public boolean removePassagier(int index) {
        if(index >= 0 && index < passagiere.size()) {
            passagiere.remove(index);
            return true;
        }
        else {
            return false;
        }
    }
    
    /**
     * Rückgabe des Piloten
     * @return pilot Objekt Pilot
     */
    public Person getPilot() {
        return pilot;
    }
    
    /**
     * Rückgabe der Passagierliste (ArrayList)
     * @return passagiere Passagierliste (ArrayList)
     */
    public ArrayList<Person> getPassagiere() {
        return passagiere;
    }
    
    /**
     * Rückgabe, ob das Flugzeut fliegen kann. Dies hängt davon ab, ob ein Pilot
     * im Flugzeug sitzt.
     * @return true/false Pilot sitzt/nicht im Flugzeug
     */
    public boolean canFly() {
        return pilot != null;
    }
    
    /**
     * Passagierliste auf der Konsole ausgeben
     */
    public void printPassagierliste() {
        for(Person passagier : passagiere) {
            System.out.println(passagier.getName());
        }
    }
    
    
}
