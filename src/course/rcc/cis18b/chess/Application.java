package course.rcc.cis18b.chess;

import course.rcc.cis18b.chess.Entities.Board;
import course.rcc.cis18b.chess.Entities.Player;

public class Application {
    private static Application application = null;

    public Board board = null;

    public static final int NUM_PLAYERS = 2;
    public Player[] players = null;


    public static Application getInstance() {
        if(application == null)
            application = new Application();
        return application;
    }

    private Application() {
        this.onCreate();
    }

    private void onCreate()
    {
        // Create and instantiate all the necessary objects to start.
        this.board = new Board();
        this.players = new Player[NUM_PLAYERS];

        // Trigger the next stage of the application.
        this.onStart();
    }

    private void onStart()
    {
        // Show the populated board to the user.

        /*
        do {
            // Prompt the user to select a piece and an empty space to move to.

            // Make the move happen.

            // Switch player.
        } while (// game not over);
         */

    }

    private void onPause()
    {

    }

    private void onResume()
    {

    }

    private void onUpdate()
    {

    }

    public void pause()
    {
        this.onPause();
    }

    public void resume()
    {
        this.onResume();
    }

    public void update()
    {
        this.onUpdate();
    }
}