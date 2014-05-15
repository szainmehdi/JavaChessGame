package course.rcc.cis18b.chess.Behaviors;

import course.rcc.cis18b.chess.Entities.Board;
import course.rcc.cis18b.chess.Entities.Piece;

public class KingMoveBehavior implements MoveBehavior {
    /**
     * Determine whether a move is legal according to the rules of each game.
     *
     * @param piece
     * @param row
     * @param column
     * @return
     */
    @Override
    public boolean isValidMove(Piece piece, int row, int column) {
        Board board = Board.getInstance();
        if(board.spaceExists(row, column)) {

            float rowDifference = Math.abs(row - piece.getRow());
            float columnDifference = Math.abs(column - piece.getColumn());

            // A king can only move one place at a time in all directions.
            return (rowDifference <= 1 && columnDifference <=1);

        } else {
            return false;
        }
    }
}
