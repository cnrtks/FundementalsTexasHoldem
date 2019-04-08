/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package texasholdem;

import java.util.ArrayList;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

/**
 *
 * @author Soda
 */
public class HandValueCheckerTest {
    
    public HandValueCheckerTest() {
    }
    
    @BeforeAll
    public static void setUpClass() {
    }
    
    @AfterAll
    public static void tearDownClass() {
    }
    
    @BeforeEach
    public void setUp() {
    }
    
    @AfterEach
    public void tearDown() {
    }

    /**
     * Test of getHandValue method, of class HandValueChecker.
     */
    @Test
    public void testGetHandValue() {
        System.out.println("getHandValue");
        HandValueChecker instance = null;
        int expResult = 0;
        int result = instance.getHandValue();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of straightCheck method, of class HandValueChecker.
     */
    @Test
    public void testStraightCheck() {
        System.out.println("straightCheck");
        HandValueChecker instance = null;
        boolean expResult = false;
        boolean result = instance.straightCheck();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of flushCheck method, of class HandValueChecker.
     */
    @Test
    public void testFlushCheck() {
        System.out.println("flushCheck");
        ArrayList<PlayingCard> givenHand = null;
        HandValueChecker instance = null;
        boolean expResult = false;
        boolean result = instance.flushCheck(givenHand);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of matchCheck method, of class HandValueChecker.
     */
    @Test
    public void testMatchCheck() {
        System.out.println("matchCheck");
        HandValueChecker instance = null;
        int expResult = 0;
        int result = instance.matchCheck();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of toString method, of class HandValueChecker.
     */
    @Test
    public void testToString() {
        System.out.println("toString");
        HandValueChecker instance = null;
        String expResult = "";
        String result = instance.toString();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
    
}
