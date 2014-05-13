package course.rcc.cis18b.chess;

import course.rcc.cis18b.chess.GUI.SwingGuiManager;

public class Main
{
    public static void main(String[] args)
    {
        Application.setGuiManager(new SwingGuiManager());
        Application application = Application.getInstance();
    }
}
