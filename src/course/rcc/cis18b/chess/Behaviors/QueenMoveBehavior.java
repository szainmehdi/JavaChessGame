package course.rcc.cis18b.chess.Behaviors;

import course.rcc.cis18b.chess.Entities.Board;
import course.rcc.cis18b.chess.Entities.Piece;

public class QueenMoveBehavior implements MoveBehavior {
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

            // A queen can move diagonally, or perfectly straight in any direction.


            if((rowDifference == columnDifference) && (rowDifference > 0 && rowDifference > 0)) {
                // Diagonal move
                return true;
            } else if(columnDifference == 0 && rowDifference > 0) {
                // Straight up or down
                return true;
            } else if(rowDifference == 0 && columnDifference > 0) {
                // Straight left or right
                return true;
            } else {
                return false;
            }

        } else {
            return false;
        }
    }
}
