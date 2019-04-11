package texasholdem;

import java.util.ArrayList;

public class TexasPlayer extends Player {

    private boolean stillIn = true; //in the overall game, not the round 
    private double initialWallet;
    private double wallet;
    private double roundBet = 0;
    private Card card1;//replace with the arraylist
    private Card card2;//replace with the arraylist
    public ArrayList<Card> hand; //change to private
    private int handValue = 0;

    TexasPlayer(String id, double wallet) {
        super(id);
        setWallet(wallet);
        initialWallet = wallet;
        hand = new ArrayList<Card>();
    }

    //getters and setters
    public void setWallet(double wallet) {
        this.wallet = wallet;
    }

    public double getWallet() {
        return wallet;
    }

    public void setCard1(Card card) {
        card1 = card;
        hand.add(card);
    }

    public Card getCard1() {
        return card1;
    }

    public void setCard2(Card card) {
        card2 = card;
        hand.add(card);
    }

    public Card getCard2() {
        return card2;
    }

    public double getRoundBet() {
        return roundBet;
    }

    public void setHand(ArrayList<Card> hand) {
        this.hand.clear();
        this.hand.addAll(hand);
    }

    public void addCard (Card card){
        this.hand.add(card);
    }
    public void addCards(ArrayList<Card> cards) {
        this.hand.addAll(cards);
    }

    public ArrayList<Card> getHand() {
        return hand;
    }
    
    public void clearHand(){
        hand.clear();
    }

    public void setHandValue(int handValue) {
        this.handValue = handValue;
    }

    public int getHandValue() {
        return handValue;
    }

    /**
     * @return the stillIn
     */
    public boolean isStillIn() {
        return stillIn;
    }

    /**
     * @param stillIn the stillIn to set
     */
    public void setStillIn(boolean stillIn) {
        this.stillIn = stillIn;
    }

    /**
     * @return the initialWalletSize
     */
    public double getInitialWallet() {
        return initialWallet;
    }
    //end of getters and setters

    public void walletUpdate(double amount) {
        wallet += amount;
    }

    public void roundBetUpdate(double amount) {
        roundBet += amount;
    }

    public void clearRoundData() {
        roundBet = 0;
        hand.clear();
        handValue = 0;
    }

    //abstracted method from parent class ///// fix it
    public void play() {
        System.out.println("I'm not sure what this is for yet");
    }
}
