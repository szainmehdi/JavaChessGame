package course.rcc.cis18b.chess;

import course.rcc.cis18b.chess.Entities.Player;
import course.rcc.cis18b.chess.Entities.PlayerTeam;

public class TurnManager
{
    public static final int NUM_PLAYERS = 2;

    private static TurnManager instance = null;
    private Player[] players = new Player[NUM_PLAYERS];
    private static PlayerTeam[] teams = {
            PlayerTeam.WHITE,
            PlayerTeam.BLACK
    };

    private int turnIndex = 0;

    public static TurnManager getInstance()
    {
        if(instance == null)
            instance = new TurnManager();
        return instance;
    }

    private TurnManager()
    {
        this.initialize();
    }

    public Player currentPlayer() {
        return players[turnIndex];
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

    private void initialize() {
        for(int i = 0; i < NUM_PLAYERS; i++) {
            players[i] = new Player(getTeam(i));
        }
    }

    private PlayerTeam getTeam(int i) {
        if(i >= teams.length) {
            i = 0;
        }
        return teams[i];
    }

    public void resetTurns() {
        turnIndex = 0;
    }
}