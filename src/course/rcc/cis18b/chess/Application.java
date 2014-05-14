package course.rcc.cis18b.chess;

import course.rcc.cis18b.chess.Entities.*;
import course.rcc.cis18b.chess.GUI.ConsoleUIManager;
import course.rcc.cis18b.chess.GUI.GuiManager;
import course.rcc.cis18b.chess.GUI.SwingGuiManager;

public class Application {
    private static Application application = null;

    public Board board = null;
    private static GuiManager guiManager = null;

    public static void setGuiManager(GuiManager m) {
        guiManager = m;
    }

    public static GuiManager getGuiManager() {
        return guiManager;
    }

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
        // Trigger the next stage of the application.
        this.onStart();
    }

    private void onStart()
    {
        // Show the populated board to the user.
        Board board = Board.getInstance();
        board.reset();
        board.render();
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