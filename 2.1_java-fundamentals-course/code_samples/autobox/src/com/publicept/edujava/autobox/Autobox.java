package com.publicept.edujava.autobox;

import java.util.ArrayList;
import java.util.List;

/**
 * Test Wrapper-Classes and Autoboxing of Java.
 * 
 * Wrapper-Class:
 * Declaration of the List-object with Wrapper-Class "Integer" (not int!!!). 
 * This is, because the List object requires an Object as parameter, 
 * instead of a primitive data type.
 * 
 * Auto-Boxing:
 * Using a primitive data type will automatically box the value to an 
 * corresponding object. 
 * E.g. the primitive "int" data type will be converted > to an "Integer"-object
 *
 * @author Urs Albisser
 * @version 0.1 (7.6.2019)
 */
public class Autobox
{
    // instance variables
    /**
     * Declare the List object with Wrapper-Class "Integer" (not int!!!).
     */
    private List<Integer> markList;

    /**
     * Constructor for objects of class Autobox
     */
    public Autobox()
    {
        // initialise instance variables
        markList = new ArrayList<>();
    }

    /**
     * Add a mark into the mark list
     *
     * @param  mark  Mark (int) to inserted into the markList
     */
    public void saveMarkIntoList(int mark) { // autobox "int" > "Integer"-object
        markList.add(mark);
    }
}
