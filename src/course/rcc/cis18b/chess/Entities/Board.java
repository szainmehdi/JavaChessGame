package course.rcc.cis18b.chess.Entities;

import course.rcc.cis18b.chess.Exceptions.InvalidMoveException;
import course.rcc.cis18b.chess.GUI.ConsoleUIManager;
import course.rcc.cis18b.chess.GUI.GuiManager;
import course.rcc.cis18b.chess.TurnManager;

public class Board
{
    public static final int ROWS = 8;
    public static final int COLUMNS = 8;
    public Space[][] grid = new Space[ROWS][COLUMNS];

    private static Board board = null;

    private static GuiManager guiManager = new ConsoleUIManager();

    private Board() {
        this.initialize();
    }

    public static Board getInstance() {
        if(board == null)
            board = new Board();
        return board;
    }

    public static void setGuiManager(GuiManager gm) {
        guiManager = gm;
    }

    public void render() {

        // Draw the grid with the pieces.
        this.guiManager.render();

    }

    /**
     * @param row
     * @param column
     * @return
     */
    public Space getSpace(int row, int column) throws IndexOutOfBoundsException {

        // Make sure that a space exists on the
        // grid at the given coordinates.
        if( ! spaceExists(row,column)) {
            throw new IndexOutOfBoundsException("A space does not exist at these coordinates: ("
                + row + ", " + column + ").");
        } else if (grid[row][column] == null) {
            grid[row][column] = new Space();
        }
        return grid[row][column];
    }

    public boolean spaceExists(int row, int column) {
       return (row < ROWS && column < COLUMNS);
    }

    public void initialize() {

        for (int r = 0; r < ROWS; r++) {
            for (int c = 0; c < COLUMNS; c++) {
                grid[r][c] = new Space();
            }
        }

    }

    public void reset() {
        // Create the pieces and assign them to the spaces.
        Player player = TurnManager.getInstance().currentPlayer();
        try {
            //*************
            // PLAYER ONE
            //*************
            int row = 6;
            for (int x = 0; x < COLUMNS; x++) {
                PieceFactory.make(player, PieceType.PAWN, row, x);
            }
            row = 7;
            PieceFactory.make(player,PieceType.ROOK,row, 0);
            PieceFactory.make(player,PieceType.KNIGHT,row, 1);
            PieceFactory.make(player,PieceType.BISHOP,row, 2);
            PieceFactory.make(player,PieceType.QUEEN,row, 3);
            PieceFactory.make(player,PieceType.KING,row, 4);
            PieceFactory.make(player,PieceType.BISHOP,row, 5);
            PieceFactory.make(player,PieceType.KNIGHT,row, 6);
            PieceFactory.make(player,PieceType.ROOK,row, 7);

            //*************
            // PLAYER TWO
            //*************
            player = TurnManager.getInstance().next();
            row = 1;
            for (int x = 0; x < COLUMNS; x++) {
                PieceFactory.make(player, PieceType.PAWN, row, x);
            }
            row = 0;
            PieceFactory.make(player,PieceType.ROOK,row, 0);
            PieceFactory.make(player,PieceType.KNIGHT,row, 1);
            PieceFactory.make(player,PieceType.BISHOP,row, 2);
            PieceFactory.make(player,PieceType.QUEEN,row, 3);
            PieceFactory.make(player,PieceType.KING,row, 4);
            PieceFactory.make(player,PieceType.BISHOP,row, 5);
            PieceFactory.make(player,PieceType.KNIGHT,row, 6);
            PieceFactory.make(player,PieceType.ROOK,row, 7);

        } catch (InvalidMoveException e) {
            // Intentionally empty.
        }
    }

}
