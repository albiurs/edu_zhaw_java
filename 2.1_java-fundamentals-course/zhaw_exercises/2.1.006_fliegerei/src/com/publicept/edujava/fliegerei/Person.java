package com.publicept.edujava.fliegerei;


/**
 * Klasse Person, zur Definitoin einer Person.
 *
 * @author Urs
 * @version 0.1
 */
public class Person
{
    // instance variables - replace the example below with your own
    private String name;
    private boolean istPilot;

    /**
     * Constructor for objects of class Person
     * @param name Name der Person
     */
    public Person(String name)
    {
        // initialise instance variables
        this.name = name;
        istPilot = false;
    }
    
    /**
     * Constructor for objects of class Person
     * @param name Name der Person
     * @param istPilot = ist Pilot oder nicht (boolean)
     */
    public Person(String name, boolean istPilot) {
        this.name = name;
        this.istPilot = istPilot;
    }

    /**
     * Gib den Namen der Person zurück
     * @return    Name der Person
     */
    public String getName()
    {
        // put your code here
        return name;
    }
    
    /**
     * Prüfung, ob die Person Pilot ist.
     * @return Die Person ist Pilot oder nicht (boolean).
     */
    public boolean isPilot() {
        return istPilot;
    }
}
