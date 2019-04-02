package texasholdem;

import java.util.ArrayList;

public class TexasHoldemOutput {

    public static int numPlayers() {
        System.out.println("Enter Number of players: ");
        return  TexasHoldemInput.getNumPlayers();
    }

    public static String playerId(ArrayList<TexasPlayer>players) {
        System.out.println("Enter Unique ID");
        return TexasHoldemInput.getPlayerId(players);
    }

    public static double playerWallet() {
        System.out.println("How Much Money Did You Bring?: ");
        return TexasHoldemInput.getPlayerWallet();
    }

    public static boolean playNextRound() {
        System.out.println("Continue Playing? [y/n]: ");
        return TexasHoldemInput.getYesNo();
    }
   
}
