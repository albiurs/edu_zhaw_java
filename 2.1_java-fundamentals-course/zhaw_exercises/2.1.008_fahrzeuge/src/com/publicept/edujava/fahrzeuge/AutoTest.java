package com.publicept.edujava.fahrzeuge;



import static org.junit.Assert.*;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

/**
 * The test class AutoTest.
 *
 * @author  (your name)
 * @version (a version number or a date)
 */
public class AutoTest
{
    private Auto auto1;

    /**
     * Default constructor for test class AutoTest
     */
    public AutoTest()
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
        auto1 = new Auto("grün");
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
    public void testRepaint()
    {
        auto1.repaint("rot");
        assertEquals("rot", auto1.getColor());
    }

    @Test
    public void testAddMotor()
    {
        auto1.addMotor(1000);
        assertEquals(true, auto1.isMotor());
    }

    @Test
    public void testRemoveMotor()
    {
        auto1.addMotor(1000);
        assertEquals(1000, auto1.getHubraum());
        auto1.removeMotor();
        assertEquals(false, auto1.isMotor());
    }

    @Test
    public void testAddZuendkerze()
    {
        auto1.addMotor(1000);
        auto1.mountZuendkerze();
        assertEquals(true, auto1.isZuendkerze());
    }
}
