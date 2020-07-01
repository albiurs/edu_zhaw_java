package com.publicept.edujava.automotorhupe;


/**
 * motor of a car
 *
 * @author (Urs Albisser)
 * @version (21.5.2019)
 */
public class Motor
{
    // instance variables - replace the example below with your own
    private boolean motorOn;

    /**
     * Constructor for objects of class Motor
     */
    public Motor()
    {
        // initialise instance variables
        motorOn = false;
    }

    /**
     * start motor
     */
    public void setMotorStart()
    {
        motorOn = true;
    }
    
    /**
     * stop motor
     */
    public void setMotorStop()
    {
        motorOn = false;
    }
    
    /**
     * check if the motor is turned on
     */
    public boolean isMotorOn()
    {
        return motorOn;
    }

}
