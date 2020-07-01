package com.publicept.edujava.automotorhupe;


/**
 * horn of a car
 *
 * @author (Urs Albisser)
 * @version (21.5.2019)
 */
public class Horn
{
    // instance variables
    private String hootingSound;

    /**
     * Constructor for objects of class Hupe
     */
    public Horn()
    {
        // initialise instance variables
        hootingSound = "Tüütaatoo";
    }

    /**
     * Der Hupton wird auf der Konsole ausgegeben.
     */
    public void getHoot()
    {
        // let's hoot!
        System.out.println(hootingSound);
    }
    
    /**
     * replace horn
     */
    public void setHoot(String newHoot)
    {
        // new hooting sound
        hootingSound = newHoot;
    }
}
