package texasholdem;

import java.util.Scanner;

public class TexasRoundInput extends UserInput {

    //first and last options on players bet menu
    public static final int MENU_FLOOR = 1;
    public static final int MENU_ITEMS = 3;
    
        public static int getBetMenu() {
        int ret = getInt();
        if (ret < MENU_FLOOR || ret > MENU_ITEMS) {
            System.out.printf("\nMust be an integer between %d and %d : ", MENU_FLOOR, MENU_ITEMS);
            ret = getBetMenu();
        }
        return ret;
    }
        
        public static double getRaiseAmount(double maxRaise) {
            double ret = getDouble();
            if (ret < 0 || ret > maxRaise){
                System.out.printf("\nRaise between $0 and $%.2f : ", maxRaise);
                ret = getRaiseAmount(maxRaise);
            }
            return ret;
        }
}
