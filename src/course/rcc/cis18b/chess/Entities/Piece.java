package course.rcc.cis18b.chess.Entities;

import course.rcc.cis18b.chess.Behaviors.MoveBehavior;
import course.rcc.cis18b.chess.Exceptions.InvalidMoveException;
import course.rcc.cis18b.chess.Exceptions.UnauthorizedMoveException;
import course.rcc.cis18b.chess.TurnManager;


public class Piece {

    /**
     * The piece's owner.
     */
    private Player player = null;

    /**
     * A path and filename to the graphic used to display the piece.
     */
    private String model = null;

    /**
     * What extension does the graphic use?
     */
    public static final String MODEL_EXTENSION = ".png";

    /**
     * Determine the behavior of this piece using this MoveBehavior.
     */
    private MoveBehavior moveBehavior = null;

    /**
     * Current Location
     */
    private int row;
    private int column;

    /**
     * What type of piece is this?
     */
    private PieceType type = null;

    public Piece(Player player, String model, MoveBehavior moveBehavior, int row, int column, PieceType type)
        throws InvalidMoveException {
        this.player = player;
        this.model = model;
        this.moveBehavior = moveBehavior;
        this.setLocation(row, column);
        this.type = type;
    }

    public Piece(Player player, String model, MoveBehavior moveBehavior, PieceType type) {
        this.player = player;
        this.model = model;
        this.moveBehavior = moveBehavior;
        this.type = type;
    }

    /**
     * Try to move the piece to a new location on the grid.
     * @param row
     * @param column
     * @throws InvalidMoveException
     * @throws UnauthorizedMoveException
     */
    public void move(int row, int column) throws InvalidMoveException, UnauthorizedMoveException {
        if(this.player == TurnManager.getInstance().currentPlayer()) {
            Space space = Board.getInstance().getSpace(row, column);
            if (this.moveBehavior.isValidMove(this, row, column)) {
                if (space.isEmpty()) {
                    Board.getInstance().getSpace(this.row, this.column).pop();
                    setLocation(row, column);
                } else if (space.getPiece().getPlayer() != TurnManager.getInstance().currentPlayer()) {
                    // kill the piece here

                    // move current piece to this space
                } else {
                    throw new InvalidMoveException("Cannot move to this space: (" +
                            row + ", " + column + ")");
                }
            } else {
                throw new InvalidMoveException("Cannot move to this location.");
            }
        } else {
            throw new UnauthorizedMoveException("This piece does not belong to the current player.");
        }
    }

    /**
     * Set the row of the piece.
     * @param row
     * @throws InvalidMoveException
     */
    public void setRow(int row) throws InvalidMoveException {
        this.setLocation(row, this.column);
    }

    /**
     * Set the column of the piece.
     * @param column
     * @throws InvalidMoveException
     */
    public void setColumn(int column) throws InvalidMoveException {
        this.setLocation(this.row, column);
    }

    /**
     * Get the current row of the piece.
     * @return Current row location.
     */
    public int getRow() {
        return row;
    }

    /**
     * Set the current row of the piece.
     * @return
     */
    public int getColumn() {
        return column;
    }

    /**
     * Internal function
     *
     * Update the location record of the piece with new coordinates.
     * @param row
     * @param column
     * @throws InvalidMoveException
     */
    private void setLocation(int row, int column) throws InvalidMoveException {
        try {
            Space space = Board.getInstance().getSpace(row, column);
            if(space.isEmpty()) {
                this.row = row;
                this.column = column;
                space.push(this);
            } else {
                throw new InvalidMoveException("The space at ("
                        + row + ", " + column + ") isn't empty. \n"
                        + "It is occupied by a " + space.getPiece().toString());
            }
        } catch (IndexOutOfBoundsException e) {
            throw new InvalidMoveException("The space doesn't exist.");
        }

    }

    /**
     * Get the owner of the piece.
     * @return
     */
    public Player getPlayer() {
        return player;
    }

    /**
     * Returns the image associated with the piece.
     * @return file name with extension and path.
     */
    public String getModel() {
        return model;
    }

    /**
     * Set a new model for the piece.
     * @param model
     */
    public void setModel(String model) {
        this.model = model;
    }

    /**
     * For console output, get a one-letter representation of the piece.
     * @return
     */
    public char getAbbreviation() {
        switch (type) {
            case KING: return 'K';
            case KNIGHT: return 'N';
            case QUEEN: return 'Q';
            case BISHOP: return 'B';
            case PAWN: return 'P';
            case ROOK: return 'R';
            default: return 'X';
        }
    }

    /**
     * Debug only.
     * @return
     */
    @Override
    public String toString() {
        return "Piece {" +
                "player=" + player +
                ", model='" + model + '\'' +
                ", moveBehavior=" + moveBehavior +
                ", row=" + row +
                ", column=" + column +
                ", type=" + type +
                '}';
    }
}