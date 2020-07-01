package com.publicept.edu.java.wuerfel;

import java.util.Random;

/**
 * Simulation of a cube.
 *
 * @author (your name)
 * @version (a version number or a date)
 */



public class Wuerfel {

	// instance variables - replace the example below with your own
    private int number;

    /**
     * Constructor for objects of class cube
     */
    public Wuerfel()
    {
        // Initialize instance variables
        number = 0;
    }

    /**
     * An example of a method - replace this comment with your own
     *
     * @param  y  a sample parameter for a method
     * @return    the sum of x and y
     */
    public void wuerfeln()
    {
        // put your code here
        Random random = new Random();
        number = random.nextInt(6)+1; //parameter is excluded
        System.out.println(number);
    }

}
