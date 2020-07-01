package com.publicept.edujava.fahrzeuge;



import static org.junit.Assert.*;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

/**
 * The test class MotorTest.
 *
 * @author  Urs Albisser
 * @version 0.1
 */
public class MotorTest
{
    private Motor motor1;

    /**
     * Default constructor for test class MotorTest
     */
    public MotorTest()
    {
    }

    /**
     * Sets up the test fixture.
     *
     * Called before every test case method.
     */
    @Before
    public void setUp()
    {
        motor1 = new Motor(2000);
    }

    /**
     * Tears down the test fixture.
     *
     * Called after every test case method.
     */
    @After
    public void tearDown()
    {
    }

    @Test
    public void testSetZuendkerze()
    {
        motor1.setZuendkerze(true);
        assertEquals(true, motor1.zuendkerze());
    }
    
    @Test
    public void testUnSetZuendkerze()
    {
        motor1.setZuendkerze(false);
        assertEquals(false, motor1.zuendkerze());
    }
}
