package course.rcc.cis18b.chess;

import course.rcc.cis18b.chess.Entities.*;
import course.rcc.cis18b.chess.GUI.ConsoleUIManager;
import course.rcc.cis18b.chess.GUI.SwingGuiManager;

public class Application {
    private static Application application = null;

    public Board board = null;
    public Player currentPlayer = null;


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
        //Board.setGuiManager(new ConsoleUIManager());
        Board.setGuiManager(new SwingGuiManager());

        this.currentPlayer = TurnManager.getInstance().currentPlayer();

        // Trigger the next stage of the application.
        this.onStart();
    }

    private void onStart()
    {
        // Show the populated board to the user.
        Board board = Board.getInstance();
        board.reset();
        board.render();

        try {

            board.getSpace(1, 3).getPiece().move(2,3);
            board.render();

            currentPlayer = TurnManager.getInstance().next();

            Piece piece = board.getSpace(6, 3).getPiece();
            piece.move(5,3);
            board.render();

            currentPlayer = TurnManager.getInstance().next();

            board.getSpace(1, 4).getPiece().move(2,4);
            board.render();

        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

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
        board.render();
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