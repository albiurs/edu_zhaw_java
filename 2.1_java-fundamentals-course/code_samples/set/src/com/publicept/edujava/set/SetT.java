package com.publicept.edujava.set;

import java.util.HashSet;
import java.util.Set;
import java.util.Iterator;

/**
 * Test the Class HashSet.
 *
 * @author Urs Albisser
 * @version 0.1 (5.6.2019)
 */
public class SetT
{
    // instance variables - replace the example below with your own
    private Set<String> mySet; // declaration of Interface "Set" (not "HashSet")

    /**
     * Constructor for objects of class HashSetT
     */
    public SetT()
    {
        // initialise instance variables
        mySet = new HashSet<>(); // initialization of "HashSet"
        
        mySet.add("Homer Jay Simpson");
        mySet.add("Charles Montgomery Burns");
        mySet.add("Apu Nahasapeemapetilon");
        mySet.add("Urs Albisser");
    }
    
    /**
     * Add hash to the HashSet
     * 
     * @param   String  Name of a Person
     */
    public void addHash(String name) {
        mySet.add(name);
    }

    /**
     * get all entries of the HashSet
     */
    public void getHashes()
    {
        Iterator<String> it = mySet.iterator();
        for(String name : mySet) {
            System.out.println(it.next());
        }
    }
}
