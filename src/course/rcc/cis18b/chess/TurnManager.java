package course.rcc.cis18b.chess;

import java.util.ArrayList;

public class TurnManager
{
    private static TurnManager _instance = null;
    private  ArrayList<Player> players = new ArrayList<Player>();

    public static TurnManager getInstance()
    {
        if(_instance == null)
        {
            _instance = new TurnManager();
        }
        return _instance;
    }

    private TurnManager()
    {

    }

    private void NextTurn()
    {

    }
}
