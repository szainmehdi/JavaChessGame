package course.rcc.cis18b.chess.GUI;

import course.rcc.cis18b.chess.Entities.Board;
import course.rcc.cis18b.chess.Entities.Space;

public class ConsoleUIManager implements GuiManager {
    @Override
    public void render() {

        clearConsole();

        Board board = Board.getInstance();

        for (int row = 0; row < Board.ROWS; row++) {
            for (int column = 0; column < Board.COLUMNS; column++) {
                Space space = board.getSpace(row, column);
                System.out.printf(
                        "[ %s ]",
                        ((space.isEmpty()) ? " " : space.getPiece().getAbbreviation())
                );
            }
            System.out.print("\n");
        }
    }

    public final static void clearConsole() {
        int i = 0;
        while (i != 30) {
            i++;
            System.out.println("\n");
        }
    }

    @Override
    public int getTileSize() {
        return 1;
    }

    @Override
    public void showMessage(String msg) {
        System.out.println(msg);
    }


    @Override
    public void showAlert(String msg) {
        System.err.println(msg);

    }
}

