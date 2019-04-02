package texasholdem;

import java.util.ArrayList;

public class TexasHoldemInput extends UserInput {

    //min and max number of players for a game of texas holdem
    public static final int MIN_PLAYERS = 2;
    public static final int MAX_PLAYERS = 10;

    public static int getNumPlayers() {//change to throw
        int ret = getInt();
        if (ret < MIN_PLAYERS || ret > MAX_PLAYERS) {
            System.out.printf("\nMust be an integer between %d and %d", MIN_PLAYERS, MAX_PLAYERS);
            ret = getNumPlayers();
        }
        return ret;
    }
    
    public static boolean getYesNo(){
        boolean ret = true;
        switch (UserInput.getString().charAt(0)) {
            case 'y':
            case 'Y':
                ret = true;
                break;
            case 'n':
            case 'N':
                ret = false;
                break;
            default:
                System.out.println("Enter 'y' or 'n'");
                ret = getYesNo();
                break;
        }
        return ret;
    }
    
    public static String getPlayerId(ArrayList <TexasPlayer> players){
        String ret = UserInput.getString();
        
        for (TexasPlayer t : players){
            if (ret.matches(t.getPlayerId())){
                System.out.println("Id already in Use");
                ret = getPlayerId(players);
            }
        } 
        return ret;
    }
    
    public static double getPlayerWallet(){
        double wallet = UserInput.getDouble();
        if (wallet <= 0){
            System.out.println("Enter positive value");
            wallet = getPlayerWallet();
        }
        return wallet;
    }
}
