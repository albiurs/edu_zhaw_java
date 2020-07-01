package com.publicept.edujava.fahrzeuge;



import static org.junit.Assert.*;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

/**
 * The test class VerkehrsmittelTest.
 *
 * @author  Urs Albisser
 * @version 0.1
 */
public class VerkehrsmittelTest
{
    private Verkehrsmittel verkehrs1NoParam;
    private Verkehrsmittel verkehrs2Params;

    /**
     * Default constructor for test class VerkehrsmittelTest
     */
    public VerkehrsmittelTest()
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
        verkehrs1NoParam = new Verkehrsmittel();
        verkehrs2Params = new Verkehrsmittel("velo", "grün");
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
    public void testAddFahrzeugAuto()
    {
        verkehrs1NoParam.addFahrzeug("auto", "rot");
        assertEquals(true, verkehrs1NoParam.isAuto());
    }

    @Test
    public void testAddFahrzeugVelo()
    {
        verkehrs1NoParam.addFahrzeug("velo", "blau");
        assertEquals(true, verkehrs1NoParam.isVelo());
    }

    @Test
    public void testAddAndRemoveFahrzeuge()
    {
        verkehrs1NoParam.addFahrzeug("Auto", "rot");
        verkehrs1NoParam.addFahrzeug("Velo", "blau");
        assertEquals(true, verkehrs1NoParam.isAuto());
        assertEquals(true, verkehrs1NoParam.isVelo());
        verkehrs1NoParam.removeFahrzeug("velo", 0);
        verkehrs1NoParam.removeFahrzeug("auto", 0);
        assertEquals(false, verkehrs1NoParam.isAuto());
        assertEquals(false, verkehrs1NoParam.isVelo());
    }
}
