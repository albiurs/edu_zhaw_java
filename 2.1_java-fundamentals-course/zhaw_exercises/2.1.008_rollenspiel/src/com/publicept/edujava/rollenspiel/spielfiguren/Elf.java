package com.publicept.edujava.rollenspiel.spielfiguren;

/**
 * Write a description of class Elf here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class Elf extends Spielfigur
{
    // instance variables - replace the example below with your own
    private int zauberwert;

    /**
     * Constructor for objects of class Elf
     */
    public Elf(String name, int zauberwert)
    {
        // initialise instance variables
        super(name);
        this.zauberwert = zauberwert;
    }
    
    @Override
    public double getKampfwert() {
        return super.getKampfwert() + (zauberwert / 2);
    }
}
