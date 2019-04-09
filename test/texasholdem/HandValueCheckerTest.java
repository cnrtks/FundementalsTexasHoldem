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

    PlayingCard s3, d3, d4, d5, d6, d7, d8, d9, d0, dk, da, s4, s5, s8, s9, s0, sa, sk, sj, sq, h5, hq, hk, c5, c7;
    ArrayList<PlayingCard> highCard, pair, pair2, pair3, toak, straight, flush, fullHouse, foak, sf, rf, sfl;
    HandValueChecker hand1, hand2, hand3, hand4, hand5, hand6, hand7, hand8, hand9, hand0, hand9l, hand3pair;

    public HandValueCheckerTest() {
        s3 = new PlayingCard(Rank.THREE, Suit.SPADES);
        d3 = new PlayingCard(Rank.THREE, Suit.DIAMONDS);
        s4 = new PlayingCard(Rank.FOUR, Suit.SPADES);
        d4 = new PlayingCard(Rank.FOUR, Suit.DIAMONDS);
        s5 = new PlayingCard(Rank.FIVE, Suit.SPADES);
        d5 = new PlayingCard(Rank.FIVE, Suit.DIAMONDS);
        hq = new PlayingCard(Rank.QUEEN, Suit.HEARTS);

        c5 = new PlayingCard(Rank.FIVE, Suit.CLUBS);

        d6 = new PlayingCard(Rank.SIX, Suit.DIAMONDS);
        d7 = new PlayingCard(Rank.SEVEN, Suit.DIAMONDS);
        c7 = new PlayingCard(Rank.SEVEN, Suit.CLUBS);

        hk = new PlayingCard(Rank.KING, Suit.HEARTS);
        da = new PlayingCard(Rank.ACE, Suit.DIAMONDS);
        dk = new PlayingCard(Rank.KING, Suit.DIAMONDS);

        d8 = new PlayingCard(Rank.EIGHT, Suit.DIAMONDS);
        d9 = new PlayingCard(Rank.NINE, Suit.DIAMONDS);
        d0 = new PlayingCard(Rank.TEN, Suit.DIAMONDS);

        s9 = new PlayingCard(Rank.NINE, Suit.SPADES);
        s0 = new PlayingCard(Rank.TEN, Suit.SPADES);

        sa = new PlayingCard(Rank.ACE, Suit.SPADES);
        sk = new PlayingCard(Rank.KING, Suit.SPADES);
        sj = new PlayingCard(Rank.JACK, Suit.SPADES);
        sq = new PlayingCard(Rank.QUEEN, Suit.SPADES);
        s8 = new PlayingCard(Rank.EIGHT, Suit.SPADES);
        
        h5 = new PlayingCard(Rank.FIVE, Suit.HEARTS);

        highCard = new ArrayList();//ace high
        highCard.add(s3);
        highCard.add(d4);
        highCard.add(s5);
        highCard.add(d6);
        highCard.add(s8);
        highCard.add(hk);
        highCard.add(da);

        pair = new ArrayList();//1pair
        pair.add(s3);
        pair.add(d3);
        pair.add(s5);
        pair.add(d6);
        pair.add(s8);
        pair.add(hk);
        pair.add(da);

        pair2 = new ArrayList();//2pair
        pair2.add(s3);
        pair2.add(d3);
        pair2.add(s5);
        pair2.add(d5);
        pair2.add(s8);
        pair2.add(hk);
        pair2.add(da);

        pair3 = new ArrayList();//3pair
        pair3.add(s3);
        pair3.add(d3);
        pair3.add(s4);
        pair3.add(d4);
        pair3.add(s5);
        pair3.add(d5);
        pair3.add(hq);

        toak = new ArrayList();//3 of a kind
        toak.add(s3);
        toak.add(dk);
        toak.add(s4);
        toak.add(da);
        toak.add(s5);
        toak.add(d5);
        toak.add(c5);

        straight = new ArrayList();//straight
        straight.add(d3);
        straight.add(s4);
        straight.add(d4);
        straight.add(s5);
        straight.add(d6);
        straight.add(c7);
        straight.add(d7);

        flush = new ArrayList();//flush
        flush.add(da);
        flush.add(s4);
        flush.add(d4);
        flush.add(hk);
        flush.add(d6);
        flush.add(dk);
        flush.add(d7);

        fullHouse = new ArrayList();//full house
        fullHouse.add(s3);
        fullHouse.add(d3);
        fullHouse.add(d4);
        fullHouse.add(s5);
        fullHouse.add(d5);
        fullHouse.add(c5);
        fullHouse.add(hk);

        foak = new ArrayList();//four of a kind
        foak.add(s5);
        foak.add(d5);
        foak.add(c5);
        foak.add(h5);
        foak.add(s3);
        foak.add(d3);
        foak.add(hk);

        sf = new ArrayList();//straight flush
        sf.add(d3);
        sf.add(d8);
        sf.add(d5);
        sf.add(d6);
        sf.add(d7);
        sf.add(d9);
        sf.add(d0);

        rf = new ArrayList();//royalflush
        rf.add(sa);
        rf.add(d4);
        rf.add(sk);
        rf.add(sq);
        rf.add(sj);
        rf.add(s9);
        rf.add(s0);

        sfl = new ArrayList();//stright flush lower than striaght
        sfl.add(d3);
        sfl.add(d4);
        sfl.add(d5);
        sfl.add(d6);
        sfl.add(d7);
        sfl.add(s9);
        sfl.add(s8);

        hand1 = new HandValueChecker(highCard);
        hand2 = new HandValueChecker(pair);
        hand3 = new HandValueChecker(pair3);
        hand4 = new HandValueChecker(toak);
        hand5 = new HandValueChecker(straight);
        hand6 = new HandValueChecker(flush);
        hand7 = new HandValueChecker(fullHouse);
        hand8 = new HandValueChecker(foak);
        hand9 = new HandValueChecker(sf);
        hand0 = new HandValueChecker(rf);
        hand9l = new HandValueChecker(sfl);

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
    public void testGetHandValueHighCard() {
        System.out.println("getHandValue check HighCard");
        int expResult = 1;
        int result = hand1.getHandValue();
        assertEquals(expResult, result);
    }

    @Test
    public void testGetHandValuePair() {
        System.out.println("getHandValue check Pair");
        int expResult = 2;
        int result = hand2.getHandValue();
        assertEquals(expResult, result);
    }

    @Test
    public void testGetHandValueTwoPair() {
        System.out.println("getHandValue check Two Pair");
        int expResult = 3;
        int result = hand3.getHandValue();
        assertEquals(expResult, result);
    }

    @Test
    public void testGetHandValueThreeOfAKind() {
        System.out.println("getHandValue check Three of a Kind");
        int expResult = 4;
        int result = hand4.getHandValue();
        assertEquals(expResult, result);
    }

    @Test
    public void testGetHandValueStraight() {
        System.out.println("getHandValue check Straight");
        int expResult = 5;
        int result = hand5.getHandValue();
        assertEquals(expResult, result);
    }

    @Test
    public void testGetHandValueFlush() {
        System.out.println("getHandValue check Flush");
        int expResult = 6;
        int result = hand6.getHandValue();
        assertEquals(expResult, result);
    }

    @Test
    public void testGetHandValueHighCardFullHouse() {
        System.out.println("getHandValue check Full House");
        int expResult = 7;
        int result = hand7.getHandValue();
        assertEquals(expResult, result);
    }

    @Test
    public void testGetHandValueFourOfAKind() {
        System.out.println("getHandValue check Four of a Kind");
        int expResult = 8;
        int result = hand8.getHandValue();
        assertEquals(expResult, result);
    }

    @Test
    public void testGetHandValueStraightFlush() {
        System.out.println("getHandValue check Straight Flush");
        int expResult = 9;
        int result = hand9.getHandValue();
        assertEquals(expResult, result);
    }

    @Test
    public void testGetHandValueRoyalFlush() {
        System.out.println("getHandValue check Royal Flush");
        int expResult = 10;
        int result = hand0.getHandValue();
        assertEquals(expResult, result);
    }
    
        @Test
    public void testGetHandValueStraightFlushLow() {
        System.out.println("getHandValue check Straight Flush below flush");
        int expResult = 9;
        int result = hand9l.getHandValue();
        assertEquals(expResult, result);
    }

    /**
     * Test of straightCheck method, of class HandValueChecker.
     */
    @Test
    public void testStraightCheckGood() {
        System.out.println("straightCheckGood");
        boolean expResult = true;
        boolean result = hand5.straightCheck();
        assertEquals(expResult, result);
    }

    /**
     * Test of flushCheck method, of class HandValueChecker.
     */
    @Test
    public void testFlushCheck() {
        System.out.println("flushCheckGood");
        ArrayList<PlayingCard> givenHand = flush;
        boolean expResult = true;
        boolean result = hand6.flushCheck(givenHand);
        assertEquals(expResult, result);
    }

    /**
     * Test of matchCheck method, of class HandValueChecker.
     */
    @Test
    public void testMatchCheck() {
        System.out.println("matchCheckPair");
        int expResult = 2;
        int result = hand2.matchCheck();
        assertEquals(expResult, result);
    }
}
