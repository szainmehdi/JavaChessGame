package course.rcc.cis18b.chess;

import java.util.ArrayList;

public class TurnManager {
    private static TurnManager instance = null;
    private  ArrayList<Player> players = new ArrayList<Player>();

    public static TurnManager getInstance() {
        if(instance==null) {
            instance = new TurnManager();
        }
        return instance;

    }

    private TurnManager() {

    }
}
