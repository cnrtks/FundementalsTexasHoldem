package texasholdem;

import java.util.ArrayList;
import java.util.Iterator;

public class TexasRound {

    public static final double MINIMUM_BET = 0.25;
    public static final double SMALL_BLIND = 1;
    public static final double BIG_BLIND = 2;

    //private String roundName;
    //the total money on the table
    private double pot = 0;
    //the total a player must have bet during the round to stay in
    private double highestBet = 0;
    //the smallest wallet entering the game ensures everyone can play (split pot not implemented)
    private double totalBetCap = 0;
    //keeps track of whos turn it is
    private int currentPlayer;
    //borrows players from games arraylist
    private ArrayList<TexasPlayer> roundPlayers;
    //true when no players must see to meet a raise, everyone has stayed
    public boolean allCall = false;
    //keeps track of the highest hand value for players in showdown
    public int highestHand = 0;
    public boolean lastManStanding = false;
    public Deck deck;
    public Table table;

    public TexasRound(ArrayList<TexasPlayer> perpetualPlayers, int firstPlayer) {
        //setRoundName(name);
        roundPlayers = new ArrayList<TexasPlayer>();
        for (int i = 0; i < (perpetualPlayers.size()); i++) {
            roundPlayers.add(perpetualPlayers.get(i));
            totalBetCap = totalBetCap > roundPlayers.get(i).getWallet() ? totalBetCap : roundPlayers.get(i).getWallet();
        }
        currentPlayer = firstPlayer;

        deck = new Deck();
        deck.shuffle();
        table = new Table();

        smallBlind(roundPlayers.get(currentPlayer));
        nextPlayer();
        bigBlind(roundPlayers.get(currentPlayer));
        nextPlayer();
        //hole cards
        dealFirstHand();
        betRound();
        //the flop
        dealTable();
        dealTable();
        dealTable();
        betRound();
        //the turn
        dealTable();
        betRound();
        //the river
        dealTable();
        betRound();
        System.out.println(table.toString());
        showdown();
    }

    public void setCurrentPlayer(int currentPlayer) {
        this.currentPlayer = currentPlayer;
    }
    //end of getters and setters

    public void bet(TexasPlayer player, double amount) {
        player.walletUpdate(-1 * amount);
        player.roundBetUpdate(amount);
        highestBet = player.getRoundBet() > highestBet ? player.getRoundBet() : highestBet;
        pot += amount;
    }

    public void bigBlind(TexasPlayer player) {
        bet(player, BIG_BLIND);
    }

    public void smallBlind(TexasPlayer player) {
        bet(player, SMALL_BLIND);
    }

    public Card dealTopCard(Deck deck) {
        Card c = deck.getCard();
        deck.removeCard();
        return c;
    }

    public void dealFirstHand() {
        for (TexasPlayer t : roundPlayers) {
            t.setCard1(deck.getCard());
            deck.removeCard();
        }
        for (TexasPlayer t : roundPlayers) {
            t.setCard2(deck.getCard());
            deck.removeCard();
        }
    }

    public void dealTable() {
        table.setCard(deck.getCard());
        deck.removeCard();
    }

    public void nextPlayer() {
        currentPlayer = currentPlayer < roundPlayers.size() - 1 ? currentPlayer + 1 : 0;
    }

    public void playerPrompt(TexasPlayer player) {
        System.out.println(table.toString());
        System.out.println(TexasRoundOutput.playerHand(player));
        System.out.println(TexasRoundOutput.walletString(player.getWallet()));
        System.out.println(TexasRoundOutput.toCallString(toCall(player)));

        //boolean param tells menu if call or stay
        System.out.println(TexasRoundOutput.betMenuString(toCall(player) == 0));
        betMenu(player, TexasRoundInput.getBetMenu());
    }

    public void see(TexasPlayer player) {
        bet(player, toCall(player));
    }

    public void raise(TexasPlayer player) {
        see(player);
        System.out.println("\nRaise Amount: ");
        double amount = TexasRoundInput.getRaiseAmount(totalBetCap - highestBet);
        bet(player, amount);
    }

    public boolean checkCall() {
        for (int i = 0; i < roundPlayers.size(); i++) {
            if (roundPlayers.get(i).getRoundBet() != highestBet) {
                return false;
            }
        }
        return true;
    }

    //logic relating to gameplay, this occurs three times during the game
    public void betRound() {
        for (int i = 0; i < roundPlayers.size() && !lastManStanding; i++) {
            playerPrompt(roundPlayers.get(currentPlayer));
            nextPlayer();
        }
        allCall = checkCall();
        while (!allCall && !lastManStanding) {
            playerPrompt(roundPlayers.get(currentPlayer));
            nextPlayer();
            allCall = checkCall();
        }
    }

    public void checkLMS() {
        if (roundPlayers.size() == 1) {
            lastManStanding = true;
        }
    }

    public double toCall(TexasPlayer player) {
        return highestBet - player.getRoundBet();
    }

    public void betMenu(TexasPlayer player, int menuItem) {
        switch (menuItem) {
            case 1: //see or stay
                see(player);
                break;
            case 2: //raise
                raise(player);
                break;
            case 3: //fold
                roundPlayers.remove(player);
                setCurrentPlayer(currentPlayer -= 1);
                checkLMS();
                break;
            default:
                betMenu(player, TexasRoundInput.getBetMenu());
        }
    }

    public void showdown() {
        roundPlayers.stream().map((t) -> {
            t.addCards(table.getComCards());
            return t;
        }).map((t) -> {
            HandValueChecker hvc = new HandValueChecker(t);
            return t;
        }).forEachOrdered((t) -> {
            highestHand = t.getHandValue() > highestHand ? t.getHandValue() : highestHand;
        });
        Iterator i = roundPlayers.iterator();
        while (i.hasNext()) {
            if (((TexasPlayer) i.next()).getHandValue() != highestHand) {
                i.remove();
            }
        }

        checkLMS();
        if (!lastManStanding) {
            kickerCheck();
        }
        checkLMS();
        if (!lastManStanding) {
            splitPot();
        } else {
            try {
                wonPot(roundPlayers.get(0));
            } catch (Exception ex) {
                System.out.println("Player count error, roundPlayers empty");
            }
        }
    }

    public void kickerCheck() {
        int elementToCheck;
        int kickerValue = 0;
        switch (highestHand) {
            case 1:
                elementToCheck = 1;
                break;
            case 2:
                elementToCheck = 2;
                break;
            case 3:
                elementToCheck = 4;
                break;
            case 4:
                elementToCheck = 3;
                break;
            default:
                elementToCheck = 0;
        }
        if (elementToCheck != 0) {
            for (TexasPlayer t : roundPlayers) {
                kickerValue = ((PlayingCard) t.hand.get(elementToCheck)).getRank().getVal()
                        > kickerValue ? ((PlayingCard) t.hand.get(elementToCheck)).getRank().getVal()
                                : kickerValue;
            }
            Iterator i = roundPlayers.iterator();
            while (i.hasNext()) {
                if (((PlayingCard) ((TexasPlayer) i.next()).hand.get(elementToCheck)).getRank().getVal() != kickerValue) {
                    i.remove();
                }
            }
        }
    }

    public void splitPot() {
        roundPlayers.forEach((t) -> {
            t.walletUpdate(pot / roundPlayers.size());
        });
        System.out.println("Split pot: $" + pot);// move this to texasRoundOutput
    }

    public void wonPot(TexasPlayer winner) {
        winner.walletUpdate(pot);
        System.out.println(winner.getHand());
        System.out.println(winner.getPlayerId() + " Wins $" + pot);//move this to texasRoundOutput
    }
}
