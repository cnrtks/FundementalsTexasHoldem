package texasholdem;

import java.util.ArrayList;
import java.util.Iterator;

public class TexasHoldem extends Game {

    private ArrayList<TexasPlayer> players;// the players of the game
    private ArrayList<TexasPlayer> remainingPlayers; //the players that are still participating
    double highestWon = 0;
    int firstPlayer = 0;
    int rounds = 0;

    TexasHoldem(String givenName) {
        super(givenName);
        play();
    }

    public int getFirstPlayer() {
        return firstPlayer;
    }

    public void nextPlayer() {
        firstPlayer = firstPlayer < remainingPlayers.size() - 1 ? firstPlayer++ : 0;
    }

    public void clearRoundData() {
        players.forEach((t) -> {
            t.clearRoundData();
        });
    }

    public void checkWallets() {
        Iterator i = remainingPlayers.iterator();
        while (i.hasNext()) {
            if (((TexasPlayer) i.next()).getWallet() <= 0) {
                i.remove();
            }
        }
    }

    public void initializePlayer() {
        String id = TexasHoldemOutput.playerId(players);
        double wallet = TexasHoldemOutput.playerWallet();
        players.add(new TexasPlayer(id, wallet));
    }

    public void continuePrompt() {
        Iterator<TexasPlayer> i = remainingPlayers.iterator();
        while (i.hasNext()) {
            i.next();
            boolean yesContinue = TexasHoldemOutput.playNextRound();
            if (!yesContinue) {
                i.remove();
            }
        }
    }

    //abstracted method from parent class 
    @Override
    public void play() {
        int numOfPlayers = TexasHoldemOutput.numPlayers();
        players = new ArrayList();
        remainingPlayers = new ArrayList();

        for (int i = 0; i < numOfPlayers; i++) {
            initializePlayer();
        }
        remainingPlayers.addAll(players);
        while (remainingPlayers.size() > 1) {
            TexasRound round = new TexasRound(remainingPlayers, firstPlayer);
            clearRoundData();
            checkWallets();
            continuePrompt();
            nextPlayer();
        }
        declareWinner();
    }

    //abstracted method from parent class ///// fix it
    @Override
    public void declareWinner() {
        players.forEach((t) -> {
            highestWon = t.getWallet() - t.getInitialWallet() > highestWon ? t.getWallet() - t.getInitialWallet() : highestWon;
        });
        remainingPlayers.clear();

        players.stream().filter((t) -> (t.getWallet() - t.getInitialWallet() == highestWon)).forEachOrdered((t) -> {
            remainingPlayers.add(t);
            System.out.println(TexasHoldemOutput.winnerDialogue(t));
        });
        System.out.println("Game Over");
    }

}
