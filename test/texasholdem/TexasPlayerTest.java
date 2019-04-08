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
public class TexasPlayerTest {
    
    public TexasPlayerTest() {
    }
    
    @BeforeAll
    public static void setUpClass() {
        TexasPlayer testPlayer = new TexasPlayer("test", 100);
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
     * Test of setWallet method, of class TexasPlayer.
     */
    @Test
    public void testSetWalletGood() {
        System.out.println("setWallet");
        double wallet = 100;
        TexasPlayer instance = null;
        instance.setWallet(wallet);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
    
        @Test
    public void testSetWalletBad() {
        System.out.println("setWallet");
        double wallet = 0.0;
        TexasPlayer instance = null;
        instance.setWallet(wallet);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
    
        @Test
    public void testSetWalletBoundary() {
        System.out.println("setWallet");
        double wallet = 0.0;
        TexasPlayer instance = null;
        instance.setWallet(wallet);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getWallet method, of class TexasPlayer.
     */
    @Test
    public void testGetWallet() {
        System.out.println("getWallet");
        TexasPlayer instance = null;
        double expResult = 0.0;
        double result = instance.getWallet();
        assertEquals(expResult, result, 0.0);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setCard1 method, of class TexasPlayer.
     */
    @Test
    public void testSetCard1() {
        System.out.println("setCard1");
        Card card = null;
        TexasPlayer instance = null;
        instance.setCard1(card);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getCard1 method, of class TexasPlayer.
     */
    @Test
    public void testGetCard1() {
        System.out.println("getCard1");
        TexasPlayer instance = null;
        Card expResult = null;
        Card result = instance.getCard1();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setCard2 method, of class TexasPlayer.
     */
    @Test
    public void testSetCard2() {
        System.out.println("setCard2");
        Card card = null;
        TexasPlayer instance = null;
        instance.setCard2(card);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getCard2 method, of class TexasPlayer.
     */
    @Test
    public void testGetCard2() {
        System.out.println("getCard2");
        TexasPlayer instance = null;
        Card expResult = null;
        Card result = instance.getCard2();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getRoundBet method, of class TexasPlayer.
     */
    @Test
    public void testGetRoundBet() {
        System.out.println("getRoundBet");
        TexasPlayer instance = null;
        double expResult = 0.0;
        double result = instance.getRoundBet();
        assertEquals(expResult, result, 0.0);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setHand method, of class TexasPlayer.
     */
    @Test
    public void testSetHand() {
        System.out.println("setHand");
        ArrayList<Card> hand = null;
        TexasPlayer instance = null;
        instance.setHand(hand);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of addCard method, of class TexasPlayer.
     */
    @Test
    public void testAddCard() {
        System.out.println("addCard");
        Card card = null;
        TexasPlayer instance = null;
        instance.addCard(card);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of addCards method, of class TexasPlayer.
     */
    @Test
    public void testAddCards() {
        System.out.println("addCards");
        ArrayList<Card> cards = null;
        TexasPlayer instance = null;
        instance.addCards(cards);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getHand method, of class TexasPlayer.
     */
    @Test
    public void testGetHand() {
        System.out.println("getHand");
        TexasPlayer instance = null;
        ArrayList<Card> expResult = null;
        ArrayList<Card> result = instance.getHand();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of clearHand method, of class TexasPlayer.
     */
    @Test
    public void testClearHand() {
        System.out.println("clearHand");
        TexasPlayer instance = null;
        instance.clearHand();
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setHandValue method, of class TexasPlayer.
     */
    @Test
    public void testSetHandValue() {
        System.out.println("setHandValue");
        int handValue = 0;
        TexasPlayer instance = null;
        instance.setHandValue(handValue);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getHandValue method, of class TexasPlayer.
     */
    @Test
    public void testGetHandValue() {
        System.out.println("getHandValue");
        TexasPlayer instance = null;
        int expResult = 0;
        int result = instance.getHandValue();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of isStillIn method, of class TexasPlayer.
     */
    @Test
    public void testIsStillIn() {
        System.out.println("isStillIn");
        TexasPlayer instance = null;
        boolean expResult = false;
        boolean result = instance.isStillIn();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setStillIn method, of class TexasPlayer.
     */
    @Test
    public void testSetStillIn() {
        System.out.println("setStillIn");
        boolean stillIn = false;
        TexasPlayer instance = null;
        instance.setStillIn(stillIn);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getInitialWallet method, of class TexasPlayer.
     */
    @Test
    public void testGetInitialWallet() {
        System.out.println("getInitialWallet");
        TexasPlayer instance = null;
        double expResult = 0.0;
        double result = instance.getInitialWallet();
        assertEquals(expResult, result, 0.0);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of walletUpdate method, of class TexasPlayer.
     */
    @Test
    public void testWalletUpdate() {
        System.out.println("walletUpdate");
        double amount = 0.0;
        TexasPlayer instance = null;
        instance.walletUpdate(amount);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of roundBetUpdate method, of class TexasPlayer.
     */
    @Test
    public void testRoundBetUpdate() {
        System.out.println("roundBetUpdate");
        double amount = 0.0;
        TexasPlayer instance = null;
        instance.roundBetUpdate(amount);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of clearRoundData method, of class TexasPlayer.
     */
    @Test
    public void testClearRoundData() {
        System.out.println("clearRoundData");
        TexasPlayer instance = null;
        instance.clearRoundData();
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of play method, of class TexasPlayer.
     */
    @Test
    public void testPlay() {
        System.out.println("play");
        TexasPlayer instance = null;
        instance.play();
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
    
}
