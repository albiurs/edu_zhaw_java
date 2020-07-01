package com.publicept.edujava.map;

import java.util.Map;
import java.util.Set;
import java.util.HashMap;
import java.util.HashSet;

/**
 * Testing of map classes in java.util package.
 *
 * @author Urs Albisser
 * @version 0.1 (4.6.2019)
 */
public class MapT
{
    // instance variables
    private Map<String, String> phoneBook; // declaration with Interface "Map" (!!!not HashMap!!!)

    /**
     * Constructor for objects of class MapTester
     */
    public MapT()
    {
        // initialise instance variables
        phoneBook = new HashMap<>(); // initialize with Class "HashMap"
        
        phoneBook.put("Homer Jay Simpson", "(531) 9392 4587");
        phoneBook.put("Charles Montgomery Burns", "(531) 5432 1945");
        phoneBook.put("Apu Nahasapeemapetilon", "(531) 4234 4418");
        phoneBook.put("Urs Albisser", "1234567");
    }

    /**
     * Adds a name as a hash and a number as data to the HashMap phoneBook
     *
     * @param   name    name of the according person
     * @param   number  phone number of the person
     */
    public void addNumber(String name, String number)
    {
        phoneBook.put(name, number);
    }
    
    /**
     * Search for a person's phone number and return it.
     * 
     * @param   name    the person's name
     * @return  the person's phone number
     */
    public String getNumber(String name) {
        return phoneBook.get(name);
    }
    
    /**
     * Check if a hash entry is included in the list
     * 
     * @param   name    the person's name
     * @return  person is included (true or false)
     */
    public boolean isNameIncluded(String name) {
        return phoneBook.containsKey(name);
    }
    
    /**
     * Check if a hash entry is included in the list
     * 
     * @param   name    the person's name
     * @return  person is included (true or false)
     */
    public boolean isNumberIncluded(String number) {
        return phoneBook.containsValue(number);
    }
    
    /**
     * Print a Set of all Keys within the phoneBook
     */
    public void getNames() {
        for(String name : phoneBook.keySet()) {
            System.out.println(name);
        }
    }
    
    /**
     * Print a Set of all entries within the phoneBook: name - number
     */
    public void getEntries() {
        for(Map.Entry set : phoneBook.entrySet()) {     // make use of the Interface "Map.Entry"
            System.out.println(set.getKey() + " - " + set.getValue());
        }
    }
}
