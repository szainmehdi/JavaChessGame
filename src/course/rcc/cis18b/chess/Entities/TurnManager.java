package course.rcc.cis18b.chess.Entities;

import java.util.ArrayList;

public class TurnManager
{
    public static final int NUM_PLAYERS = 2;

    private static TurnManager instance = null;
    private Player[] players = new Player[NUM_PLAYERS];

    private int turnIndex = 0;

    public static TurnManager getInstance()
    {
        if(instance == null)
            instance = new TurnManager();
        return instance;
    }

    private TurnManager()
    {

    }

    public void setPlayers(Player[] players) throws IllegalArgumentException {
        if(players.length != NUM_PLAYERS) {
            throw new IllegalArgumentException("Exactly "+NUM_PLAYERS+" players are required.");
        }
        this.players = players;
    }


    public Player next()
    {
        return players[incrementTurn()];
    }

    private int incrementTurn() {
        if(++turnIndex >= NUM_PLAYERS) {
            turnIndex = 0;
        }
        return turnIndex;
    }
}
