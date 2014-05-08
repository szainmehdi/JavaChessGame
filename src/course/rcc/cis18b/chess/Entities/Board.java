package course.rcc.cis18b.chess.Entities;

import course.rcc.cis18b.chess.GUI.GuiManager;

import java.util.ArrayList;
import java.util.Scanner;

public class Board
{
    public static final int ROWS = 8;
    public static final int COLUMNS = 8;
    public Space[][] grid = new Space[ROWS][COLUMNS];

    public GuiManager guiManager = null;

    public Board(GuiManager guiManager) {
        this.guiManager = guiManager;
    }

    public void render() {
        // Draw the grid with the pieces.
//        guiManager.createWindow();

//        guiManager.draw();

    }

}
