package com.publicept.edujava.automotorhupe;


/**
 * Class of an almost fully working car including the objects: 
 *  - horn
 *  - motor
 *  - What about a fuel tank and (steering)wheels?
 *
 * @author (Urs Albisser)
 * @version (21.5.2019)
 */
public class Car
{
    // instance variables - replace the example below with your own
    private Motor motor;
    private Horn horn;

    /**
     * Constructor for objects of class Car
     */
    public Car()
    {
        // initialise instance variables
        horn = new Horn();
        motor = new Motor();
    }

    /**
     * start the Car
     */
    public void setMotorStart()
    {
        // switch on ignition and start the motor
        motor.setMotorStart();
    }

    /**
     * stop the Car
     */
    public void setMotorStop()
    {
        // switch off ignition and stop the motor
        motor.setMotorStop();
    }
    
    /**
     * check if the car is on
     */
    public boolean isMotorOn()
    {
        // check if the motor is on
        return motor.isMotorOn();
    }
    
    /**
     * hoot
     */
    public void getHoot()
    {
        // "Tüütaatoo"!
        horn.getHoot();
    }
    
    /**
     * replace horn and
     * set new hooting sound!
     */
    public void setReplaceHorn(String newHoot)
    {
        // set new hoot!
        horn = new Horn();
        horn.setHoot(newHoot);
    }
}
