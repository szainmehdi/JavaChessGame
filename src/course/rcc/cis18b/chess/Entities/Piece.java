package course.rcc.cis18b.chess.Entities;

import course.rcc.cis18b.chess.Application;
import course.rcc.cis18b.chess.Behaviors.MoveBehavior;
import course.rcc.cis18b.chess.Exceptions.InvalidMoveException;
import course.rcc.cis18b.chess.Exceptions.UnauthorizedMoveException;
import course.rcc.cis18b.chess.TurnManager;


public class Piece {

    private Player player = null;
    private String model = null;
    private MoveBehavior moveBehavior = null;
    private int row;
    private int column;
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
            }
        } else {
            throw new UnauthorizedMoveException("This piece does not belong to the current player.");
        }
    }

    public void setRow(int row) throws InvalidMoveException {
        this.setLocation(row, this.column);
    }

    public void setColumn(int column) throws InvalidMoveException {
        this.setLocation(this.row, column);
    }

    public int getRow() {
        return row;
    }

    public int getColumn() {
        return column;
    }

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

    public Player getPlayer() {
        return player;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

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